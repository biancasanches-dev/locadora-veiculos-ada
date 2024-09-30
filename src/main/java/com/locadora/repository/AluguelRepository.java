package com.locadora.repository;

import com.locadora.dataFramework.CrudRepositoryImpl;
import com.locadora.model.Aluguel;
import com.locadora.model.Cliente;

public class AluguelRepository extends CrudRepositoryImpl<Aluguel> {
    public Aluguel findByPlaca(String placa) {
        return super.store.stream()
                .filter(aluguel -> aluguel.getVeiculo().equals(placa))
                .findFirst()
                .orElse(null);
    }

    public Aluguel findByCliente(Cliente cliente) {
        return super.store.stream()
                .filter(aluguel -> aluguel.getCliente().equals(cliente))
                .findFirst()
                .orElse(null);
    }
}
