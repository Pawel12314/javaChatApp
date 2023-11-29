package com.Exec;


import com.example.demochat.Mediator.ClientMessageMediator;
import com.example.demochat.Models.RegisterFormRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication

public class ChatClientApplication {


    private ClientMessageMediator mediator;

    private void run(ApplicationContext ctx)
    {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run()
            {
                System.out.println("hello from exit function");
            }
        });
        this.mediator = ctx.getBean(ClientMessageMediator.class);
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String input = new String();
        //RegisterReceiver receiver = ctx.getBean(RegisterReceiver.class);
        try
        {
            System.out.println("type your username here:");
            input = reader.readLine();
            RegisterFormRequest userName = new RegisterFormRequest();
            userName.setUsername(input);
            System.out.println("type your password here:");
            input = reader.readLine();
            userName.setPassword(input);
            this.mediator.getRegisterAction().invoke(userName);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        while (true)
        {

        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello from main function");
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("beansForClient.xml");
        ctx.registerShutdownHook();


        //ApplicationContext ctx = SpringApplication.run(ChatClientApplication.class, args);
        ChatClientApplication chatClientApplication = new ChatClientApplication();
        chatClientApplication.run(ctx);

    }
}
