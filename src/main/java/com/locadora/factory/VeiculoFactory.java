package com.locadora.factory;

import com.locadora.model.*;

public class VeiculoFactory {
    public static Veiculo criarVeiculo(String tipo, String placa, String modelo, String marca, Agencia agencia) {
        return switch (tipo.toLowerCase()) {
            case "carro" -> new Carro(placa, modelo, marca, agencia);
            case "moto" -> new Moto(placa, modelo, marca, agencia);
            case "caminhao" -> new Caminhao(placa, modelo, marca, agencia);
            default -> throw new IllegalArgumentException("Tipo de veículo inválido");
        };
    }
}
