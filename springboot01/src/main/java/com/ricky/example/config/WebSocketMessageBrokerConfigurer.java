package com.ricky.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author ricky
 * @create 2020-03-14 14:17
 *
 * 配置消息代理，默认情况下使用内置的消息代理。
 * 类上的注解@EnableWebSocketMessageBroker：此注解表示使用STOMP协议来传输基于消息代理的消息，此时可以在@Controller类中使用@MessageMapping
 * 在方法registerStompEndpoints()里addEndpoint方法：添加STOMP协议的端点。这个HTTP URL是供WebSocket或SockJS客户端访问的地址;withSockJS：指定端点使用SockJS协议
 * 在方法configureMessageBroker()里设置简单消息代理，并配置消息的发送的地址符合配置的前缀的消息才发送到这个broker
 */
@Configuration
// 此注解表示使用STOMP协议来传输基于消息代理的消息，此时可以在@Controller类中使用@MessageMapping
@EnableWebSocketMessageBroker
public class WebSocketMessageBrokerConfigurer extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 注册 Stomp的端点
         * addEndpoint：添加STOMP协议的端点。这个HTTP URL是供WebSocket或SockJS客户端访问的地址
         * withSockJS：指定端点使用SockJS协议
         */
        registry.addEndpoint("/websocket-simple")
                .setAllowedOrigins("*") // 添加允许跨域访问
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * 配置消息代理
         * 启动简单Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
         */
        registry.enableSimpleBroker("/topic","/queue");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        super.configureClientInboundChannel(registration);
    }
}

