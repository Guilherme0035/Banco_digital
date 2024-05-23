package src.model;

import java.util.Date;

import src.utils.DateUtil;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(String agencia, String conta, int digitoConta, double saldoInicial) {
        super(agencia, conta, digitoConta, saldoInicial);

    }

    @Override
    public void imprimirExtrato() {

        System.out.println("********************************************");
        System.out.println("*************Extrato Poupança***************");
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Gerado em: " + DateUtil.converterDateParaDataEHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao  : this.movimentacoes) {
            System.out.println(movimentacao);
            System.out.println();
        }
        System.out.println("********************************************");
        System.out.println("********************************************");

        
    }
    
}
