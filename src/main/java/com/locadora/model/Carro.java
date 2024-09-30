package com.locadora.model;

public class Carro extends Veiculo {
    public Carro(String placa, String modelo, String marca, Agencia agencia) {
        super(placa, modelo, marca, agencia);
    }

    public double getValorDiaria() {
        return 150.00;
    }
}
