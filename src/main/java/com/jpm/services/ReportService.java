package com.jpm.services;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.jpm.entities.DailyResult;
import com.jpm.entities.RankResult;
import com.jpm.entities.TradeInstruction;
import com.jpm.enums.Type;

public class ReportService {

	public static List<DailyResult> getDailyReport(List<TradeInstruction> tradeInstructions) {
		List<DailyResult> dailyResultList = new ArrayList<>();

		tradeInstructions
				.stream()
				.collect(groupingBy(TradeInstruction::getSettlementDateModifiedToWorkDay,
						groupingBy(TradeInstruction::getType, summingDouble(TradeInstruction::getAmountInUSD))))
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach(x -> {
					Map<Type, Double> tmpValue = x.getValue();
					double buy = tmpValue.get(Type.BUY) != null ? tmpValue.get(Type.BUY) : 0;
					double sell = tmpValue.get(Type.SELL) != null ? tmpValue.get(Type.SELL) : 0;
					dailyResultList.add(DailyResult.builder()
							.settlementDate(x.getKey())
							.totalBuy(buy)
							.totalSell(sell)
							.build());
				});
		return dailyResultList;
	}

	public static List<RankResult> getRankingReportForBuyOperation(List<TradeInstruction> tradeInstructions) {

		List<RankResult> rankResults = new ArrayList<>();
		tradeInstructions
				.stream()
				.filter(x -> x.getType() == Type.BUY)
				.collect(groupingBy(TradeInstruction::getSettlementDateModifiedToWorkDay,
						groupingBy(TradeInstruction::getEntity, summingDouble(TradeInstruction::getAmountInUSD))))
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach(a -> {
					int[] rank = { 0 };
					a.getValue()
							.entrySet()
							.stream()
							.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
							.forEach(b -> rankResults.add(RankResult.builder()
									.settlementDate(a.getKey())
									.rank(++rank[0])
									.entity(b.getKey())
									.amount(b.getValue())
									.build()));
				});
		return rankResults;
	}

	public static List<RankResult> getRankingReportForSellOperation(List<TradeInstruction> tradeInstructions) {

		List<RankResult> rankResults = new ArrayList<>();
		tradeInstructions
				.stream()
				.filter(x -> x.getType() == Type.SELL)
				.collect(groupingBy(TradeInstruction::getSettlementDateModifiedToWorkDay,
						groupingBy(TradeInstruction::getEntity, summingDouble(TradeInstruction::getAmountInUSD))))
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach(a -> {
					int[] rank = { 0 };
					a.getValue()
							.entrySet()
							.stream()
							.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
							.forEach(b -> rankResults.add(RankResult.builder()
									.settlementDate(a.getKey())
									.rank(++rank[0])
									.entity(b.getKey())
									.amount(b.getValue())
									.build()));
				});
		return rankResults;
	}

}
