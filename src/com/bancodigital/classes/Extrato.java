package com.bancodigital.classes;

import java.util.ArrayList;
import java.util.List;

class Extrato {

    private List<Movimentacao> movimentacoes;

    Extrato() {
        movimentacoes = new ArrayList<>();
    }

    void registrarMovimentacao(double valor) {
        movimentacoes.add(new Movimentacao(valor));
    }

    void imprimir() {
        movimentacoes.stream().forEach(System.out::println);
    }

}
