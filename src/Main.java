import com.bancodigital.classes.Cliente;
import com.bancodigital.classes.ClienteNormal;
import com.bancodigital.classes.Conta;
import com.bancodigital.classes.ContaCorrente;
import com.bancodigital.classes.ContaPoupanca;

public class Main {
    public static void main(String[] args) throws Exception {
        // ClienteNormal tem limite de emprestimo de 500
        // ClienteSuper tem limite de emprestimo de 2000
        Cliente fernando = new ClienteNormal("Fernando");

        // usando lombok no telefone:
        fernando.setTelefone("98765-4321");

        Conta cc = new ContaCorrente(fernando);
        Conta cp = new ContaPoupanca(fernando);

        cc.depositar(100);
        cc.transferir(100, cp);

        // cc.imprimirExtrato();
        // cp.imprimirExtrato();

        // Nova regra de negocio:
        // o saldo nao pode ficar negativo
        // a tentativa de saque abaixo vai mostrar um erro
        cc.sacar(10);

        // O cliente agora pode pedir emprestimo
        // o valor sera depositado na conta informada
        fernando.pedirEmprestimo(600, cc);
        fernando.pedirEmprestimo(400, cc);

        // depois de receber o emprestimo, o cliente pode sacar o valor que tentou
        // anteriormente e nao conseguiu
        cc.sacar(10);

        // Agora todas as movimentacoes ficam registradas no sistema
        // cada movimentacao tem uma data, valor e tipo (DEBITO ou CREDITO).
        // usei "Collections", "Stream API" e "Method Reference"
        // Classes novas: Extrato e Movimentacao
        // imprimirExtratoComMovimentacoes foi definido na interface IConta
        // imprimirExtratoComMovimentacoes eh polimorfico,
        // em Movimentacao os metodos "formatar..." representam o uso de encapsulamento
        cc.imprimirExtratoComMovimentacoes();
        cp.imprimirExtratoComMovimentacoes();
    }
}
