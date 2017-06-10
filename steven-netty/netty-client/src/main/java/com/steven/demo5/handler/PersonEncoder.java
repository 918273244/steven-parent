package com.steven.demo5.handler;

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
    protected void encode(ChannelHandlerContext channelHandlerContext, Person msg, ByteBuf out) throws Exception {
        out.writeBytes(ByteObjConverter.ObjectToByte(msg));
    }
}
