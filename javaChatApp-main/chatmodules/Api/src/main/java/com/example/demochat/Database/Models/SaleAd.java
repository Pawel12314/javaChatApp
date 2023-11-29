package com.example.demochat.Database.Models;

import com.example.demochat.Database.Visitor.AdVisitor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleAd extends MyAd {
    private BigDecimal price;
    private long amount;
    private String productName;

    @Override
    public String toString()
    {
        return this.getProductName()+" "+this.getPrice()+" "+this.getAmount();
    }
    @Override
    public void visit() {
        (new AdVisitor()).printEventAd(this);
    }
}
