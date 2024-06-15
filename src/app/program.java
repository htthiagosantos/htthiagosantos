package app;

import entities.ContraPorHora;
import entities.Departamento;
import entities.Trabalhador;
import entities_enums.NivelDoTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();

        System.out.println("Entre com os dados do trabalhador:");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();

        System.out.print("Level: ");
        String levelTrabalhador = sc.nextLine();

        System.out.println("Entre com usa base salarial: ");
        double salarioBase = sc.nextDouble();
        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDoTrabalhador.valueOf(levelTrabalhador), salarioBase,new Departamento(nomeDepartamento));

        System.out.print("Quantos contrato para esse trabalhador? ");
        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++){
            System.out.println("Insira os dados do contrato nº " + i + ": ");
            System.out.println("Data (DD/MM/YYYY)");
            Date contratoData = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();

            System.out.print("Duração (horas): ");
            int horas = sc.nextInt();

            ContraPorHora contrato = new ContraPorHora(contratoData, horas, valorPorHora);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.println();
        System.out.print("Enre com o mês e ano para calcular o salario: (MM/YYYY): ");
        String mesEano = sc.next();
        int mes = Integer.parseInt(mesEano.substring(0, 2));
        int ano = Integer.parseInt(mesEano.substring(3));

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());

        System.out.println("Renda para " + mesEano + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));


        sc.close();
    }


}