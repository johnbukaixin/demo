package com.peach.demo.mina;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.Charset;

/**
 * Created by panta on 2017/12/8.
 */
public class DemoServer {
    private static int port = 9000;

    public static void main(String args[]){
        IoAcceptor acceptor = new NioSocketAcceptor();

        //addList(string,ioFilter)设置过滤器，日志过滤器Logs all MINA protocol events
        acceptor.getFilterChain().addLast("logger",new LoggingFilter());
        //配置编解码过滤器， An Iofilter which translates binary or protocol specific data into message objects
        acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8"))));

        //设置处理器
        acceptor.setHandler(new DemoServerHandler());
        //设置缓冲区大小，用于告诉底层操作系统未输入数据分配多少空间
        acceptor.getSessionConfig().setReadBufferSize(2048);
        //设置空闲时间，第一个参数定义在确定会话是否空闲时要检查的操作，第二个参数定义在会话被认为是空闲之前必须发生的时间长度（以秒为单位）。
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);
        try {
            acceptor.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
