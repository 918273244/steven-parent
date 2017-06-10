package com.steven.demo4.handler;

import com.steven.netty.common.entity.Person;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Steven on 2017/6/10.
 */
public class ClientInitHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                Person person = new Person();
                person.setName("guowl");
                person.setSex("man");
                person.setAge(5);
                ctx.writeAndFlush(person);

    }

}
