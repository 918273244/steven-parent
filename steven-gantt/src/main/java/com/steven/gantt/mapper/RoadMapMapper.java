package com.steven.gantt.mapper;

import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.entity.RoadMapLog;
import com.steven.gantt.prodiver.RoadMapProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by Steven on 2017/3/30.
 */
@Mapper
public interface RoadMapMapper {
    @Select("select ID, ROADNO, PARENTID,case roadMapType when 0 then 'root' when 1 then 'leaf' end as roadMapTypeValue from ROADMAP")
    public List<RoadMap> getRoadMapList();

//    @InsertProvider(method = "saveRoadMap",type =RoadMapProvider.class )
//    public int saveRoadMap(@Param("roadMap") RoadMap roadMap);

    /**
     * insert数据
     * @param roadMap
     * @return
     */
  /*  @SelectKey(before = true, keyProperty = "roadMap.id", resultType = long.class, statement = { "select SEQ_ROADMAP.nextval from dual" },statementType= StatementType.STATEMENT)
    @InsertProvider(type=RoadMapProvider.class,method="saveRoadMap")
    @Options(useGeneratedKeys = true, keyProperty = "roadMap.id")
*/


    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="roadMap.id", before=true, resultType=long.class)
    @InsertProvider(type=RoadMapProvider.class,method="saveRoadMap")
    public int saveRoadMap(@Param("roadMap") RoadMap roadMap);

    @Select("select roadNo, date_format(createdDate,'yyyy-mm-dd') as createdDateValue, createdBy, departmentName,createUserNo,mobile,email,roadName, case roadType when 1 then '产品开发路标' when 2 then '技术平台开发路标' when 3 then '技术预研路标' when 4 then '解决方案路标' end as roadTypeValue, " +
            " case roadLevel when 0 then '是' when 1 then '产品系列' when 2 then '产品子系列' when 3 then '产品' when 4 then '版本' end as loadLevelValue, case newLookFlag when 0 then '是' when 1 then '否' when 2 then '不涉及' end as newLookFlagValue, " +
            "case roadPriority when 1 then '很高' when 2 then '高' when 3 then '中' when 4 then '低' end as roadPriorityValue, appearanceForm, hardwarePlatform, date_format(planStartTime ,'yyyy-mm-dd') as planStartTimeValue, date_format(planPublishTime ,'yyyy-mm-dd') as planPublishTimeValue, " +
            " case marketPosition when 0 then '高端' when 1 then '中端' when 2 then '低端' end as  marketPositionValue, case targetedMarket when 0 then '行业市场' when 1 then '项目市场' when 2 then '分销市场' end as targetedMarketValue, typicalCustomers, expectedLifeCycle, estimatedSalesVolume, estimatedSalesPrice, estimatedGrossMargin, estimatedRDExpenses, estimatedSalesAmount," +
            "estimatedGrossAmount, estimatedInOut, coreContent, performance, competitionContent, customerContent, roadInheritName, roadQuotesName, roadSupportName, roadImage,roadPlatformName, field1, field2, field3, field4, field5, field6, field7, field8, uploadFile,IFNULL(STATUS,'U') as STATUS, roadMapType, TYPEFLAG from ROADMAP where id = #{id} " )
    public RoadMap getRoadMapDetailById(@Param("id") long id);


    @Select("select ROADMAPTYPE, roadNo, date_format(createdDate,'yyyy-mm-dd') as createdDateValue, createdBy, departmentName,createUserNo,mobile,email,roadName,  roadType, " +
            "  roadLevel,  newLookFlag,  roadPriority , appearanceForm, hardwarePlatform, date_format(planStartTime ,'yyyy-mm-dd') as planStartTimeValue, date_format(planPublishTime ,'yyyy-mm-dd') as planPublishTimeValue, " +
            "  marketPosition ,  targetedMarket , typicalCustomers, expectedLifeCycle, estimatedSalesVolume, estimatedSalesPrice, estimatedGrossMargin, estimatedRDExpenses, estimatedSalesAmount," +
            "estimatedGrossAmount, estimatedInOut, coreContent, performance, competitionContent, customerContent, roadInheritName, roadQuotesName, roadSupportName,roadPlatformName, roadImage, field1, field2, field3, field4, field5, field6, field7, field8, uploadFile,IFNULL(STATUS,'U') as STATUS, TYPEFLAG  from ROADMAP where id = #{id} " )
    public RoadMap getRoadMapInfoDataById(@Param("id") long id);

    /**
     * 更新数据
     * @param roadMap
     * @return
     */
    @UpdateProvider(method = "updateRoadMap",type =RoadMapProvider.class )
    public int updateRoadMap(@Param("roadMap") RoadMap roadMap);

    /**
     * 通过id删除roadMap
     * @param id
     * @return
     */
//    @Delete("delete from roadmap where ROADMAPTYPE = 1 and id = #{id}")
    @DeleteProvider(method = "deleteRoadMapById",type =RoadMapProvider.class )
    public int deleteRoadMapById(@Param("id") String id);

    @Select("select roadMapType from roadmap where id = #{id} ")
    public String getRoadTypeById(@Param("id") long id);

    /**
     * 根据父节点查询所有子节点
     * @param id
     * @return
     */
    @SelectProvider(method = "getRoadMapIdByParentId",type =RoadMapProvider.class)
    public List<RoadMap> getRoadMapIdByParentId(@Param("id") String id);

    /**
     * 获取roadMapNo
     * @return
     */
    @Select("select  RMSERIESNO() from dual")
    public String getRoadMapNo();

    /**
     * 根据id获取roadmapname
     * @param id
     * @return
     */
    @Select("select ROADNO from roadMap where id = #{id}")
    public String getRoadMapNameById(@Param("id") long id);

    /**
     * 插入日志信息
     * @param username
     * @param operation
     * @param operationcontent
     * @return
     */
    @Insert("insert into ROADMAPLOG (CREATETIME,CREATEUSER,OPERATION,OPERATIONCONTENT) values (now(),#{username},#{operation},#{operationcontent})")
    public int addRoadMapLog(@Param("username") String username, @Param("operation") String operation, @Param("operationcontent") String operationcontent);

    /**
     * 获取roadMapLog日志列表
     * @param startIndex
     * @param endIndex
     * @return
     */
    @Select("  SELECT A.ID,A.CREATEUSER,A.OPERATIONCONTENT,date_format(A.CREATETIME,'yyyy-mm-dd hh24:mi:ss') as CREATETIME,A.OPERATION from roadmaplog A order by A.id desc  limit  #{startIndex}, #{endIndex}  ")
    public List<RoadMapLog> roadMapLogData(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);


    @Select("select count(1) from roadmaplog")
    public int getRoadMapLogNum();

    /**
     * 获取roadmap信息
     * @param id
     * @return
     */
    @Select("select * from roadmap where id = #{id}")
    public RoadMap getRoadMapAllInfoById(@Param("id") long id);

    /***
     * 通过parentId获取所有roadmap
     * @return
     */
    @Select("select * from roadmap where PARENTID = #{id}")
    public List<RoadMap> getRoamMapAllInfoByParentId(@Param("id") long id);

    /**
     * 获取目录的id
     * @param id
     * @return
     */
    @SelectProvider(method = "getDirectoryId",type =RoadMapProvider.class)
    public List<Integer> getDirectoryId(@Param("id") String id);

    /**
     * 获取版本的id
     * @param id
     * @return
     */
    @SelectProvider(method = "getVersionId",type =RoadMapProvider.class)
    public List<Integer> getVersionId(@Param("id") String id);
}
