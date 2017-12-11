package com.peach.demo.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by panta on 2017/12/8.
 */
public class DemoServerHandler extends IoHandlerAdapter {
    public DemoServerHandler() {
        super();
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        super.sessionOpened(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println("idle：" + session.getIdleCount(status));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("recevied message" + message.toString());
        if (!StringUtils.isEmpty(message)){
            if(message.toString().trim().equalsIgnoreCase("exit")){
                sessionClosed(session);
                return;
            }
            Date date = new Date();
            session.write(date.toString());
            System.out.println("message written.......");
        }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        session.write(message);
    }

    @Override
    public void inputClosed(IoSession session) throws Exception {
        super.inputClosed(session);
    }
}
