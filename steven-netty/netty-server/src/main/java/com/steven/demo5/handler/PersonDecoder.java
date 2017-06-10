package com.steven.demo5.handler;

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
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte n = "n".getBytes()[0];
        byte p = in.readByte();
        in.resetReaderIndex();
        if (n != p) {
            // 把读取的起始位置重置
            ByteBufToBytes reader = new ByteBufToBytes();
            out.add(ByteObjConverter.ByteToObject(reader.read(in)));
        } else {
            // 执行其它的decode
            ctx.fireChannelRead(in);
        }
    }
}
