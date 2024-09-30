package com.locadora.service.Impl;

import com.locadora.model.Agencia;
import com.locadora.model.Aluguel;
import com.locadora.model.Cliente;
import com.locadora.model.Veiculo;
import com.locadora.repository.AgenciaRepository;
import com.locadora.repository.AluguelRepository;
import com.locadora.repository.ClienteRepository;
import com.locadora.repository.VeiculoRepository;
import com.locadora.service.AluguelService;

import java.time.LocalDateTime;
import java.util.List;

public class AluguelServiceImpl implements AluguelService {
    private AgenciaRepository agenciaRepository;
    private VeiculoRepository veiculoRepository;
    private ClienteRepository clienteRepository;
    private AluguelRepository aluguelRepository;

    public AluguelServiceImpl(AgenciaRepository agenciaRepository, VeiculoRepository veiculoRepository, ClienteRepository clienteRepository, AluguelRepository aluguelRepository) {
        this.agenciaRepository = agenciaRepository;
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public void alugarVeiculo(String agenciaNome, String placa, String documento, int dias) {
        Agencia agencia = agenciaRepository.findByNome(agenciaNome);
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        Cliente cliente = clienteRepository.findByDocumento(documento);
        LocalDateTime dataHoraAluguel = LocalDateTime.now();

        if (agencia == null || veiculo == null || cliente == null) {
            throw new RuntimeException("Agência, veículo ou cliente não encontrado");
        }

        Aluguel aluguel = new Aluguel(veiculo, cliente, dataHoraAluguel, agencia);
        aluguel.setPrevisaoDevolucao(dataHoraAluguel.plusDays(dias));
    }

    @Override
    public void prorrogarAluguel(String placa, Cliente cliente, int dias) {
        Aluguel aluguel = aluguelRepository.findByCliente(cliente);

        if (aluguel == null) {
            throw new RuntimeException("Aluguel não encontrado");
        }

        aluguel.setPrevisaoDevolucao(aluguel.getPrevisaoDevolucao().plusDays(dias));
    }

    @Override
    public List<Aluguel> listarAlugueis() {
        return aluguelRepository.findAll();
    }

    @Override
    public void listarAlugueisPorCliente(String documento) {

    }

    @Override
    public void listarAlugueisPorVeiculo(String placa) {

    }

    @Override
    public void gerarComprovante(String placa, String documento) {

    }
}
