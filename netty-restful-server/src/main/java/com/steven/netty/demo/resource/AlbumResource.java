package com.steven.netty.demo.resource;


import com.steven.netty.demo.bo.AlbumInfo;
import com.steven.netty.demo.service.AlbumService;
import com.steven.netty.nettyrest.ApiProtocol;
import com.steven.netty.nettyrest.BaseResource;
import com.steven.netty.nettyrest.response.Info;
import com.steven.netty.nettyrest.response.Result;

public class AlbumResource extends BaseResource {

    public AlbumResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Result get() {

        int uid, aid;

        Object uidCheck = parameterIntCheck(apiProtocol, "uid");
        if (uidCheck instanceof Result) {
            return (Result) uidCheck;
        } else {
            uid = (int) uidCheck;
        }

        Object aidCheck = parameterIntCheck(apiProtocol,"aid");
        if (aidCheck instanceof Result){
            return (Result) aidCheck;
        }else {
            aid = (int) aidCheck;
        }

        AlbumService albumService = new AlbumService(apiProtocol);

        return new Result<Info>(new AlbumInfo(albumService.get(aid,uid)));
    }
}
