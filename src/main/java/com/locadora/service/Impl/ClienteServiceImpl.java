package com.locadora.service.Impl;

import com.locadora.model.TipoCliente;
import com.locadora.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
    @Override
    public void cadastrarCliente(String nome, TipoCliente tipoCliente, String documento) {
        System.out.println("Cadastrando cliente...");
    }

    @Override
    public void alterarCliente(String documento) {
        System.out.println("Alterando cliente...");
    }

    @Override
    public void buscarClientePorNome() {
        System.out.println("Buscando cliente por nome...");
    }

    @Override
    public void listarClientes() {
        System.out.println("Listando clientes...");
    }
}
