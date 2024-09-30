package com.locadora.service.Impl;

import com.locadora.model.Veiculo;
import com.locadora.repository.AgenciaRepository;
import com.locadora.repository.AluguelRepository;
import com.locadora.repository.DevolucaoRepository;
import com.locadora.service.DevolucaoBase;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DevolucaoPF extends DevolucaoBase {

    public DevolucaoPF(AluguelRepository aluguelRepository, AgenciaRepository agenciaRepository, DevolucaoRepository devolucaoRepository) {
        super(aluguelRepository, agenciaRepository, devolucaoRepository);
    }

    public double calcularDesconto(long dias, double valor) {
        if(dias > 5) {
            return valor * 0.5;
        }
        return valor;
    }

    @Override
    public double calcularValorTotal(Veiculo veiculo, LocalDateTime dataHoraAluguel, LocalDateTime dataHoraDevolucao) {
        long dias = dataHoraAluguel.until(dataHoraDevolucao, ChronoUnit.DAYS);
        double valorDiaria = veiculo.getValorDiaria();
        double valor = dias * valorDiaria;

        return calcularDesconto((int) dias, valor);
    }
}
