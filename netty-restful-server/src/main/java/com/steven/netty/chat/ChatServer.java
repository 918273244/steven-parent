package com.steven.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * 聊天服务器
 * Created by Steven on 2017/5/8.
 */
public class ChatServer {

   public static void test(){
       EventLoopGroup bossGroup = new NioEventLoopGroup();
       EventLoopGroup workerGroup = new NioEventLoopGroup();

       ServerBootstrap bootstrap = new ServerBootstrap();
       try {
       bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
               .childHandler(new ChannelInitializer<SocketChannel>() {
                   @Override
                   protected void initChannel(SocketChannel channel) throws Exception {
                       channel.pipeline().addLast(new ChatHandler());
                   }
               });
           ChannelFuture start = bootstrap.bind(8888).sync();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           bossGroup.shutdownGracefully();
           workerGroup.shutdownGracefully();
       }
   }
}
