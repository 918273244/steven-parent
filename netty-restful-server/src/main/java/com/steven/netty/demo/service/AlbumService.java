package com.steven.netty.demo.service;


import com.steven.netty.demo.bo.Star;
import com.steven.netty.demo.entity.Album;
import com.steven.netty.demo.entity.User;
import com.steven.netty.nettyrest.ApiProtocol;

/**
 * Created by zhoumengkang on 4/1/16.
 */
public class AlbumService extends BaseService {

    public AlbumService(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Album get(int id, int uid) {
        User   user  = new User(uid, "mengkang", 25);
        String cover = "http://static.mengkang.net/view/images/avatar/1.jpg";
        Star   star  = new Star(120, true);

        return new Album(id, user, cover, star);
    }
}
