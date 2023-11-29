package chatapp;

import com.example.demochat.Mediator.ServerMessageMediator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Hello world!
 *
 */


@SpringBootApplication
//@EnableMongoRepositories("com.example.demochat.Database.Repositories")
public class ChatServerApplication
{
    private ServerMessageMediator mediator;

    private void run(ApplicationContext ctx)
    {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run()
            {
                System.out.println("hello from exit function");
            }
        });
        this.mediator = ctx.getBean(ServerMessageMediator.class);
        System.out.println("hello from server");
        this.mediator.mongoFun();
        if(this.mediator.getUserRepository()==null)
        {
            System.out.println("repository is null");
        }
        else
        {
            System.out.println("repository is not null");
        }
        while (true)
        {

        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello from main function");
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("./beansForServer.xml");
        ctx.registerShutdownHook();


        //ApplicationContext ctx = SpringApplication.run(ChatClientApplication.class, args);
        ChatServerApplication chatClientApplication = new ChatServerApplication();
        chatClientApplication.run(ctx);

    }
}
