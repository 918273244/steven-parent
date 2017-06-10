package com.steven.demo6.handler;

import com.steven.netty.common.entity.Person;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * Created by Steven on 2017/6/10.
 */
public class ClientInitHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
      /*  int count = 0;
        while (true){
            Person person = new Person();
            person.setName("guowl");
            person.setSex("man");
            person.setAge(30+count++);
            ctx.write(person);
            ctx.flush();
            Thread.sleep(2000);
        }
*/
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            Person person = new Person();
            person.setName("guowl");
            person.setSex("man");
            person.setAge(30+i);
            ctx.write(person);
            ctx.flush();
        }
    }




    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
