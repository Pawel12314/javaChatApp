package com.example.demochat.Database.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public abstract class MyAd {
    @Id
    private String id;
    private String title;
    private String content;
    public abstract void visit();
}
