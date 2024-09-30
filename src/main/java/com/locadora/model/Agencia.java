package com.locadora.model;

public record Agencia(Long id, String nome, String endereco, String telefone) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agencia agencia)) return false;
        return id.equals(agencia.id) && nome.equals(agencia.nome) && endereco.equals(agencia.endereco) && telefone.equals(agencia.telefone);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
