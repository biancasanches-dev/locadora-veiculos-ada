package com.locadora.model;

public abstract class Veiculo {
    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private boolean isDisponivel;
    private Agencia agencia;

    public Veiculo(String placa, String modelo, String marca, Agencia agencia) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.isDisponivel = true;
        this.agencia = agencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public abstract double getValorDiaria();

    @Override
    public String toString() {
        return "Veiculo\n" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", disponivel=" + isDisponivel +
                ", agencia=" + agencia.nome() +
                ", valor=" + getValorDiaria();
    }

}
