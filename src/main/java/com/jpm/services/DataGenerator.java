package com.jpm.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.jpm.constants.Constant;
import com.jpm.entities.TradeInstruction;
import com.jpm.enums.Currency;
import com.jpm.enums.Type;

public class DataGenerator {

	public static Random random = new Random();

	public static List<TradeInstruction> generateData() {

		int numberOfRecords = 2000;
		List<TradeInstruction> tradeInstructions = new ArrayList<>();

		for (int i = 1; i <= numberOfRecords; i++) {
			Currency randomCurrency = Currency.getRandomCurrency();
			LocalDate settlementDate = getRandomDateFromInstructionDate();
			LocalDate settlementDateModifiedToWorkDay = DateOperation.setDateToFirstWorkDay(settlementDate, randomCurrency);
			int randomNumber = random.nextInt(15);
			String entityName = (randomNumber < 10 ? "0" : "") + randomNumber;
			TradeInstruction tradeInstruction = TradeInstruction.builder()
					.entity(Constant.ENTITY_NAME + entityName)
					.type(Type.getRandomType())
					.agreedFx(random.nextDouble())
					.currency(randomCurrency)
					.instructionDate(getRandomDateFromNowOn())
					.settlementDate(settlementDate)
					.unit(random.nextInt(Constant.UNIT))
					.pricePerUnit(random.nextDouble())
					.settlementDateModifiedToWorkDay(settlementDateModifiedToWorkDay)
					.build();

			tradeInstructions.add(tradeInstruction);
		}
		return tradeInstructions.stream()
				.sorted((e1, e2) -> e1.getSettlementDateModifiedToWorkDay().compareTo(e2.getSettlementDateModifiedToWorkDay()))
				.collect(Collectors.toList());
	}

	public static LocalDate getRandomDateFromNowOn() {
		return addDaysHoursMinsSecs(LocalDate.now());
	}

	public static LocalDate getRandomDateFromInstructionDate() {
		return addDaysHoursMinsSecs(getRandomDateFromNowOn());
	}

	public static LocalDate addDaysHoursMinsSecs(LocalDate givenDate) {
		return givenDate.plusDays(random.nextInt(Constant.PLUS_DAY));
	}
}
