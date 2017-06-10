package com.steven.netty.common.decoder;

import com.steven.netty.common.decoder.util.ByteBufToBytes;
import com.steven.netty.common.decoder.util.ByteObjConverter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * PerseonDecoder解码器
 * Created by Steven on 2017/6/10.
 */
public class PerseonDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBufToBytes read = new ByteBufToBytes();
        Object obj = ByteObjConverter.ByteToObject(read.read(byteBuf));
        list.add(obj);
    }
}
