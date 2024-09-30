package com.locadora.service;

import com.locadora.model.Cliente;
import com.locadora.model.TipoCliente;

import java.util.List;

public interface ClienteService {
    void cadastrarCliente(String nome, String documento, int tipo);
    void alterarCliente(String nome, String documento, int tipo);
    void excluirCliente(String documento);
    Cliente buscarClientePorNome(String nome);
    Cliente buscarClientePorDocumento(String documento);
    List<Cliente> listarClientes();
}
