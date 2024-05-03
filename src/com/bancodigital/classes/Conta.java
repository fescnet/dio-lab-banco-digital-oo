package com.bancodigital.classes;

import com.bancodigital.interfaces.IConta;

import lombok.Getter;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected @Getter int agencia;
    protected @Getter int numero;
    protected @Getter double saldo;
    protected Cliente cliente;
    protected Extrato extrato;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.extrato = new Extrato();
    }

    @Override
    public void sacar(double valor) {
        if (!temSaldoSuficiente(valor)) {
            mostrarErroSaldoInsuficiente();
            return;
        }
        saldo -= valor;
        extrato.registrarMovimentacao(-valor);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        extrato.registrarMovimentacao(valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (!temSaldoSuficiente(valor)) {
            mostrarErroSaldoInsuficiente();
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private boolean temSaldoSuficiente(double valor) {
        return saldo - valor >= 0;
    }

    private void mostrarErroSaldoInsuficiente() {
        System.out.println("************* Saldo insuficiente **************");
    }

    protected void imprimirInfosComuns() {
        System.out.println();
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println();
    }

    public void imprimirMovimentacoes() {
        System.out.println("=== Histórico de movimentações ===");
        System.out.println();
        extrato.imprimir();
        System.out.println();
    }
}