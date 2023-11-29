package com.example.demochat.Actions.ServverSide;

import com.example.demochat.Actions.IAction;
import com.example.demochat.Mediator.ClientMessageMediator;
import com.example.demochat.Mediator.ServerMessageMediator;
import com.example.demochat.Models.ModelsUtils;
import com.example.demochat.Models.RegisterFormResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class RegisterServerSideResponseAction implements IAction {


    @Getter
    @Setter
    private ServerMessageMediator mediator;
    public void Invoke(RegisterFormResponse response, String uuid)
    {
        this.mediator.getTemplate().convertAndSend(
            "register:"+    uuid,response.toJson()
        );
    }
}
