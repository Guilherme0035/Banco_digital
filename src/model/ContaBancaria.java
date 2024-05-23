package src.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;


public abstract class ContaBancaria {
    
    //#region Atributos
    protected String agencia;
    protected String conta;
    protected int digitoConta;
    protected double saldo;
    protected double VALOR_MININO_DEPOSITO = 10.0;
    protected Date dataAbertura;
    protected ArrayList<Movimentacao> movimentacoes;

    //#endregion

    //#region Construtores
    public ContaBancaria(String agencia, String conta, int digitoConta, double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digitoConta = digitoConta;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();

        //criando array
        this.movimentacoes = new ArrayList<Movimentacao>();

        //criando a primeira movimentação 
        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);

        //add movimentação no array movimentacoes
        this.movimentacoes.add(movimentacao);
    }
    //#endregion


    //#region Setters e Getters
    public Date getDataAbertura() {
        return dataAbertura;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public int getDigitoConta() {
        return digitoConta;
    }
    public void setDigitoConta(int digitoConta) {
        this.digitoConta = digitoConta;
    }
    public double getSaldo() {
        return saldo;
    }
    //#endregion
   

    //#region Metodos

    public void depositar(double valor){
        if(valor < VALOR_MININO_DEPOSITO){
            throw new InputMismatchException("o valor minimo de deposito é R$ " + VALOR_MININO_DEPOSITO);
        }
        this.saldo += valor;
        // fazendo uma movimentação no extrato
        Movimentacao movimentacao = new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);
    }

    public double sacar(Double valor){
        if(valor > this.saldo){
            throw new InputMismatchException("O saldo insuficiente");
        }
        this.saldo -= valor;

        // fazendo uma movimentação no extrato
        Movimentacao movimentacao = new Movimentacao("Retirada de valor", valor);
        this.movimentacoes.add(movimentacao);
        return valor;
    }

    public void transferir(double valor, ContaBancaria contaDestino){

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

     public abstract void imprimirExtrato();
    //#endregion
}
