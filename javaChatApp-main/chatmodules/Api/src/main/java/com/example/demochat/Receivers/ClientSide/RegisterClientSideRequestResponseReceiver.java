package com.example.demochat.Receivers.ClientSide;

import com.example.demochat.Models.RegisterFormResponse;
import com.example.demochat.Receivers.IReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RegisterClientSideRequestResponseReceiver implements IReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterClientSideRequestResponseReceiver.class);

    public RegisterClientSideRequestResponseReceiver()
    {

    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("hello from reciver message object");
        LOGGER.info("invoking register response code ...");
        LOGGER.info("received message <"+message+">");
        //RegisterFormResponse response = RegisterFormResponse.fromJson(message);

    }
}
