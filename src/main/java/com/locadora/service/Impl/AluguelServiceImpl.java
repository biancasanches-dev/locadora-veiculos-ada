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
    private final AgenciaRepository agenciaRepository;
    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;
    private final AluguelRepository aluguelRepository;

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
        Cliente cliente = clienteRepository.findByDocumento(documento);
        Aluguel aluguel = aluguelRepository.findByCliente(cliente);

        if (aluguel == null || cliente == null) {
            throw new RuntimeException("Cliente não possui aluguéis");
        }

        System.out.println(aluguel);
    }

    @Override
    public void listarAlugueisPorVeiculo(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        Aluguel aluguel = aluguelRepository.findByPlaca(placa);

        if (aluguel == null || veiculo == null) {
            throw new RuntimeException("Veículo não possui aluguéis");
        }

        System.out.println(aluguel);
    }

    @Override
    public void gerarComprovante(String placa, String documento) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        Cliente cliente = clienteRepository.findByDocumento(documento);
        Aluguel aluguel = aluguelRepository.findByPlaca(placa);

        if (veiculo == null || cliente == null || aluguel == null) {
            throw new RuntimeException("Veículo, cliente ou aluguel não encontrado");
        }

        System.out.println("**************************************");
        System.out.println("*        Comprovante de Aluguel      *");
        System.out.println("**************************************");
        System.out.println("Cliente: " + cliente.nome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Data de Aluguel: " + aluguel.getDataHoraAluguel());
        System.out.println("Previsão de Devolução: " + aluguel.getPrevisaoDevolucao());
    }
}
