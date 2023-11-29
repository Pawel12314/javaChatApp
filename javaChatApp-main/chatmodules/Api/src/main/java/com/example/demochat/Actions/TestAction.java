package com.example.demochat.Actions;

import com.example.demochat.Actions.ClientSide.RegisterClientSideRequestAction;
import com.example.demochat.Mediator.ClientMessageMediator;
import lombok.Getter;
import lombok.Setter;

public class TestAction {

    public TestAction()
    {

    }
    @Getter
    @Setter
    private ClientMessageMediator mediator;
    public static final String channel = "test";
    @Getter
    private String message;

    //@Autowired
    public String getChannel()
    {
        return RegisterClientSideRequestAction.channel;
    }
    public void invoke(String message)
    {
        this.message = message;
        this.mediator.getVisitor().Visit(this);
    }
}
