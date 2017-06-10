package com.steven.demo5.handler;

import com.steven.netty.common.entity.Person;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Steven on 2017/6/10.
 */
public class ClientInitHandler extends ChannelInboundHandlerAdapter {

    private Person person;
    public ClientInitHandler(Person person){
        this.person = person;
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write(person);
        ctx.flush();
    }

}
