package com.example.demochat.ListenerUtils;

import com.example.demochat.Actions.ServverSide.RegisterServerSideResponseAction;
import com.example.demochat.Receivers.ServerSide.RegisterServerSideRequestReceiver;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;


@Configuration
public class RegisterServerUtils implements  IListenerUtils{
    @Getter
    @Setter
    private RegisterServerSideResponseAction registerServerResponseAction;

    @Getter
    @Setter
    private MessageListenerAdapter registerServerAdapter;
/*
    @Getter
    @Setter
    private RegisterServerSideRequestReceiver registerServerSideRequestReceiver;
*/

}
