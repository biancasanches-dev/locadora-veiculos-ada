package com.locadora.repository;

import com.locadora.dataFramework.CrudRepositoryImpl;
import com.locadora.model.Veiculo;

public class VeiculoRepository extends CrudRepositoryImpl<Veiculo> {

    public Veiculo findByPlaca(String placa) {
        return super.store.stream()
                .filter(veiculo -> veiculo.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    public Veiculo findByModelo(String modelo) {
        return super.store.stream()
                .filter(veiculo -> veiculo.getModelo().equals(modelo))
                .findFirst()
                .orElse(null);
    }
}
