package src.model;

import java.util.Date;

import src.utils.DateUtil;


public class Movimentacao {
    
    private String descricao;
    private Date data;
    private Double valor;


    public Movimentacao(String descricao, Double valor) {
        this.descricao = descricao;
        this.data = new Date();
        this.valor = valor;
    }


    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getData() {
        return data;
    }
    public Double getValor() {
        return valor;
    }

    @Override
    public String toString(){

        String dataFormatada = DateUtil.converterDateParaDataEHora(this.getData());
        return  this.getDescricao() + " \n" + dataFormatada + " - R$" + this.valor;

    }


}
