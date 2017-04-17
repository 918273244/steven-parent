package com.steven.gantt.prodiver;

import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.util.StringUtil;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by Steven on 2017/3/30.
 */
public class RoadMapProvider {


    /**
     * 创建roadMap
     * @param map
     * @return
     */
    public  String saveRoadMap(Map<String, RoadMap> map){
        SQL sql=new SQL();
        RoadMap roadMap = map.get("roadMap");
        sql.INSERT_INTO("ROADMAP");
        sql.VALUES("ID","#{roadMap.id}");
//        sql.VALUES("ID","SEQ_ROADMAP.NEXTVAL");
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadNo())) {
            sql.VALUES("ROADNO","#{roadMap.roadNo}");
        }
            sql.VALUES("CREATEDDATE","sysdate");
        if (!StringUtil.isNullOrEmpty(roadMap.getCreatedBy())) {
            sql.VALUES("CREATEDBY","#{roadMap.createdBy}");
        }
        if (!StringUtil.isNullByLong(roadMap.getCreatedUserId())) {
            sql.VALUES("CREATEDUSERID","#{roadMap.createdUserId}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getDepartmentName())) {
            sql.VALUES("DEPARTMENTNAME","#{roadMap.departmentName}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCreateUserNo())) {
            sql.VALUES("CREATEUSERNO","#{roadMap.createUserNo}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getMobile())) {
            sql.VALUES("MOBILE","#{roadMap.mobile}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEmail())) {
            sql.VALUES("EMAIL","#{roadMap.email}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadName())) {
            sql.VALUES("ROADNAME","#{roadMap.roadName}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadType())) {
            sql.VALUES("ROADTYPE","#{roadMap.roadType}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadLevel())) {
            sql.VALUES("ROADLEVEL","#{roadMap.roadLevel}");
        }
        if (!StringUtil.isNullByInt(roadMap.getNewLookFlag())) {
            sql.VALUES("NEWLOOKFLAG","#{roadMap.newLookFlag}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadPriority())) {
            sql.VALUES("ROADPRIORITY","#{roadMap.roadPriority}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getAppearanceForm())) {
            sql.VALUES("APPEARANCEFORM","#{roadMap.appearanceForm}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getHardwarePlatform())) {
            sql.VALUES("HARDWAREPLATFORM","#{roadMap.hardwarePlatform}");
        }
        if (!StringUtil.isNullByDate(roadMap.getPlanStartTime())) {
            sql.VALUES("PLANSTARTTIME","#{roadMap.planStartTime}");
        }
        if (!StringUtil.isNullByDate(roadMap.getPlanPublishTime())) {
            sql.VALUES("PLANPUBLISHTIME","#{roadMap.planPublishTime}");
        }
        if (!StringUtil.isNullByInt(roadMap.getMarketPosition())) {
            sql.VALUES("MARKETPOSITION","#{roadMap.marketPosition}");
        }
        if (!StringUtil.isNullByInt(roadMap.getTargetedMarket())) {
            sql.VALUES("TARGETEDMARKET","#{roadMap.targetedMarket}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getTypicalCustomers())) {
            sql.VALUES("TYPICALCUSTOMERS","#{roadMap.typicalCustomers}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getExpectedLifeCycle())) {
            sql.VALUES("EXPECTEDLIFECYCLE","#{roadMap.expectedLifeCycle}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedSalesVolume())) {
            sql.VALUES("ESTIMATEDSALESVOLUME","#{roadMap.estimatedSalesVolume}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedSalesPrice())) {
            sql.VALUES("ESTIMATEDSALESPRICE","#{roadMap.estimatedSalesPrice}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedGrossMargin())) {
            sql.VALUES("ESTIMATEDGROSSMARGIN","#{roadMap.estimatedGrossMargin}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedRDExpenses())) {
            sql.VALUES("ESTIMATEDRDEXPENSES","#{roadMap.estimatedRDExpenses}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedSalesAmount())) {
            sql.VALUES("ESTIMATEDSALESAMOUNT","#{roadMap.estimatedSalesAmount}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedGrossAmount())) {
            sql.VALUES("ESTIMATEDGROSSAMOUNT","#{roadMap.estimatedGrossAmount}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedInOut())) {
            sql.VALUES("ESTIMATEDINOUT","#{roadMap.estimatedInOut}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCoreContent())) {
            sql.VALUES("CORECONTENT","#{roadMap.coreContent}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getPerformance())) {
            sql.VALUES("PERFORMANCE","#{roadMap.performance}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCompetitionContent())) {
            sql.VALUES("COMPETITIONCONTENT","#{roadMap.competitionContent}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCustomerContent())) {
            sql.VALUES("CUSTOMERCONTENT","#{roadMap.customerContent}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadInheritName())) {
            sql.VALUES("ROADINHERITNAME","#{roadMap.roadInheritName}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadInheritId())) {
            sql.VALUES("ROADINHERITID","#{roadMap.roadInheritId}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadQuotesId())) {
            sql.VALUES("ROADQUOTESID","#{roadMap.roadQuotesId}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadQuotesName())) {
            sql.VALUES("ROADQUOTESNAME","#{roadMap.roadQuotesName}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadSupportID())) {
            sql.VALUES("ROADSUPPORTID","#{roadMap.roadSupportID}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadSupportName())) {
            sql.VALUES("ROADSUPPORTNAME","#{roadMap.roadSupportName}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadPlatformID())) {
            sql.VALUES("ROADPLATFORMID","#{roadMap.roadPlatformID}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadPlatformName())) {
            sql.VALUES("ROADPLATFORMNAME","#{roadMap.roadPlatformName}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadImage())) {
            sql.VALUES("ROADIMAGE","#{roadMap.roadImage}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getField1())) {
            sql.VALUES("FIELD1","#{roadMap.field1}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getField2())) {
            sql.VALUES("FIELD2","#{roadMap.field2}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField3())) {
            sql.VALUES("FIELD3","#{roadMap.field3}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField4())) {
            sql.VALUES("FIELD4","#{roadMap.field4}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField5())) {
            sql.VALUES("FIELD5","#{roadMap.field5}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField6())) {
            sql.VALUES("FIELD6","#{roadMap.field6}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField7())) {
            sql.VALUES("FIELD7","#{roadMap.field7}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField8())) {
            sql.VALUES("FIELD8","#{roadMap.field8}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getUploadFile())) {
            sql.VALUES("UPLOADFILE","#{roadMap.uploadFile}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadMapType())) {
            sql.VALUES("ROADMAPTYPE","#{roadMap.roadMapType}");
        }
        if (!StringUtil.isNullByLong(roadMap.getParentId())) {
            sql.VALUES("PARENTID","#{roadMap.parentId}");
        }
        sql.VALUES("TYPEFLAG","#{roadMap.typeFlag}");
        sql.VALUES("UPDATETIME","sysdate");
        return sql.toString();
    }

    public String updateRoadMap(Map<String, RoadMap> map){
        SQL sql=new SQL();
        RoadMap roadMap = map.get("roadMap");
        sql.UPDATE("ROADMAP");
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadName())) {
            sql.SET("ROADNAME=#{roadMap.roadName}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadLevel())) {
            sql.SET("ROADLEVEL=#{roadMap.roadLevel}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadType())) {
            sql.SET("ROADTYPE=#{roadMap.roadType}");
        }
        if (!StringUtil.isNullByInt(roadMap.getNewLookFlag())) {
            sql.SET("NEWLOOKFLAG=#{roadMap.newLookFlag}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadPriority())) {
            sql.SET("ROADPRIORITY=#{roadMap.roadPriority}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getAppearanceForm())) {
            sql.SET("APPEARANCEFORM=#{roadMap.appearanceForm}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getHardwarePlatform())) {
            sql.SET("HARDWAREPLATFORM=#{roadMap.hardwarePlatform}");
        }
        if (!StringUtil.isNullByDate(roadMap.getPlanStartTime())) {
            sql.SET("PLANSTARTTIME=#{roadMap.planStartTime}");
        }
        if (!StringUtil.isNullByDate(roadMap.getPlanPublishTime())) {
            sql.SET("PLANPUBLISHTIME=#{roadMap.planPublishTime}");
        }
        if (!StringUtil.isNullByInt(roadMap.getMarketPosition())) {
            sql.SET("MARKETPOSITION=#{roadMap.marketPosition}");
        }
        if (!StringUtil.isNullByInt(roadMap.getTargetedMarket())) {
            sql.SET("TARGETEDMARKET=#{roadMap.targetedMarket}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getTypicalCustomers())) {
            sql.SET("TYPICALCUSTOMERS=#{roadMap.typicalCustomers}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getExpectedLifeCycle())) {
            sql.SET("EXPECTEDLIFECYCLE=#{roadMap.expectedLifeCycle}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedSalesVolume())) {
            sql.SET("ESTIMATEDSALESVOLUME=#{roadMap.estimatedSalesVolume}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedSalesPrice())) {
            sql.SET("ESTIMATEDSALESPRICE=#{roadMap.estimatedSalesPrice}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedGrossMargin())) {
            sql.SET("ESTIMATEDGROSSMARGIN=#{roadMap.estimatedGrossMargin}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedRDExpenses())) {
            sql.SET("ESTIMATEDRDEXPENSES=#{roadMap.estimatedRDExpenses}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedSalesAmount())) {
            sql.SET("ESTIMATEDSALESAMOUNT=#{roadMap.estimatedSalesAmount}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedGrossAmount())) {
            sql.SET("ESTIMATEDGROSSAMOUNT=#{roadMap.estimatedGrossAmount}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getEstimatedInOut())) {
            sql.SET("ESTIMATEDINOUT=#{roadMap.estimatedInOut}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCoreContent())) {
            sql.SET("CORECONTENT=#{roadMap.coreContent}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getPerformance())) {
            sql.SET("PERFORMANCE=#{roadMap.performance}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCompetitionContent())) {
            sql.SET("COMPETITIONCONTENT=#{roadMap.competitionContent}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getCustomerContent())) {
            sql.SET("CUSTOMERCONTENT=#{roadMap.customerContent}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadInheritName())) {
            sql.SET("ROADINHERITNAME=#{roadMap.roadInheritName}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadInheritId())) {
            sql.SET("ROADINHERITID=#{roadMap.roadInheritId}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadQuotesId())) {
            sql.SET("ROADQUOTESID=#{roadMap.roadQuotesId}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadQuotesName())) {
            sql.SET("ROADQUOTESNAME=#{roadMap.roadQuotesName}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadSupportID())) {
            sql.SET("ROADSUPPORTID=#{roadMap.roadSupportID}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadSupportName())) {
            sql.SET("ROADSUPPORTNAME=#{roadMap.roadSupportName}");
        }
        if (!StringUtil.isNullByLong(roadMap.getRoadPlatformID())) {
            sql.SET("ROADPLATFORMID=#{roadMap.roadPlatformID}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadPlatformName())) {
            sql.SET("ROADPLATFORMNAME=#{roadMap.roadPlatformName}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getRoadImage())) {
            sql.SET("ROADIMAGE=#{roadMap.roadImage}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getField1())) {
            sql.SET("FIELD1=#{roadMap.field1}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getField2())) {
            sql.SET("FIELD2=#{roadMap.field2}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField3())) {
            sql.SET("FIELD3=#{roadMap.field3}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField4())) {
            sql.SET("FIELD4=#{roadMap.field4}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField5())) {
            sql.SET("FIELD5=#{roadMap.field5}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField6())) {
            sql.SET("FIELD6=#{roadMap.field6}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField7())) {
            sql.SET("FIELD7=#{roadMap.field7}");
        } if (!StringUtil.isNullOrEmpty(roadMap.getField8())) {
            sql.SET("FIELD8=#{roadMap.field8}");
        }
        if (!StringUtil.isNullOrEmpty(roadMap.getUploadFile())) {
            sql.SET("UPLOADFILE=#{roadMap.uploadFile}");
        }
        if (!StringUtil.isNullByInt(roadMap.getRoadMapType())) {
            sql.VALUES("ROADMAPTYPE","#{roadMap.roadMapType}");
        }
        if (!StringUtil.isNullByLong(roadMap.getParentId())) {
            sql.VALUES("PARENTID","#{roadMap.parentId}");
        }
        sql.SET("UPDATETIME=sysdate");
        sql.WHERE("ID = #{roadMap.id}");
        return sql.toString();
    }


    public String getRoadMapIdByParentId(Map<String, Object> map){
        String id = (String) map.get("id");
        StringBuffer sb = new StringBuffer("select ID, nvl(STATUS,'U') as status from roadmap where PARENTID in ( ");
        sb.append(id);
        sb.append(" )");
        return sb.toString();
    }


    public String deleteRoadMapById(Map<String, Object> map){
        String id = (String) map.get("id");
        StringBuffer sb = new StringBuffer("delete from roadmap where  id  in ( ");
//        StringBuffer sb = new StringBuffer("delete from roadmap where ROADMAPTYPE = 1 and id  in ( ");
        sb.append(id);
        sb.append(" )");
        return sb.toString();
    }


    public String  getDirectoryId(Map<String, Object> map){
        String id = (String) map.get("id");
        StringBuffer sb = new StringBuffer("select id from roadmap where id in ( ");
//        StringBuffer sb = new StringBuffer("delete from roadmap where ROADMAPTYPE = 1 and id  in ( ");
        sb.append(id);
        sb.append(" ) and roadMapType = 0 ");
        return sb.toString();
    }
    public String  getVersionId(Map<String, Object> map){
        String id = (String) map.get("id");
        StringBuffer sb = new StringBuffer("select id from roadmap where id ( ");
//        StringBuffer sb = new StringBuffer("delete from roadmap where ROADMAPTYPE = 1 and id  in ( ");
        sb.append(id);
        sb.append(" ) and roadMapType = 1 ");
        return sb.toString();
    }

}
