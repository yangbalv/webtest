package com.webapp.web.websocket;

import com.webapp.dao.User;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;
@Component
public class HandshakeInterceptorForChartRoom implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            //如果用户已经登录，允许聊天
            if (session.getAttribute("loginUser") != null) {
                //获取登录的用户
                User loginUser = (User) session.getAttribute("loginUser");
                //将用户放入socket处理器的会话(WebSocketSession)中
                attributes.put("loginUser", loginUser);
                System.out.println("Websocket:用户[ID:" + (loginUser.getId() + ",Name:" + loginUser.getName() + "]要建立连接"));
            } else {
                //用户没有登录，拒绝聊天
                //握手失败！
                System.out.println("--------------握手已失败...");
                return false;
            }
        }
        System.out.println("--------------握手开始...");
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        HttpSession session = servletRequest.getServletRequest().getSession(false);
        User loginUser = (User) session.getAttribute("loginUser");
        System.out.println("Websocket:用户[ID:" + (loginUser.getId() + ",Name:" + loginUser.getName() + "]建立完连接"));
    }
}
