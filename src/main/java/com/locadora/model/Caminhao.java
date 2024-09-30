package com.locadora.model;

public class Caminhao extends Veiculo {
    public Caminhao(String placa, String modelo, String marca, Agencia agencia) {
        super(placa, modelo, marca, agencia);
    }

    @Override
    public double getValorDiaria() {
        return 200.00;
    }
}
