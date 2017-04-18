package com.steven.gantt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.steven.gantt.entity.RmtSys;
import com.steven.gantt.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 系统管理
 * Created by Steven on 2017/3/21.
 */
@Controller
@RequestMapping("/system")
public class SystemController  {

    @Resource
    private SystemService systemService;
    
    
    /**
     * 节假日管理列表
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/holidaysList")
    public String holidayPage(Model model, HttpServletRequest request){
        return "system/holidaysList";
    }
    @RequestMapping("/cuserAuthority.html")
    public String cuserauthorityPage(Model model, HttpServletRequest request){
        return "system/cuserAuthority";
    }
    @RequestMapping("/eteUserAuthority.html")
    public String etduserauthorityPage(Model model, HttpServletRequest request){
        return "system/etdUserAuthority";
    }
    @RequestMapping("/deparmentArea.html")
    public String deparmentArea(Model model, HttpServletRequest request){
    	return "system/deparmentArea";
    }

	@RequestMapping("/updateHoliday")
	@ResponseBody
	public long updateHoliday(Model model, HttpServletRequest request, HttpServletResponse response, String type, String dateTime){
		long count = 0;
		if("add".equals(type)){
			if(systemService.getHolidaySizeByDate(dateTime)==0){
				count = systemService.addHolidayByDate(dateTime);
			}
		}else if("delete".equals(type)){
			count = systemService.deleteHolidayByDate(dateTime);
		}
		return count;
	}

    /**
     * 获取RMT列表
     */
    @RequestMapping(value="/rmtListData", method = RequestMethod.POST)
    @ResponseBody
    public String rmtList(Model model, HttpServletRequest request, int page, int rows){
        int startIndex = (page - 1) * rows;
        int endIndex = startIndex + rows;
        JSONObject jsonObject = null;
        try {
            jsonObject = systemService.getListData(startIndex, endIndex,page,rows);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject == null ? "" : jsonObject.toString();
    }

    /**
     * rmt页面跳转
     *
     */
    @RequestMapping("/rmtList")
    public String rmtList(Model model, HttpServletRequest request){
        return "rmtSys/rmtList";
    }
    

    /**
     * 新增rmt
     * @return
     */
    @RequestMapping(value="/addRmt",method = RequestMethod.POST)
    public String addRmt(Model model, HttpServletRequest request,
                         @RequestParam(value = "firstRmt", required=true) String firstRmt){
        if(systemService.existRmtByName(firstRmt.replace(" ",""))==0){
            systemService.addRmt(firstRmt.replace(" ",""));
        }
        return "redirect:rmtList";
    }

    /**
     * 删除rmt
     * */
    @RequestMapping(value="/deleteRmt",method = RequestMethod.POST)
    @ResponseBody
    public String deleteRmtById(Model model, HttpServletRequest request,
                                @RequestParam(value = "id", required=true) String id){
        String res = "";
        int num =systemService.deleteRmtById(Long.parseLong(id));
        if(num>0){
            res = "success";
        }else{
            res = "failure";
        }
        return res;
    }

    /**
     * 查找出所有的RMT
     * */
    @RequestMapping(value="/findAllRMTs",method = RequestMethod.POST)
    @ResponseBody
    public String findAllRMTs(){
        List<RmtSys> rmtSys=systemService.getAllRmtList();
        JSONObject object = new JSONObject();
        try {
            object.put("result", JSON.toJSON(rmtSys).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  object.toString();
    }


}
