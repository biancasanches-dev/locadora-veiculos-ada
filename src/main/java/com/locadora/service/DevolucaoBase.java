package com.locadora.service;

import com.locadora.model.*;
import com.locadora.repository.AgenciaRepository;
import com.locadora.repository.AluguelRepository;
import com.locadora.repository.DevolucaoRepository;

import java.time.LocalDateTime;

public abstract class DevolucaoBase {
    private final AluguelRepository aluguelRepository;
    private final AgenciaRepository agenciaRepository;
    private final DevolucaoRepository devolucaoRepository;

    public DevolucaoBase(AluguelRepository aluguelRepository, AgenciaRepository agenciaRepository, DevolucaoRepository devolucaoRepository) {
        this.aluguelRepository = aluguelRepository;
        this.agenciaRepository = agenciaRepository;
        this.devolucaoRepository = devolucaoRepository;
    }

    public abstract double calcularValorTotal(Veiculo veiculo, LocalDateTime dataHoraAluguel, LocalDateTime dataHoraDevolucao);

    public void devolverVeiculo(String placa, Cliente cliente, String agencia) {
        Aluguel aluguel = aluguelRepository.findByCliente(cliente);
        Agencia agenciaDevolucao = agenciaRepository.findByNome(agencia);
        LocalDateTime dataHoraDevolucao = LocalDateTime.now();

        if (aluguel == null || agenciaDevolucao == null) {
            throw new RuntimeException("Aluguel ou agência não encontrado");
        }

        double valorTotal = calcularValorTotal(aluguel.getVeiculo(), aluguel.getDataHoraAluguel(), dataHoraDevolucao);
        Devolucao devolucao = new Devolucao(aluguel, agenciaDevolucao, dataHoraDevolucao, valorTotal);
        devolucaoRepository.save(devolucao);
        aluguel.getVeiculo().setDisponivel(true);
        gerarComprovante(devolucao);
    }

    public void gerarComprovante(Devolucao devolucao) {
        System.out.println("****************************************");
        System.out.println("*        Comprovante de Devolucao      *");
        System.out.println("****************************************");
        System.out.println("Cliente: " + devolucao.aluguel().getCliente());
        System.out.println("Veículo: " + devolucao.aluguel().getVeiculo());
        System.out.println("Data de Aluguel: " + devolucao.aluguel().getDataHoraAluguel());
        System.out.println("Data de Devolução: " + devolucao.dataHoraDevolucao());
        System.out.println("Agência de Devolução: " + devolucao.agencia());
        System.out.println("Valor Total: " + devolucao.valorTotal());
    }
}
