package com.example.demochat.AppContainer;

import com.example.demochat.Mediator.ClientMessageMediator;
import com.example.demochat.Session.MySession;
import lombok.Getter;
import lombok.Setter;

public class AppConainer {
    @Getter
    @Setter
    private ClientMessageMediator mediator;
    @Getter
    @Setter
    private MySession session;
}
