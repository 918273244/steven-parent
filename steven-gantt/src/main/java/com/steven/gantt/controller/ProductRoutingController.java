package com.steven.gantt.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.steven.gantt.entity.RmtSys;
import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.service.RoadMapService;
import com.steven.gantt.service.SystemService;
import com.steven.gantt.util.SingleRoadMapLists;
import com.steven.gantt.util.WebForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 端对端任务
 * @author cdd
 *
 */
@Controller
@RequestMapping("/productRouting")
public class ProductRoutingController {
	@Resource
	private SystemService systemService;

	@Resource
	private RoadMapService roadMapService;

	@Resource
    private RoadMap roadMapOne;

	private static final Logger log = LoggerFactory.getLogger(ProductRoutingController.class);

	@RequestMapping("/detail")
	public ModelAndView createTaskPage(ModelAndView model, HttpServletRequest request){
		List<RmtSys> sysList = systemService.getAllRmtList();
        List<RoadMap> roadMapList = roadMapService.getRoadMapList();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (RmtSys rmt: sysList) {
			sb.append("{");
			sb.append("\"id\":\""  + rmt.getId()+"\"");
			sb.append(",\"parent\":\"#\"" );
			sb.append(",\"text\":\""  + rmt.getRmtName()+"\"");
			sb.append(",\"type\":\"root\"" );
			sb.append("},");
		}
        for (RoadMap roadMap:roadMapList) {
            sb.append("{");
            sb.append("\"id\":\""  + roadMap.getId()+"\"");
            sb.append(",\"parent\":\""  + roadMap.getParentId()+"\"");
            sb.append(",\"text\":\""  + roadMap.getRoadNo()+"\"");
            sb.append(",\"type\":\""  + roadMap.getRoadMapTypeValue()+"\"");
            sb.append("},");
        }
        sb.setLength(sb.length()-1);
		sb.append("]");


//		String roadmap_no = roadMapService.getRoadMapNo();
		model.addObject("treeJson",sb.toString());
        model.addObject("todayTime",ProductRoutingController.getTodayDate());
//        model.addAttribute("roadMap_No",roadmap_no);
        model.setViewName("productRouting/productRoutingDetail");
		return model;
	}

	@RequestMapping("/getData.do")
	@ResponseBody
	public String getProductRoutingData(ModelAndView model, HttpServletRequest request){
		List<RmtSys> sysList = systemService.getAllRmtList();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (RmtSys rmt: sysList) {
			sb.append("{");
			sb.append("\"id\":\""  + rmt.getId()+"\"");
			sb.append(",\"parent\":\"#\"" );
			sb.append(",\"text\":\""  + rmt.getRmtName()+"\"");
			sb.append(",\"type\":\"root\"" );
			sb.append("},");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
//		return "[{'id' : '1','parent' : '#','text' : 'IPC','type' : 'root'},]";
//		return "[{\"id\" :\"1\",\"parent\" : \"#\",\"text\" : \"IPC\",\"type\" : \"root\"},]";
		return sb.toString();
	}

    /**
     * 创建目录或者版本
     * @param model
     * @param request
     * @return
     */
	@RequestMapping("/saveOrUpdate.do")
    @ResponseBody
    public int saveOrUpdate(ModelAndView model, HttpServletRequest request){
        WebForm webForm = new WebForm();
        RoadMap roadMap = webForm.toPo(request,RoadMap.class);
        int count = 0;
        count = roadMapService.saveRoadMap(roadMap);
        //获取路径目录
        long roadMap_id = roadMap.getId();
        if (roadMap.getRoadQuotesName()!=null && roadMap.getRoadQuotesName().length()>0){
           List<Integer> integerList =  roadMapService.getDirectoryId(roadMap.getRoadQuotesName());
            for (Integer i:integerList) {
                RoadMap roadQuotesRoadMap = roadMapService.getRoadMapAllInfoById(i);
                long oldId = roadQuotesRoadMap.getId();
                roadQuotesRoadMap.setTypeFlag(false);
                roadQuotesRoadMap.setParentId(roadMap_id);
                roadMapService.saveRoadMap(roadQuotesRoadMap);
                recursiveRoadMap(oldId,roadQuotesRoadMap.getId());
            }

            List<Integer> integerVersionList =  roadMapService.getVersionId(roadMap.getRoadQuotesName());
            for (Integer k:integerVersionList) {
                RoadMap roadQuotesRoadMap = roadMapService.getRoadMapAllInfoById(k);
                roadQuotesRoadMap.setTypeFlag(false);
                roadQuotesRoadMap.setParentId(roadMap_id);
                roadMapService.saveRoadMap(roadQuotesRoadMap);
            }

        }
        return count;
    }

    @RequestMapping("/getRoadMapData.do")
    public String getRoadMapData(ModelAndView model, HttpServletRequest request){
    	String id = request.getParameter("id");
        RoadMap roadMap = roadMapService.getRoadMapDetailById(Long.parseLong(id));
        if (roadMap != null) {
            model.addObject("roadMap",roadMap);
        }else{
            model.addObject("roadMap",roadMapOne);
        }

        return "productRouting/roadMapDetail";

    }

    /**
     * 获取路标详情
     * @param model
     * @param request
     * @return
     */
	@RequestMapping("/getRoadMapInfoDataById.do")
    public String getRoadMapInfoDataById(ModelAndView model, HttpServletRequest request){
    	String id = request.getParameter("id");
        RoadMap roadMap = roadMapService.getRoadMapInfoDataById(Long.parseLong(id));
        model.addObject("roadMap",roadMap);
        model.addObject("saveOrUpdateType","update");
        model.addObject("roadMapId",id);
        if (roadMap!= null && !roadMap.getTypeFlag()){
            model.addObject("typeFlag","1");
        }else{
            model.addObject("typeFlag","0");
        }
        return "productRouting/updateRoadMapInfo";
	}

    /**
     * 创建页面跳转
     * @param model
     * @param request
     * @return
     */
	@RequestMapping("/createRoadMapInfo.do")
    public String createRoadMapInfo(ModelAndView model, HttpServletRequest request, String id){
	    long rmtId = Long.parseLong(id);
	    String typeFlag = "1";
	    if(rmtId<100000){
	        RmtSys rmtSys = systemService.getRmtById(rmtId);
            //false表示解决方案
            if (!rmtSys.getTypeFlag()){
                //0表示解决方案
                typeFlag = "0";
            }
        }
        RoadMap roadMap = roadMapService.getRoadMapInfoDataById(rmtId);
        if( roadMap != null && roadMap.getRoadMapType() == 1){
            return "productRouting/tips";
        }else {
            if (roadMap != null && !roadMap.getTypeFlag()){
                //0表示解决方案
                typeFlag = "0";
            }
            model.addObject("roadMap",roadMapOne);
            model.addObject("saveOrUpdateType","save");
            model.addObject("typeFlag",typeFlag);
            model.addObject("todayTime",ProductRoutingController.getTodayDate());
            model.addObject("roadMap_No",roadMapService.getRoadMapNo());
            return "productRouting/updateRoadMapInfo";
        }

	}

    /**
     * 更新目录或者版本
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/updateRoadMap.do")
    @ResponseBody
    public int updateRoadMap(ModelAndView model, HttpServletRequest request){
       WebForm webForm = new WebForm();
        RoadMap roadMap = webForm.toPo(request,RoadMap.class);
        int count = 0;
        count = roadMapService.updateRoadMap(roadMap);
        return count;


    }


    @RequestMapping("/deleteRoadMapById.do")
    @ResponseBody
    public String deleteRoadMapById(ModelAndView model, HttpServletRequest request, String id){
        SingleRoadMapLists.getInstance().clear();
        List<RoadMap> roadMapList = roadMapService.getRoadMapIdByParentId(id);
        RoadMap roadMap = roadMapService.getRoadMapInfoDataById(Long.parseLong(id));
        if(roadMapList != null && roadMapList.size()>0){
            int count = 0;
            if (roadMap.getStatus().equals("C")) {
                count++;
            }
            StringBuffer sb = new StringBuffer("");
            sb.append(id+",");
            for (RoadMap r:
            inRoadMapList(roadMapList)) {
                if(r.getStatus().equals("C")){
                    count++;
                }
                sb.append(r.getId()+",");
            }
            sb.setLength(sb.length()-1);
            if (count == 0){
                roadMapService.deleteRoadMapById(sb.toString());
                return "删除成功";
            }else {
                return "不能删除已经审核通过的路标";
            }
        }else {
            if (roadMap == null) {
                return "不能删除根目录";
            }else if(roadMap.getStatus().equals("C")){
                return "不能删除已经审核通过的路标";
            }else {
                roadMapService.deleteRoadMapById(id);
                return "删除成功";
            }


        }
    }


    @RequestMapping(value = "/roadMapLogData.do",method = RequestMethod.POST)
    @ResponseBody
    public String roadMapLogData(ModelAndView model,  int page, int rows){
        int startIndex = (page - 1) * rows;
        int endIndex = startIndex + rows;
        JSONObject jsonObject = null;
        try {
            jsonObject =  roadMapService.roadMapLogData(startIndex,endIndex,page,rows);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject == null ? "" : jsonObject.toString();
    }

    public JSONArray getGantt(ModelAndView model, HttpServletRequest request, Date planStartDate, Date releaseDate, String type){

        return null;
    }

    public List<RoadMap> inRoadMapList( List<RoadMap> roadMaps){
        if(roadMaps == null || roadMaps.size() ==0){
            return SingleRoadMapLists.getInstance();
        }else{
            StringBuffer sb = new StringBuffer("");
            for (RoadMap roadMap:
                    roadMaps) {
                sb.append(roadMap.getId()+",");
                SingleRoadMapLists.getInstance().add(roadMap);
            }
            sb.setLength(sb.length()-1);
            return inRoadMapList(roadMapService.getRoadMapIdByParentId(sb.toString()));
        }
    }

    public static String getTodayDate(){
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        return dateFormater.format(date);
    }




    public  void recursiveRoadMap(long oldParentId, long newParentId){

            //通过parentId获取下面的项目
            for (RoadMap map:roadMapService.getRoamMapAllInfoByParentId(oldParentId)) {
                long id = map.getId();
                map.setTypeFlag(false);
                map.setParentId(newParentId);
                roadMapService.saveRoadMap(map);
                recursiveRoadMap( id,map.getId());
            }
    }

    @RequestMapping("/restview")
    public ModelAndView restView(ModelAndView view){
        view.addObject("hello","word");
        view.setViewName( "productRouting/rest");
        return view;
    }

}
