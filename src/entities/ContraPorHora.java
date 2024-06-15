package entities;

import java.util.Date;

public class ContraPorHora {

    private Date date;
    private Double valorPorHora;
    private Integer horas;

    public ContraPorHora(){

    }

    public ContraPorHora(Date date, Integer horas, Double valorPorHora) {
        this.date = date;
        horas = horas;
        this.valorPorHora = valorPorHora;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        horas = horas;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public double valorTotal(){
        return valorPorHora * horas;
    }
}
