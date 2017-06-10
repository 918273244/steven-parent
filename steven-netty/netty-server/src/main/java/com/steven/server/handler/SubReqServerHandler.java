package com.steven.server.handler;

import com.steven.netty.common.entity.SubscribeReq;
import com.steven.netty.common.entity.SubscribeResp;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by Steven on 2017/6/10.
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("--------------------------------handler channelActive------------");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception{

        //          SubscribeReq reqx = new SubscribeReq();
//          reqx.setAddress("*****深圳蛇口");
//          reqx.setPhoneNumber("13888886666");
//          reqx.setProductName("Netty Book");
//          reqx.setSubReqID(6666);
//          reqx.setUserName("XXYY");
//          ctx.write(reqx);
//          ctx.flush();
//

        SubscribeResp resp = new SubscribeResp();
        resp.setnSubReqID(555);
        resp.setnRespCode(0);
        resp.setStrDesc("-------Netty book order succeed, 3days later, sent to the designated address");
        ctx.writeAndFlush(resp);    // 反馈消息

        SubscribeReq req = (SubscribeReq)msg;   // 订购内容
        if("XXYY".equalsIgnoreCase(req.getStrUserName())){
            System.out.println("接收到的数据: [  " + req.toString() + "   ]");
        }
    }

    @Override
    public  void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        System.out.println("---------------exceptionCaught 网络异常，关闭网络");
        cause.printStackTrace();
        ctx.close();
    }

}
