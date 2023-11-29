package com.example.demochat.Mediator;

import com.example.demochat.Actions.ClientSide.RegisterClientSideRequestAction;
import com.example.demochat.ListenerUtils.RegisterClientUtils;
import com.example.demochat.Session.MySession;
import com.example.demochat.Visitor.ClientMessageVisitor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component

public class ClientMessageMediator extends IMessageMediator{


    public ClientMessageMediator()
    {

    }

    public ClientMessageMediator(
            LettuceConnectionFactory connectionFactory,

            StringRedisTemplate template,

            RegisterClientUtils registerUtils
    )
    {
        try
        {
            this.container = new RedisMessageListenerContainer();
            this.registerAdapter = registerUtils.getRegisterClientSideRequestAdapter();
            this.template=template;
            this.registerAction = registerUtils.getAction();
            connectionFactory.afterPropertiesSet();
            container.setConnectionFactory(connectionFactory);
            this.container.afterPropertiesSet();

           this.container.start();
           // this.addRegisterResponseListener();
            int i = 123;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
    @Getter
    private RegisterClientSideRequestAction registerAction;

    @Getter
    @Setter
    private ClientMessageVisitor visitor;

    @Getter
    @Setter
    private MySession session;
    @Getter
    @Setter
    protected MessageListenerAdapter registerAdapter;

    public void addRegisterResponseListener()
    {
        //this.getSession().generateNewId();
        this.getContainer().addMessageListener(this.getRegisterAdapter(),
                new PatternTopic("register:"+this.getSession().getId().toString())
        );
    }

}
