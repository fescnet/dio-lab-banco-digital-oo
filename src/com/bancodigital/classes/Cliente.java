package com.bancodigital.classes;

import lombok.Getter;
import lombok.Setter;

public abstract class Cliente {
    private @Getter String nome;
    private @Getter @Setter String telefone;
    protected double limiteDeEmprestimo;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void pedirEmprestimo(double valor, Conta conta) {
        if (limiteDeEmprestimo >= valor) {
            conta.depositar(valor);
            System.out.println(String.format(
                    "Seu empréstimo de %.2f reais foi aprovado!  Valor disponível na sua conta número: %d", valor,
                    conta.getNumero()));
            return;
        }
        System.out.println(String.format("Empréstimo negado.  Seu limite pré-aprovado é de %.2f", limiteDeEmprestimo));
    }
}
