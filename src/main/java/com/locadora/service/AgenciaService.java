package com.locadora.service;

import com.locadora.model.Agencia;

import java.util.List;

public interface AgenciaService {
    void cadastrarAgencia(String nome, String endereco, String telefone);
    void alterarAgencia(String nome, String endereco, String telefone);
    Agencia buscarAgenciaNome(String nome);
    Agencia buscarAgenciaEndereco(String endereco);
    List<Agencia> buscarTodasAgencias();
    void deletarAgencia(Agencia agencia);
}
