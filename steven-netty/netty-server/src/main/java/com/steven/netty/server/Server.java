package com.steven.netty.server;

import com.steven.netty.common.decoder.BusinessHandler;
import com.steven.netty.common.decoder.PerseonDecoder;
import com.steven.netty.common.entity.Person;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * server
 * Created by Steven on 2017/6/10.
 */
public class Server {

    EventLoopGroup bossGroup = null;
    EventLoopGroup workGroup =null;
    ChannelFuture f = null;

    private void start(int port){
        bossGroup = new NioEventLoopGroup();
        workGroup = new NioEventLoopGroup();
        try{
          /*  ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,20)//链接数
            .option(ChannelOption.TCP_NODELAY,true)//不延迟，直接发送
            .childOption(ChannelOption.SO_KEEPALIVE,true)//长链接
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new PerseonDecoder());
                    ch.pipeline().addLast(new BusinessHandler());
                }
            });

            f = b.bind(port).sync();*/


            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new PerseonDecoder());
                            ch.pipeline().addLast(new BusinessHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = b.bind(port).sync();
            System.out.println(f.isSuccess());
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public  void close() throws InterruptedException {
        System.out.println("通道"+f);
        f.channel().closeFuture().sync();
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(8000);
    }
}
