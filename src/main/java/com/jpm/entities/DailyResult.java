package com.jpm.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyResult {
    private String entityName;
    private double totalSell;
    private double totalBuy;
    private LocalDate settlementDate;

}
