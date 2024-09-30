package com.locadora.service;

import com.locadora.model.TipoCliente;

public interface ClienteService {
    void cadastrarCliente(String nome, TipoCliente tipoCliente, String documento);
    void alterarCliente(String documento);
    void buscarClientePorNome();
    void listarClientes();
}
