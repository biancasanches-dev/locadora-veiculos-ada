package com.locadora.model;

import java.time.LocalDateTime;

public class Aluguel {
    private Long id;
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataHoraAluguel;
    private LocalDateTime previsaoDevolucao;
    private Agencia agencia;

    public Aluguel(Veiculo veiculo, Cliente cliente, LocalDateTime dataHoraAluguel, Agencia agencia) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataHoraAluguel = dataHoraAluguel;
        this.agencia = agencia;
        veiculo.setDisponivel(false);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataHoraAluguel() {
        return dataHoraAluguel;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public LocalDateTime getPrevisaoDevolucao() {
        return previsaoDevolucao;
    }

    public void setPrevisaoDevolucao(LocalDateTime previsaoDevolucao) {
        this.previsaoDevolucao = previsaoDevolucao;
    }

    @Override
    public String toString() {
        return "Aluguel \n" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", dataHoraAluguel=" + dataHoraAluguel +
                ", agencia=" + agencia;
    }
}
