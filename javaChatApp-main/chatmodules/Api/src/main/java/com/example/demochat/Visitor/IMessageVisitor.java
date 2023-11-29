package com.example.demochat.Visitor;

import com.example.demochat.Mediator.ClientMessageMediator;
import lombok.Getter;
import lombok.Setter;

public abstract class IMessageVisitor {
    @Getter
    @Setter
    private ClientMessageMediator mediator;

}
