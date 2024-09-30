package com.locadora.service.Impl;

import com.locadora.model.Agencia;
import com.locadora.repository.AgenciaRepository;
import com.locadora.service.AgenciaService;

import java.util.List;

public class AgenciaServiceImpl implements AgenciaService {
    private AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public void cadastrarAgencia(Agencia agencia) {
        if(!agenciaRepository.findAll().contains(agencia)) {
            agenciaRepository.save(agencia);
        }

        throw new RuntimeException("Agência já cadastrada");
    }

    @Override
    public void alterarAgencia(Agencia agencia) {
        if(agenciaRepository.findById(agencia.id()).isPresent()) {
            agenciaRepository.save(agencia);
        }

        throw new RuntimeException("Agência não encontrada");
    }

    @Override
    public Agencia buscarAgenciaNome(String nome) {
        return agenciaRepository.findByNome(nome);
    }

    @Override
    public Agencia buscarAgenciaEndereco(String endereco) {
        return agenciaRepository.findByEndereco(endereco);
    }

    @Override
    public List<Agencia> buscarTodasAgencias() {
        return agenciaRepository.findAll();
    }

    @Override
    public void deletarAgencia(Agencia agencia) {
        agenciaRepository.delete(agencia);
    }

}
