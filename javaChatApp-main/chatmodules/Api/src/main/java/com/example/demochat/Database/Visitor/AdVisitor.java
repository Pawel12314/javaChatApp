package com.example.demochat.Database.Visitor;

import com.example.demochat.Database.Models.EventAd;
import com.example.demochat.Database.Models.SaleAd;

public class AdVisitor {
    public void printEventAd(EventAd ad)
    {
        System.out.println(ad.toString());
    }
    public void printEventAd(SaleAd ad)
    {
        System.out.println(ad.toString());
    }
}
