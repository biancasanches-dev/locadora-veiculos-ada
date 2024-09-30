package com.locadora.repository;

import com.locadora.dataFramework.CrudRepositoryImpl;
import com.locadora.model.Aluguel;
import com.locadora.model.Devolucao;

import java.time.LocalDateTime;

public class DevolucaoRepository extends CrudRepositoryImpl<Devolucao> {

    public Devolucao findByAluguel(Aluguel aluguel) {
        return super.store.stream()
                .filter(devolucao -> devolucao.aluguel().equals(aluguel))
                .findFirst()
                .orElse(null);
    }

    public Devolucao findByDataDevolucao(LocalDateTime dataDevolucao) {
        return super.store.stream()
                .filter(devolucao -> devolucao.dataHoraDevolucao().equals(dataDevolucao))
                .findFirst()
                .orElse(null);
    }
}
