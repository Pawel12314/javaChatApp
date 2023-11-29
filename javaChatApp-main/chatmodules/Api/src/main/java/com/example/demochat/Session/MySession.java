package com.example.demochat.Session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class MySession implements ISession{
    @Getter

    private UUID id;
    public MySession()
    {
        this.generateNewId();
    }
    public MySession(String uuid)
    {
        this.id = UUID.fromString(uuid);
    }
    public void generateNewId()
    {
        this.id = UUID.randomUUID();
    }

}
