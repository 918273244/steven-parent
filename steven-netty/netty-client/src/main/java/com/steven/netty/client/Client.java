package com.steven.netty.client;

import com.steven.netty.Handler.ClientInitHandler;
import com.steven.netty.common.decoder.PerseonDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Steven on 2017/6/10.
 */
public class Client {
    EventLoopGroup workerGroup = null;
    public void connect(String host, int port) throws InterruptedException {
        try{
            workerGroup = new NioEventLoopGroup();
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new PerseonDecoder());
                    ch.pipeline().addLast(new ClientInitHandler());
                }
            });

            ChannelFuture f = b.connect(host, port).sync();
            if (f.isSuccess()){
                System.out.println("链接成功");
            }
            f.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Client().connect("localhost", 8000);
    }
}
