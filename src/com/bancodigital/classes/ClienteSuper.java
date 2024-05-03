package com.bancodigital.classes;

public class ClienteSuper extends Cliente {
    public ClienteSuper(String nome) {
        super(nome);
        limiteDeEmprestimo = 2000;
    }
}
