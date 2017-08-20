package com.jpm.entities;

import com.jpm.enums.Currency;
import com.jpm.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeInstruction {

    private String entity;
    private Type type;
    private double agreedFx;
    private Currency currency;
    private LocalDate instructionDate;
    private LocalDate settlementDate;
    private int unit;
    private double pricePerUnit;

    private double amountInUSD;
    private LocalDate settlementDateModifiedToWorkDay;


    public double getAmountInUSD()
    {
        return agreedFx * pricePerUnit * unit;
    }

//    @Override
//    public String toString(){
//        return "Name:" + entity + " Type:" + type.name() + " AgreedFx:" + agreedFx + " Currency:" + currency +
//                " Instruction Date:" + instructionDate + " SettlementDate: " + settlementDate + " Unit:" + unit +
//                " Price Per Unit:" + pricePerUnit + " Amount in USD:" + getAmountInUSD();
//    }
}
