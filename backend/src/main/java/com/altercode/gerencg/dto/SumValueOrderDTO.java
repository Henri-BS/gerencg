package com.altercode.gerencg.dto;


//refatorar para adicionar os atributos da classe OrderStats
// e alterar a função repository
// para poder chamar a função de atualização na classe findall


public class SumValueOrderDTO {
    private String statsId;
    private Double expense;


    public SumValueOrderDTO(String statsId, Double value) {
        this.statsId = statsId;
        this.expense = value ;
    }

    public String getStatsId() {
        return statsId;
    }

    public void setStatsId(String statsId) {
        this.statsId = statsId;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }
}
