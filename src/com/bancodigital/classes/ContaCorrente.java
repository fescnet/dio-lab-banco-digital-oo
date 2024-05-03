package com.bancodigital.classes;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("============================= Extrato Conta Corrente ================================");
        super.imprimirInfosComuns();
    }

    @Override
    public void imprimirExtratoComMovimentacoes() {
        System.out.println("==================== Extrato Conta Corrente COM MOVIMENTACOES =======================");
        super.imprimirInfosComuns();
        imprimirMovimentacoes();
    }

}