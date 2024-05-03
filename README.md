# Criando um Banco Digital com Java e Orientação a Objetos

## Sobre a solução

Novas funcionalidades:

1) ClienteNormal e ClienteSuper.  ClienteNormal tem limite de empréstimo pré-aprovado de 500, enquanto o ClienteSuper o valor é de 2000;
2) Clientes podem pedir empréstimo.  Valores iguais ou inferiores ao limite são aprovados e valores superiores são negados;
3) Histórico de movimentações nas contas;
4) Regra de negócio que valida se o saldo é suficiente para a operação.

Para a solução, além dos conceitos de Orientação a Objetos e lombok, usei também Stream API, Collections e Method Reference.

## Enunciado

Desafio: Considerando nosso conhecimento no domínio bancário, iremos abstrair uma solução Orientada a Objetos em Java. Para isso, vamos interpretar o seguinte cenário: “Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).”
