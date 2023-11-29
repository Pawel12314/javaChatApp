package com.example.demochat.Receivers.ServerSide;

import com.example.demochat.Database.Models.MyUser;

import com.example.demochat.Mediator.ServerMessageMediator;
import com.example.demochat.Models.RegisterFormRequest;
import com.example.demochat.Models.RegisterFormResponse;
import com.example.demochat.Receivers.IReceiver;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class RegisterServerSideRequestReceiver implements IReceiver {
    //@Override
    @Getter
    @Setter
    private ServerMessageMediator mediator;
    @Override
    public void receiveMessage(String message) {
        RegisterFormRequest userform = RegisterFormRequest.fromJson(message);
        System.out.println("printing registerRequest");
        System.out.println(userform.toString());
        Boolean usernameeStatus = userform.getUsernameLength()>6;
        Boolean passwordStatus = userform.getPasswordLength()>8;
        Boolean formStatus = passwordStatus && usernameeStatus;
        RegisterFormResponse response = new RegisterFormResponse();

        response.setRegisterStatus(formStatus);
        response.setUsernameStatus(usernameeStatus);
        response.setPasswordStatus(passwordStatus);

        Boolean isFree = this.mediator.getUserRepository().doesExist(userform.getUsername()) == 0;
        if(isFree==true)
        {
            MyUser u = new MyUser();
            u.setUsername(userform.getUsername());
            u.setPassword(userform.getHashedPassword());
            this.mediator.getUserRepository().save(u);

        }
        response.setIsUsernameTaken(!isFree);
        Iterable<MyUser> users = this.getMediator().getUserRepository().findAll();
        users.forEach(user->{
            System.out.println(user.getUsername());
        });

        this.mediator.getRegisterServerSideResponseAction()
                .Invoke(response,userform.getUuid());


    }
}
