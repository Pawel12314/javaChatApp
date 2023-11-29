package com.example.demochat.Visitor;

import com.example.demochat.Actions.ClientSide.RegisterClientSideRequestAction;
import com.example.demochat.Actions.TestAction;
import com.example.demochat.Mediator.ClientMessageMediator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class ClientMessageVisitor {
    @Getter
    @Setter
    private ClientMessageMediator mediator;
    //@Bean

    public ClientMessageVisitor()
    {
    }

    public void Visit(RegisterClientSideRequestAction action)
    {
        //this.mediator.getSession().generateNewId();
        this.mediator.addRegisterResponseListener();
        action.getRegisterForm().setUuid(this.mediator.getSession().getId().toString());
        this.mediator
                .getTemplate()
                .convertAndSend(
                        action.getChannel(),
                        action.getRegisterForm().toJson()
                );
    }
    public void Visit(TestAction action)
    {
        this.mediator
                .getTemplate()
                .convertAndSend(
                        action.getChannel(),
                        action.getMessage()
                );
    }
}
