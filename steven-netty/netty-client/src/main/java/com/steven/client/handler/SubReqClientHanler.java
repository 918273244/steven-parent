package com.steven.client.handler;

import com.steven.netty.common.entity.SubscribeReq;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Steven on 2017/6/10.
 */
public class SubReqClientHanler extends ChannelHandlerAdapter {

    public SubReqClientHanler(){

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println("----------------handler channelActive-----准备发送十个数据-------");

        for(int i = 0; i<10; i++){
//          ctx.write(subReq(i));
            SubscribeReq req = new SubscribeReq();
            req.setStrAddr("深圳蛇口");
            req.setStrPhoneNumber("13888886666");
            req.setStrProductName("Netty Book");
            req.setnSubReqID(i);
            req.setStrUserName("XXYY");
            ctx.write(req);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception{
        System.out.println("--------channelRead---服务器发来的数据为：[" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)
            throws Exception{
        System.out.println("----------------handler channelReadComplete");
        ctx.flush();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        System.out.println("--------------------------------------------------------------------------handler exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }
}
