package com.example.demochat.Mediator;

import com.example.demochat.Actions.ServverSide.RegisterServerSideResponseAction;
import com.example.demochat.Database.Models.EventAd;
import com.example.demochat.Database.Models.SaleAd;
import com.example.demochat.Database.Repositories.IMongoAdRepository;
import com.example.demochat.Database.Repositories.IUserRepository;
import com.example.demochat.Database.Models.MyAd;
import com.example.demochat.ListenerUtils.RegisterServerUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
//@ComponentScan({"com.example.demochat.Database.Repositories"})
@EnableMongoRepositories({"com.example.demochat.Database.Repositories"})
public class ServerMessageMediator extends IMessageMediator {
    @Getter
    @Setter
    private RegisterServerSideResponseAction registerServerSideResponseAction;
    @Getter
    @Setter
    private StringRedisTemplate template;

    @Getter
    @Setter

    private IUserRepository userRepository;

    private IMongoAdRepository mongoAdRepository;
    @Autowired
    public void setMongoAdRepository(IMongoAdRepository mongoAdRepository)
    {
        System.out.println("hello from setting mongodb repository\n---\n---\n---\n");

        this.mongoAdRepository = mongoAdRepository;
        if(this.mongoAdRepository==null)
        {
            System.out.println("mongo db is null");
        }else {
            System.out.println("mongo db is not null");
        }

    }
    public void mongoFun()
    {

        EventAd eventad = new EventAd();
        eventad.setAdress("new york some street");
        LocalDate date = LocalDate.of(2020,12,12);
        LocalTime time = LocalTime.of(12,30);
        eventad.setEventDate(date);
        eventad.setEvenTime(time);
        eventad.setTitle("event title");
        eventad.setContent("event content");

        this.mongoAdRepository.insert(eventad);
        SaleAd salead = new SaleAd();
        salead.setAmount(5);
        salead.setPrice(new BigDecimal(30.5));
        salead.setProductName("tomatoes");
        salead.setTitle("sale title");
        salead.setContent("sale content");

        this.mongoAdRepository.insert(salead);
        List<MyAd> foundads = this.mongoAdRepository.findAll();
        for(MyAd foundad : foundads)
        {
            System.out.println(foundad.getClass().getName());
            System.out.println(foundad.getTitle()+" "+foundad.getContent()+"\n");
            foundad.visit();
            //System.out.println("-->\n"+ foundad.getTitle()+"\n"+foundad.getContent());
        }

    }

    @Autowired
    public void mySetRepository(IUserRepository repository)
    {
        this.userRepository = repository;
    }


    public ServerMessageMediator(
            LettuceConnectionFactory connectionFactory,

            StringRedisTemplate template,

            RegisterServerUtils registerUtils

    ) {
        try {
            //this.userRepository = userRepository;
            this.container = new RedisMessageListenerContainer();

            this.registerServerSideResponseAction = registerUtils.getRegisterServerResponseAction();
            this.template = template;

            connectionFactory.afterPropertiesSet();
            container.setConnectionFactory(connectionFactory);
            this.container.afterPropertiesSet();

            this.getContainer().addMessageListener(registerUtils.getRegisterServerAdapter(),
                    new PatternTopic("register")
            );

            this.container.start();
            //this.container.afterPropertiesSet();
            int i = 123;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
