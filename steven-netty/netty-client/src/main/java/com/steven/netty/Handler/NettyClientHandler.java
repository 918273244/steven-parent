package com.steven.netty.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;

/**
 * Created by Steven on 2017/6/10.
 */
public class NettyClientHandler extends ChannelHandlerAdapter {

    private ByteBuf firstMessage;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            byte[] data = (i+"服务器，给我一个APPLE").getBytes();
            firstMessage= Unpooled.buffer();
            firstMessage.writeBytes(data);
            ctx.writeAndFlush(firstMessage);
        }

    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        String rev = getMessage(buf);
        System.out.println("客户端收到服务器数据:" + rev);
    }
    private String getMessage(ByteBuf buf) {
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
