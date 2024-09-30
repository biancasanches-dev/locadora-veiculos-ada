package com.locadora.model;

public record Agencia(Long id, String nome, String endereco, String telefone) {
    public Agencia {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da agência não pode ser nulo ou vazio");
        }
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("Endereço da agência não pode ser nulo ou vazio");
        }
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone da agência não pode ser nulo ou vazio");
        }
    }
}
