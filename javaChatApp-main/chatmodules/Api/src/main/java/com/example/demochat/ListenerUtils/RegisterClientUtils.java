package com.example.demochat.ListenerUtils;

import com.example.demochat.Actions.ClientSide.RegisterClientSideRequestAction;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration

public class RegisterClientUtils implements IListenerUtils {
    @Getter
    @Setter
    private RegisterClientSideRequestAction action;
    @Getter
    @Setter
    private MessageListenerAdapter registerClientSideRequestAdapter;


   /* @Getter
    @Setter
    private RegisterClientSideRequestReceiver registerReceiver;
*/
    public RegisterClientUtils()
    {

    }
}
