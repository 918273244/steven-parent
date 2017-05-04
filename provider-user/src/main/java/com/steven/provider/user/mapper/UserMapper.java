package com.steven.provider.user.mapper;



import com.steven.provider.user.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * userMapper
 * Created by Steven on 2017/4/16.
 */
@Mapper
public interface UserMapper {

    /**
     * 通过username获取users
     * @param username
     * @return
     */
    @Select("select * from users WHERE USERNAME =#{username}")
    public User findByUsername(@Param("username") String username);

    @Insert("insert into users (USERNAME, USERPASSWORD, ROLE) values (#{username}, #{password}, #{role})")
    public int saveUser(@Param("username") String username, @Param("password") String password, @Param("role") String role);



    /*@Insert("insert into announcement (lastUpdateTime,seo_KeyWord,seo_Description,seo_Title,title,content,showStatus,url,deleteStatus,addTime,userid,status,fileName,info,sequence,advertPosId,lastUserId) "
            + "values (now(),#{announcement.seo_KeyWord},#{announcement.seo_Description},#{announcement.seo_Title},#{announcement.title},#{announcement.content},#{announcement.showStatus},#{announcement.url},#{announcement.deleteStatus},now(),#{announcement.userid},#{announcement.status},#{announcement.fileName},#{announcement.info},#{announcement.sequence},#{announcement.advertPosId},#{announcement.lastUserId})")
    @SelectKey(statement="SELECT LAST_INSERT_ID() AS id", keyProperty="announcement.id", before=true, resultType=long.class)
    public void addAnnouncement(@Param("announcement") Announcement announcement);*/
}
