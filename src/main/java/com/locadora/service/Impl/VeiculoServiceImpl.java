package com.locadora.service.Impl;

import com.locadora.dataFramework.CrudRepository;
import com.locadora.factory.VeiculoFactory;
import com.locadora.model.Agencia;
import com.locadora.model.Veiculo;

import java.util.List;

public class VeiculoServiceImpl {
        private CrudRepository<Veiculo, Long> veiculoRepository;

        public VeiculoServiceImpl(CrudRepository<Veiculo, Long> veiculoRepository) {
            this.veiculoRepository = veiculoRepository;
        }

        public Veiculo cadastrarVeiculo(String tipo, String placa, String modelo, String marca, Agencia agencia) {
            List<Veiculo> veiculosExistentes = veiculoRepository.findAll();
            boolean placaExistente = veiculosExistentes.stream()
                    .anyMatch(v -> v.getPlaca().equalsIgnoreCase(placa));
            if (placaExistente) {
                throw new IllegalArgumentException("Veículo com essa placa já está cadastrado.");
            }

            Veiculo veiculo = VeiculoFactory.criarVeiculo(tipo, placa, modelo, marca, agencia);

            return veiculoRepository.save(veiculo);
        }

        public Veiculo alterarVeiculo(Long id, String tipo, String placa, String modelo, String marca, Agencia agencia) {
            Veiculo veiculo = veiculoRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado."));

            List<Veiculo> veiculosExistentes = veiculoRepository.findAll();
            boolean placaExistente = veiculosExistentes.stream()
                    .anyMatch(v -> v.getPlaca().equalsIgnoreCase(placa) && !v.getId().equals(id));
            if (placaExistente) {
                throw new IllegalArgumentException("Outra veículo com essa placa já está cadastrado.");
            }

            veiculo.setDisponivel(veiculo.isDisponivel());
            veiculo.setPlaca(placa);
            veiculo.setModelo(modelo);
            veiculo.setMarca(marca);
            veiculo.setAgencia(agencia);

            return veiculoRepository.save(veiculo);
        }

        // Buscar Veículo por Modelo
        public List<Veiculo> buscarVeiculosPorModelo(String modelo) {
            return veiculoRepository.findAll().stream()
                    .filter(v -> v.getModelo().toLowerCase().contains(modelo.toLowerCase()))
                    .toList();
        }

        // Buscar Veículo por Placa
        public Veiculo buscarVeiculoPorPlaca(String placa) {
            return veiculoRepository.findAll().stream()
                    .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                    .findFirst()
                    .orElse(null);
        }

        // Listar todos os veículos
        public List<Veiculo> listarVeiculos() {
            return veiculoRepository.findAll();
        }
    }

}
