package com.locadora.repository;

import com.locadora.dataFramework.CrudRepositoryImpl;
import com.locadora.model.Agencia;

public class AgenciaRepository extends CrudRepositoryImpl<Agencia> {

    public Agencia findByNome(String nome) {
        return super.store.stream()
                .filter(agencia -> agencia.nome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    public Agencia findByEndereco(String endereco) {
        return super.store.stream()
                .filter(agencia -> agencia.endereco().equals(endereco))
                .findFirst()
                .orElse(null);
    }
}
