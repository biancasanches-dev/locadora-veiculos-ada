package com.locadora.repository;

import com.locadora.dataFramework.CrudRepositoryImpl;
import com.locadora.model.Cliente;

public class ClienteRepository extends CrudRepositoryImpl<Cliente> {

    public Cliente findByDocumento(String documento) {
        return super.store.stream()
                .filter(cliente -> cliente.documento().equals(documento))
                .findFirst()
                .orElse(null);
    }

    public Cliente findByNome(String nome) {
        return super.store.stream()
                .filter(cliente -> cliente.nome().equals(nome))
                .findFirst()
                .orElse(null);
    }
}
