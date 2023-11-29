package com.example.demochat.Database.Models;

import com.example.demochat.Database.Visitor.AdVisitor;
import lombok.Data;

import javax.swing.text.AbstractDocument;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class EventAd extends MyAd{
    private LocalTime evenTime;
    private LocalDate eventDate;
    private String adress;

    @Override
    public String toString()
    {
        return this.adress+" "+this.eventDate.toString()+" "+this.evenTime.toString();
    }
    @Override
    public void visit() {
        (new AdVisitor()).printEventAd(this);
    }
}
