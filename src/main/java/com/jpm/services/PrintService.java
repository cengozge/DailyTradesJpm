package com.jpm.services;

import com.jpm.entities.DailyResult;
import com.jpm.entities.RankResult;
import com.jpm.entities.TradeInstruction;
import com.jpm.enums.Type;
import com.jpm.utils.DateUtil;

import java.util.List;

public class PrintService {

    public static void printRankingReport(List<RankResult> rankResults, Type type){
        System.out.println("\n" + "RANKING FOR " + type.name() + " OPERATION" + "\n");
        System.out.printf("%10s %10s %10s %8s%n", "DATE", "ENTITY", "AMOUNT", "RANK");
        rankResults
                .stream()
                .forEach(x -> System.out.printf("%5s %7s %7.2f %5d%n", DateUtil.formatDate(x.getSettlementDate()), x.getEntity(),
                                                                x.getAmount(), x.getRank()));
    }

    public static void printDailyReport(List<DailyResult> dailyResultList){
        System.out.println("\n" + "DAILY SETTLEMENT AMOUNTS IN USD" + "\n");
        System.out.printf("%6s %13s %10s%n", "DATE", "BUY", "SELL");
        dailyResultList
                .stream()
                .forEach(x->System.out.printf("%10s - %8.2f %8.2f%n",
                    DateUtil.formatDate(x.getSettlementDate()), x.getTotalBuy(), x.getTotalSell()));
    }

    public static void printData(List<TradeInstruction> tradeInstructions){
        System.out.printf("%12s %7s %11s %10s %13s %13s %17s %5s %10s %10s",
                    "NAME", "TYPE", "AGREED FX", "CURRENCY", "INSTR. DATE", "SET. DATE", "NEW SET. DATE", "UNIT",
                            "PRICE PER UNIT",  "AMOUNT IN USD");
        System.out.println();
        tradeInstructions
                         .stream()
                         .forEach(x->System.out.printf("%10s %5s %10.2f %10s %15s %15s %15s %5d %10.2f %14.2f%n",
                                                        x.getEntity(), x.getType(), x.getAgreedFx(), x.getCurrency(),
                                                        DateUtil.formatDate(x.getInstructionDate()),
                                                        DateUtil.formatDate(x.getSettlementDate()),
                                                        DateUtil.formatDate(x.getSettlementDateModifiedToWorkDay()),
                                                        x.getUnit(), x.getPricePerUnit(), x.getAmountInUSD()));
    }

}
