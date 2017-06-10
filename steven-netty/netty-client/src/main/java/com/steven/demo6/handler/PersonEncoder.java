package com.steven.demo6.handler;

import com.steven.netty.common.decoder.util.ByteObjConverter;
import com.steven.netty.common.entity.Person;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by Steven on 2017/6/10.
 */
public class PersonEncoder extends MessageToByteEncoder<Person> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Person msg, ByteBuf out) throws Exception {
        byte[] datas = ByteObjConverter.ObjectToByte(msg);
        out.writeBytes(datas);
        ctx.flush();
    }
}
