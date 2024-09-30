package com.locadora.service;

import com.locadora.model.Agencia;

import java.util.List;

public interface AgenciaService {
    void cadastrarAgencia(Agencia agencia);
    void alterarAgencia(Agencia agencia);
    Agencia buscarAgenciaNome(String nome);
    Agencia buscarAgenciaEndereco(String endereco);
    List<Agencia> buscarTodasAgencias();
    void deletarAgencia(Agencia agencia);
}
