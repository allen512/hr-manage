package com.example.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {

        //将/"applicationName"/ws/endpointChat注册为STOMP的一个端点Url 客户端通过此Url与服务器建立WebSocket连接
        // 即用户发送请求url="/applicationName/ws/endpointChat"与STOMP server进行连接。之后再转发到订阅url
        //setAllowedOrigins允许所有域连接，否则浏览器可能报403错误
        stompEndpointRegistry.addEndpoint("/ws/endpointChat").setAllowedOrigins("*").withSockJS();
    }



    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //定义了一个（或多个）客户端订阅地址的前缀信息，也就是服务端发送给客户端消息的前缀信息
        //应用程序以/app为前缀，代理目的地以/topic、/user为前缀的Url
        //queue点对点,topic广播,user点对点,app应用程序前缀
        registry.enableSimpleBroker("/queue", "/topic");
        //registry.setApplicationDestinationPrefixes("/app");
        //registry.setUserDestinationPrefix("/user");
    }
}
