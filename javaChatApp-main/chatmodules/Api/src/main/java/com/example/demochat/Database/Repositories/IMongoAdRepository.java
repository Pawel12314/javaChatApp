package com.example.demochat.Database.Repositories;

import com.example.demochat.Database.Models.MyAd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IMongoAdRepository extends MongoRepository<MyAd, String> {
    public List<MyAd> findByTitle(String title);
    public List<MyAd> findAllByContentContains(String content);

}
