package com.steven.demo2;

import com.steven.demo1.HelloServerHandler;
import com.steven.demo2.handler.InboundHandler1;
import com.steven.demo2.handler.InboundHandler2;
import com.steven.demo2.handler.OutboundHandler1;
import com.steven.demo2.handler.OutboundHandler2;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by Steven on 2017/6/10.
 */
public class HelloServer {

    public void start(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 注册两个OutboundHandler，执行顺序为注册顺序的逆序，所以应该是OutboundHandler2 OutboundHandler1
                            socketChannel.pipeline().addLast(new OutboundHandler1());
                            socketChannel.pipeline().addLast(new OutboundHandler2());
                            // 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1 InboundHandler2
                            socketChannel.pipeline().addLast(new InboundHandler1());
                            socketChannel.pipeline().addLast(new InboundHandler2());
                        }
                    })
            .option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true);


            ChannelFuture f = bootstrap.bind(port).sync();

            f.channel().closeFuture().sync();

        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new HelloServer().start(8000);
    }
}
