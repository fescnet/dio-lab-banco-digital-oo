package com.bancodigital.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Movimentacao {
    private LocalDateTime data;
    private double valor;
    private static final String FORMATO_DATA_HORA = "d/M/u H:m";
    private static final String SEPARADOR = " | ";

    Movimentacao(double valor) {
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    private String formatarTipo() {
        String texto = "Tipo: ";
        texto += valor < 0 ? "DÉBITO" : "CRÉDITO";
        return texto;
    }

    private String formatarData() {
        String texto = "Data: "
                .concat(data.format(DateTimeFormatter.ofPattern(FORMATO_DATA_HORA)));
        return texto;
    }

    private String formatarValor() {
        String texto = "Valor: "
                .concat(String.format("%.2f", valor));
        return texto;
    }

    @Override
    public String toString() {

        String texto = formatarData()
                .concat(SEPARADOR)
                .concat(formatarTipo())
                .concat(SEPARADOR)
                .concat(formatarValor());

        return texto;
    }
}
