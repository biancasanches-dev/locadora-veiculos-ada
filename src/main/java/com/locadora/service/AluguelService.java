package com.locadora.service;

import com.locadora.model.Aluguel;
import com.locadora.model.Cliente;

import java.util.List;

public interface AluguelService {
    void alugarVeiculo(String agencia, String placa, String documento, int dias);
    void prorrogarAluguel(String placa, Cliente cliente, int dias);
    List<Aluguel> listarAlugueis();
    void listarAlugueisPorCliente(String documento);
    void listarAlugueisPorVeiculo(String placa);
    void gerarComprovante(String placa, String documento);
}
