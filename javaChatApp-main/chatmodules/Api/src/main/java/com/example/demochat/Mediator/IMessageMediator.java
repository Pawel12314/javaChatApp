package com.example.demochat.Mediator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

public abstract class IMessageMediator {



    @Setter
    @Getter
    protected RedisMessageListenerContainer container;
    @Getter
    @Setter
    protected StringRedisTemplate template;


}
