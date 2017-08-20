package com.jpm;

import com.jpm.entities.DailyResult;
import com.jpm.entities.RankResult;
import com.jpm.entities.TradeInstruction;
import com.jpm.enums.Type;
import com.jpm.services.DataGenerator;
import com.jpm.services.ReportService;

import java.util.List;

import static com.jpm.services.PrintService.printDailyReport;
import static com.jpm.services.PrintService.printData;
import static com.jpm.services.PrintService.printRankingReport;

public class TradeReportApplication {


    public static void main(String[] args){

        List<TradeInstruction> tradeInstructions = DataGenerator.generateData();
        printData(tradeInstructions);

        List<DailyResult> dailyResultList = ReportService.getDailyReport(tradeInstructions);
        printDailyReport(dailyResultList);

        List<RankResult> rankResultList = ReportService.getRankingReportForBuyOperation(tradeInstructions);
        printRankingReport(rankResultList, Type.BUY);

        rankResultList = ReportService.getRankingReportForSellOperation(tradeInstructions);
        printRankingReport(rankResultList, Type.SELL);
    }
}
