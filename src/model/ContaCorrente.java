package src.model;

import java.util.Date;

import src.utils.DateUtil;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String agencia, String conta, int digitoConta, double saldoInicial) {
        super(agencia, conta, digitoConta, saldoInicial);

    }

    @Override
    public void imprimirExtrato() {
        
        System.out.println("********************************************");
        System.out.println("***********Extrato Conta corrente***********");
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Gerado em: " + DateUtil.converterDateParaDataEHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao  : this.movimentacoes) {
            System.out.println(movimentacao);
            System.out.println();
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println("********************************************");

    }
}
