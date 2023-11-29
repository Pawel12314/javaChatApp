package com.example.demochat.Database.Repositories;

import com.example.demochat.Database.Models.MyUser;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@EntityScan("com.example.demochat.Database.Models")
public interface IUserRepository extends CrudRepository<MyUser,Long> {
    MyUser findById(long id);
    @Query("select count(1) from MyUsers u where u.username = ?1")
    long doesExist(String username);

}
