package com.steven.netty.demo.bo;


import com.steven.netty.demo.entity.Album;
import com.steven.netty.nettyrest.response.Info;

/**
 * Created by zhoumengkang on 5/1/16.
 */
public class AlbumInfo extends Info {
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public AlbumInfo(Album album) {
        this.album = album;
    }
}
