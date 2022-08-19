package com.webapp.web.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Component
public class WebSocketForChatRoom implements WebSocketConfigurer {

    @Autowired
    WebSocketHandlerForChartRoom webSocketHandlerForChartRoom;
    @Autowired
    HandshakeInterceptorForChartRoom handshakeInterceptorForChartRoom;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandlerForChartRoom, "/ws").addInterceptors(handshakeInterceptorForChartRoom);

        registry.addHandler(webSocketHandlerForChartRoom, "/ws/sockjs").addInterceptors(handshakeInterceptorForChartRoom).withSockJS();
    }
}
