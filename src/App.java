package src;

import src.model.ContaCorrente;
import src.model.ContaPoupanca;
import src.utils.DateUtil;

public class App {
    
    public static void main(String[] args) {

        
        System.out.println("Criando um banco digital");
        System.out.println();

        ContaCorrente conta1 = new ContaCorrente("0001", "7542", 5, 100.0);
        System.out.println("Saldo atual é R$" + conta1.getSaldo());
        System.out.println();

        conta1.depositar(250.0);
        System.out.println("Saldo atual é R$" + conta1.getSaldo());
        System.out.println();

        conta1.sacar(150.0);
        System.out.println("Saldo atual é R$" + conta1.getSaldo());
        System.out.println();


        ContaPoupanca conta2 = new ContaPoupanca("0001", "7542", 6, 200.0);

        conta2.transferir(100.0, conta1);
        System.out.println("Saldo conta destino é R$" + conta2.getSaldo());
        System.out.println();

        System.out.println("Saldo atual é R$" + conta1.getSaldo());
        System.out.println();
        
        // n foi preciso instanciar a classe pq esse metodo está como static
        String dataEHoraFormata = DateUtil.converterDateParaDataEHora(conta2.getDataAbertura());
        String dataFormatada = DateUtil.converterDateParaData(conta2.getDataAbertura());
        String horaFormatada = DateUtil.converterDateParaHora(conta2.getDataAbertura());

        System.out.println("Data e hora da abertura da conta é: " + dataEHoraFormata);
        System.out.println("Data de abertura da conta: " + dataFormatada);
        System.out.println("Horário de abertura da conta: " + horaFormatada);


        conta1.imprimirExtrato();

        System.out.println("==============================================================");

        conta2.imprimirExtrato();


    }

}
