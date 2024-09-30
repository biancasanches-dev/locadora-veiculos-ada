package com.locadora.service.Impl;

import com.locadora.model.Cliente;
import com.locadora.model.TipoCliente;
import com.locadora.repository.ClienteRepository;
import com.locadora.service.ClienteService;
import com.locadora.utils.IdGenerator;

import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente buscarClientePorDocumento(String documento) {
        return clienteRepository.findByDocumento(documento);
    }

    @Override
    public Cliente buscarClientePorNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void cadastrarCliente(String nome, String documento, int tipo) {
        if (buscarClientePorDocumento(documento) != null) {
            throw new RuntimeException("Cliente já cadastrado");
        }

        Long id = IdGenerator.getInstance().generateId();
        TipoCliente tipoCLiente;
        if (tipo == 1) {
            tipoCLiente = TipoCliente.PESSOA_FISICA;
        } else if (tipo == 2) {
            tipoCLiente = TipoCliente.PESSOA_JURIDICA;
        } else {
            throw new RuntimeException("Tipo de cliente inválido");
        }

        Cliente cliente = new Cliente(id, nome, documento, tipoCLiente);
        clienteRepository.save(cliente);
    }

    @Override
    public void alterarCliente(String nome, String documento, int tipo) {
        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        TipoCliente tipoCliente;
        if (tipo == 1) {
            tipoCliente = TipoCliente.PESSOA_FISICA;
        } else if (tipo == 2) {
            tipoCliente = TipoCliente.PESSOA_JURIDICA;
        } else {
            throw new RuntimeException("Tipo de cliente inválido");
        }

        excluirCliente(documento);
        Cliente clienteAtualizado = new Cliente(cliente.id(), nome, documento, tipoCliente);
        clienteRepository.save(clienteAtualizado);
    }

    @Override
    public void excluirCliente(String documento) {
        Cliente cliente = buscarClientePorDocumento(documento);
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.delete(cliente);
    }

}
