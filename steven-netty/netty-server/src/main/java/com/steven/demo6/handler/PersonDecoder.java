package com.steven.demo6.handler;

import com.steven.netty.common.decoder.util.ByteBufToBytes;
import com.steven.netty.common.decoder.util.ByteObjConverter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by Steven on 2017/6/10.
 */
public class PersonDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        ByteBufToBytes read = new ByteBufToBytes();
        Object obj = ByteObjConverter.ByteToObject(read.read(in));
        out.add(obj);
    }
}
