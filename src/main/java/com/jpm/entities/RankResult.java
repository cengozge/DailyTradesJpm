package com.jpm.entities;

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
public class RankResult {

    private String entity;
    private int rank;
    private Type type;
    private LocalDate settlementDate;
    private double amount;

}
