package com.locadora.service;

public interface VeiculoService {
    void cadastrarVeiculo(String placa, String marca, String modelo, int ano, double valorDiaria);
    void alterarVeiculo(String placa);
    void buscarVeiculoPorNome();
    void buscarVeiculoPorPlaca(String placa);
    void listarVeiculosDisponiveis(String agencia);
}
