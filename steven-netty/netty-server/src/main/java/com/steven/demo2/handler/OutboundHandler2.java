package com.steven.demo2.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Created by Steven on 2017/6/10.
 */
public class OutboundHandler2 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        // 执行下一个OutboundHandler
        super.write(ctx, msg, promise);
    }
}
