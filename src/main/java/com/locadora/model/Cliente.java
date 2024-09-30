package com.locadora.model;

import java.time.LocalDateTime;

public record Cliente(Long id, String nome, String documento, TipoCliente tipo) {
    public Cliente {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento do cliente não pode ser nulo ou vazio");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo do cliente não pode ser nulo");
        }
    }
}
