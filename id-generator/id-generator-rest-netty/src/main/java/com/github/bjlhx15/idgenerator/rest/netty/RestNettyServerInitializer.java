package com.github.bjlhx15.idgenerator.rest.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class RestNettyServerInitializer extends
        ChannelInitializer<SocketChannel> {
    private RestNettyServerHandler handler = new RestNettyServerHandler();

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();

        p.addLast("codec", new HttpServerCodec());
        p.addLast("handler", handler);
    }
}
