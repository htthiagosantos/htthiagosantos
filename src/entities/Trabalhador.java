package entities;

import entities_enums.NivelDoTrabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {

    private String nome;
    private NivelDoTrabalhador level;
    private Double baseSalarial;

    private Departamento departamento;
    private List<ContraPorHora> contratos = new ArrayList<>();

    public Trabalhador(String nomeTrabalhador, NivelDoTrabalhador nivelDoTrabalhador, double salarioBase, Departamento departamento){

    }

    public Trabalhador(Double baseSalarial, Departamento departamento, NivelDoTrabalhador level, String nome) {
        this.baseSalarial = baseSalarial;
        this.departamento = departamento;
        this.level = level;
        this.nome = nome;
    }

    public Double getBaseSalarial() {
        return baseSalarial;
    }

    public void setBaseSalarial(Double baseSalarial) {
        this.baseSalarial = baseSalarial;
    }

    public List<ContraPorHora> getContrato() {
        return contratos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public NivelDoTrabalhador getLevel() {
        return level;
    }

    public void setLevel(NivelDoTrabalhador level) {
        this.level = level;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarContrato(ContraPorHora contrato){
        contratos.add(contrato);
    }

    public void removerContrato(ContraPorHora contrato){
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        double soma = baseSalarial;
        Calendar calendario = Calendar.getInstance();
        for (ContraPorHora c : contratos){
            calendario.setTime(c.getDate());
            int c_ano = calendario.get(Calendar.YEAR);
            int c_mes = 1 + calendario.get(Calendar.MONTH);
            if (ano== c_ano && mes == c_mes){
                soma += c.valorTotal();
            }

        }
        return soma;
    }
}
