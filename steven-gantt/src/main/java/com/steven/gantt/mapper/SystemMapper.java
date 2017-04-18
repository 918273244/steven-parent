package com.steven.gantt.mapper;

import com.steven.gantt.entity.RmtSys;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by Steven on 2017/3/21.
 */
@Mapper
public interface SystemMapper {


    //新增假期
    @Insert("insert into HOLIDAYINFO(DATETIME,CREATETIME, id) values(#{dateTime},now(), SEQ_HOLIDAYINFO.NEXTVAL) ")
    long addHolidayByDate(@Param("dateTime") String date);

    //删除假期
    @Delete("delete from HOLIDAYINFO where DATETIME = #{dateTime}")
    long deleteHolidayByDate(@Param("dateTime") String date);

    @Select("select count(*)  from HOLIDAYINFO where DATETIME = #{dateTime}")
    int getHolidaySizeByDate(@Param("dateTime") String date);

    @Select("SELECT * FROM RMTSYS WHERE DELETESTATUS = 0 order by id desc limit #{startIndex},#{endIndex} ")
    List<RmtSys> getListData(@Param("startIndex") int startIndex, @Param("endIndex") int endIndex);

    @Select("select count(*) from RMTSYS where DELETESTATUS = '0'")
    int getRmtNum();

    @Insert("insert into RMTSYS(CREATETIME,RMTNAME, UPDATETIME) values( now() , #{rmtName}, now())")
    int addRmt(@Param("rmtName") String name);

    @Insert("update RMTSYS set DELETESTATUS = 1, UPDATETIME = now() where id = #{id}")
    int deleteRmtById(@Param("id") long id);

    @Select("select count(*) from RMTSYS where RMTNAME = #{rmtName} and DELETESTATUS = '0'")
    int existRmtByName(@Param("rmtName") String name);

    @Select("select id, RMTNAME from RMTSYS where  DELETESTATUS = 0 order by createTime desc")
    List<RmtSys> getAllRmtList();

    @Select("select id,rmtName from RMTSYS where DELETESTATUS = '0'")
	public List<RmtSys> getAllRmtSys();

    @Select("select RMTNAME, CREATETIME, TYPEFLAG from RMTSYS where id = #{id}")
    public RmtSys getRmtById(@Param("id") long id);



}
