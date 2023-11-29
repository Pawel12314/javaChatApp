package com.example.demochat.Adapters;

import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RegisterMessageAdapter  extends MessageListenerAdapter {
    public RegisterMessageAdapter()
    {

    }
    public RegisterMessageAdapter(Object receiver, String invokerName)
    {
        super(receiver,invokerName);
    }
}
