package com.bancodigital.classes;

public class ClienteNormal extends Cliente {
    public ClienteNormal(String nome) {
        super(nome);
        limiteDeEmprestimo = 500;
    }
}
