package com.example.demochat.Actions.ClientSide;

import com.example.demochat.Models.RegisterFormRequest;
import com.example.demochat.Actions.IAction;
import com.example.demochat.Mediator.ClientMessageMediator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class RegisterClientSideRequestAction implements IAction {

    public RegisterClientSideRequestAction()
    {

    }
    @Getter
    @Setter
    private ClientMessageMediator mediator;
    @Getter
    private RegisterFormRequest registerForm;

    public record ExampleRecord(String a, String b)
    {

    }
    public static final String channel = "register";
    //@Autowired
    public String getChannel()
    {
        return RegisterClientSideRequestAction.channel;
    }
    public void invoke(RegisterFormRequest userName)
    {
        this.registerForm = userName;

        this.mediator.getVisitor().Visit(this);
        /*
       // this.mediator.addRegisterResponseListener();
        String msg = this.registerForm.toJson();
        this.mediator
                .getTemplate()
                .convertAndSend(
                        this.getChannel(),
                        msg
                );
        *///this.mediator.getVisitor().Visit(this);


    }
}
