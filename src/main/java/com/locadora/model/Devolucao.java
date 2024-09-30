package com.locadora.model;

import java.time.LocalDateTime;
import java.util.Objects;

public record Devolucao(Aluguel aluguel, Agencia agencia, LocalDateTime dataHoraDevolucao, double valorTotal) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Devolucao devolucao)) return false;
        return Double.compare(valorTotal, devolucao.valorTotal) == 0 && Objects.equals(aluguel, devolucao.aluguel) && Objects.equals(agencia, devolucao.agencia) && Objects.equals(dataHoraDevolucao, devolucao.dataHoraDevolucao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aluguel, agencia, dataHoraDevolucao, valorTotal);
    }
}
