package com.locadora.service.Impl;

import com.locadora.model.Agencia;
import com.locadora.repository.AgenciaRepository;
import com.locadora.service.AgenciaService;
import com.locadora.utils.IdGenerator;

import java.util.List;

public class AgenciaServiceImpl implements AgenciaService {
    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    @Override
    public void cadastrarAgencia(String nome, String endereco, String telefone) {
        Long id = IdGenerator.getInstance().generateId();
        Agencia novaAgencia = new Agencia(id, nome, endereco, telefone);

        if(!agenciaRepository.findAll().contains(novaAgencia)) {
            agenciaRepository.save(novaAgencia);
        }

        throw new RuntimeException("Agência já cadastrada");
    }

    @Override
    public void alterarAgencia(String nome, String endereco, String telefone) {
        Agencia agencia = agenciaRepository.findByNome(nome);
        if(agenciaRepository.findById(agencia.id()).isEmpty()) {
            throw new RuntimeException("Agência não encontrada");
        }

        deletarAgencia(agencia);
        Agencia novaAgencia = new Agencia(agencia.id(), nome, endereco, telefone);
        agenciaRepository.save(novaAgencia);
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
