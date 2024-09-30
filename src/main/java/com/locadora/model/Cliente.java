package com.locadora.model;

import java.util.Objects;

public record Cliente(Long id, String nome, String documento, TipoCliente tipo) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(documento, cliente.documento) && tipo == cliente.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, documento, tipo);
    }
}
