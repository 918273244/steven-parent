package com.steven.controller;

import com.alibaba.fastjson.JSONObject;
import com.steven.util.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: Steven 孙
 * @Date: 2019/10/21 11:44
 * @Description:
 */
@Controller
@RequestMapping(value = "cmppPhone")
public class GetCmppPhoneController {

    String getCmppPhoneUrl = "https://www.cmpassport.com/unisdk/rsapi/loginTokenValidate";
    String loginValidateUrl = "https://www.cmpassport.com/openapi/rs/tokenValidate";
    String appid = "300011943360";
    String APPSecret = "F6E1E425E1B442AF88C734E5585CBD8C";
    String systemtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());


    /**
     * 根据token获取手机号
     * @param token
     * @return
     */
    @RequestMapping("getPhoneByToken")
    @ResponseBody
    public JSONObject getPhoneByToken(@RequestParam("token")String token){
        JSONObject result = new JSONObject();
        String msgid = UUID.randomUUID().toString();
        String version = "2.0";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version",version);
        String strictcheck = "0";
        jsonObject.put("msgid",msgid);
        jsonObject.put("systemtime",systemtime);
        jsonObject.put("strictcheck",strictcheck);
        jsonObject.put("appid",appid);
        jsonObject.put("token",token);
        String signStr = appid+version+msgid+systemtime+strictcheck+token+APPSecret;
        String sign = MD5Util.MD5(signStr);
        jsonObject.put("sign",sign);
        System.out.println(jsonObject.toString());
        JSONObject resJson = httpPost(getCmppPhoneUrl,jsonObject.toString());
        System.out.println(resJson.toString());
        result.put("resultCode","999");
        if(resJson != null){
            String resultCode = (String) resJson.get("resultCode");
            if(resultCode != null && resultCode.equals("103000")){
                result.put("resultCode","000");
                result.put("phone",(String)resJson.get("msisdn"));
            }
        }
        return result;
    }


    /**
     * 验证登录问题
     * @param token
     * @return
     */
    @RequestMapping("loginValidate")
    @ResponseBody
    public JSONObject loginValidate(@RequestParam("token")String token, @RequestParam("phoneNum")String phoneNum){
        JSONObject result = new JSONObject();
        JSONObject requestJson = new JSONObject();
        JSONObject headerJson = new JSONObject();
        String version = "1.0";
        headerJson.put("version",version);
        String msgid = UUID.randomUUID().toString();
        headerJson.put("msgId",msgid);
        headerJson.put("timestamp",systemtime);
        headerJson.put("appId",appid);

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("requesterType","1");
        String phone = MD5Util.getSHA256StrJava(phoneNum).toUpperCase();
        bodyJson.put("phoneNum",phone);
        bodyJson.put("token",token);
        String sign = appid+msgid+phone+systemtime+token+version;
        bodyJson.put("sign",MD5Util.getSHA256StrJava(sign).toUpperCase());

        requestJson.put("header",headerJson);
        requestJson.put("body",bodyJson);

        System.out.println(requestJson.toString());

        JSONObject resJson = httpPost(loginValidateUrl,requestJson.toString());

        if(resJson == null){
            result.put("resultCode","999");
            return result;
        }

        String bodyJsonStr = (String)resJson.get("body");
        String headerJsonStr = (String)resJson.get("header");
        JSONObject resHeaderJson = (JSONObject) JSONObject.parse(headerJsonStr);
        JSONObject resBodyJson = (JSONObject) JSONObject.parse(bodyJsonStr);
        result.put("resultCode",(String)resHeaderJson.get("resultCode"));
        result.put("resultDesc",(String)resBodyJson.get("resultDesc"));
        return result;
    }

    @RequestMapping("say")
    @ResponseBody
    public String say(){
        return "hello word";
    }


    @RequestMapping("get")
    @ResponseBody
    public JSONObject get(HttpServletRequest request, HttpServletResponse response){
        JSONObject resJson = new JSONObject();
        try {
            //设置编码集
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");

            //方法1 ，从消息体中取值
            //获取消息体内容
            BufferedReader reader = request.getReader();
            StringBuffer buffer = new StringBuffer();
            String temp = null;
            while((temp = reader.readLine()) != null){
                buffer.append(temp);
            }
            //进行URL解码
            String rspTtr = URLDecoder.decode(buffer.toString(),"utf-8");
            //返回处理后的消息体
//            response.getOutputStream().write(rspTtr.getBytes("UTF-8"));

            JSONObject object = JSONObject.parseObject(rspTtr);
            System.out.println(object.get("sign"));

            //header 部分
            JSONObject headerJson = new JSONObject();
            headerJson.put("appId","3000666666666");
            headerJson.put("timestamp","20180104090953788");
            headerJson.put("resultCode","000");
            headerJson.put("msgId","8ADFF305C7FCB3E1B1AECC130792FBD0");
            //body部分
            JSONObject bodyJson = new JSONObject();
            bodyJson.put("message","");
            bodyJson.put("resultDesc","是本机号码");
            bodyJson.put("taskId","b62585d15ee34869bd3c7e6ad62688e2");

            resJson.put("header",headerJson);
            resJson.put("body",bodyJson);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resJson;
    }

    @RequestMapping("getCmppPhone")
    @ResponseBody
    public JSONObject getCmppPhone(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            String jstr = sb.toString();
            //中文解码
            jstr = URLDecoder.decode(URLDecoder.decode(jstr, "utf-8"), "utf-8");
            System.out.println(jstr);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 发送http请求
     * 获取手机号
     */
    public JSONObject httpPost(String url, String jsonObj){
        HttpPost post = null;
        JSONObject dataJson = null;
        try{
            HttpClient httpClient = new DefaultHttpClient();
            // 设置超时时间
            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

            post = new HttpPost(url);
            // 构造消息头
            post.setHeader("Content-type", "application/json; charset=utf-8");
            post.setHeader("Connection", "Close");

            // 构建消息实体
            StringEntity entity = new StringEntity(jsonObj, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();

            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                String responseStr = EntityUtils.toString(responseEntity, "UTF-8");
                //最后获取数据
                dataJson  = (JSONObject) JSONObject.parse(responseStr);
                // 返回码中包含retCode及会话Id
                /*for(Header header : response.getAllHeaders()){
                    if(header.getName().equals("resultCode")){
                        resultCode = Integer.parseInt(header.getValue());
                    }
                    if(header.getName().equals("msgId")){
                        msgId = header.getValue();
                    }
                }*/
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(post != null){
                try {
                    post.releaseConnection();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        return dataJson;
    }

}
