package com.locadora.model;

public class Moto extends Veiculo {
    public Moto(String placa, String modelo, String marca, Agencia agencia) {
        super(placa, modelo, marca, agencia);
    }

    @Override
    public double getValorDiaria() {
        return 100.00;
    }
}
