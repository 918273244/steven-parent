package com.steven.netty.common.decoder.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * ByteBuf 转成 Bytes
 * Created by Steven on 2017/6/10.
 */
public class ByteBufToBytes {
    private ByteBuf temp;

    private boolean end = true;

    public ByteBufToBytes(){

    }

    public ByteBufToBytes(int length) {
        temp = Unpooled.buffer(length);
    }

    public void reading(ByteBuf datas) {
        datas.readBytes(temp, datas.readableBytes());
        if (this.temp.writableBytes() != 0) {
            end = false;
        } else {
            end = true;
        }
    }

    public boolean isEnd() {
        return end;
    }


    public byte[] read(ByteBuf datas) {
        byte[] bytes = new byte[datas.readableBytes()];
        datas.readBytes(bytes);
        return bytes;
    }
}
