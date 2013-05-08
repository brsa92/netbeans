/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestiHorarios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hugo Azevedo
 */
public class GerirHorarios implements Serializable {

    public GerirHorarios() {
    }
    // Declarar arrays necessarios 
    private static ArrayList<Alunos> alunos = new ArrayList();
    private static ArrayList<Professor> professor = new ArrayList();
    private static ArrayList<Sala> sala = new ArrayList();
    private static ArrayList<Turma> turma = new ArrayList();
    private static ArrayList<Aula> aula = new ArrayList();

    // Aceder aos arrays para leitura 
    public static ArrayList<Alunos> getAlunos() {
        return alunos;
    }

    public static ArrayList<Professor> getProfessor() {
        return professor;
    }

    public static ArrayList<Sala> getSala() {
        return sala;
    }

    public static ArrayList<Turma> getTurma() {
        return turma;
    }
    public static ArrayList<Aula> getHorarios() {
        return aula;
    }
    // Aceder aos arrays para escrita 

    public static void setAlunos(ArrayList<Alunos> aAlunos) {
        alunos = aAlunos;
    }

    public static void setProfessor(ArrayList<Professor> aProfessor) {
        professor = aProfessor;
    }

    public static void setSala(ArrayList<Sala> aSala) {
        sala = aSala;
    }

    public static void setTurma(ArrayList<Turma> aTurma) {
        turma = aTurma;
    }
    public static void setHorarios(ArrayList<Aula> aHorarios) {
        aula = aHorarios;
    }
    // Ler dados nos ficheiros

    public static void lerAlunos() {

        int numero;
        String nome;
        int ano;
        int mes;
        int dia;
        String contacto_telefonico;
        String correio_electronico;

        String[] slit;
        String[] data = new String[3];

        if (alunos.isEmpty()) {
            try {

               BufferedReader br = new BufferedReader(new FileReader("alunos.txt"));

                while (br.ready()) {

                    String linha = br.readLine();
                    if (!linha.contains("numero")) {
                        slit = linha.split(";");
                        data = slit[2].split("/");
                        numero = Integer.parseInt(slit[0]);
                        nome = slit[1];
                        dia = Integer.parseInt(data[0]);
                        mes = Integer.parseInt(data[1]);
                        ano = Integer.parseInt(data[2]);
                        Data data_de_nascimento = new Data(ano, mes, dia);
                        contacto_telefonico = slit[3];
                        correio_electronico = slit[4];
                        Alunos a = new Alunos(numero, nome, data_de_nascimento, contacto_telefonico, correio_electronico);
                        alunos.add(a);

                    }
                }
                br.close();
                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println(alunos.get(i));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
   }

    public static void lerProfessores() {

        String sigla_professor;
        String nome_professor;
        int ano;
        int mes;
        int dia;
        String correio_electronico;

        String[] slit;
        String[] data = new String[3];

        if (professor.isEmpty()) {
            try {

                BufferedReader br = new BufferedReader(new FileReader("professores.txt"));

                while (br.ready()) {

                    String linha = br.readLine();
                    if (!linha.contains("sigla")) {
                        slit = linha.split(";");
                        data = slit[2].split("/");
                        sigla_professor = slit[0];
                        nome_professor = slit[1];
                        dia = Integer.parseInt(data[0]);
                        mes = Integer.parseInt(data[1]);
                        ano = Integer.parseInt(data[2]);
                        Data data_de_nascimento = new Data(ano, mes, dia);
                        correio_electronico = slit[3];
                        Professor pr = new Professor(sigla_professor, nome_professor, data_de_nascimento, correio_electronico);
                        professor.add(pr);

                    }
                }
                br.close();
                for (int i = 0; i < professor.size(); i++) {
                    System.out.println(professor.get(i));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void lerSalas() {

        String codigo_sala;
        String tipo_sala;
        int capacidade;

        String[] slit;

        if (sala.isEmpty()) {
            try {

                BufferedReader br = new BufferedReader(new FileReader("salas.txt"));

                while (br.ready()) {

                    String linha = br.readLine();
                    if (!linha.contains("codigo")) {
                        slit = linha.split(";");
                        codigo_sala = slit[0];
                        tipo_sala = slit[1];
                        capacidade = Integer.parseInt(slit[2]);
                        Sala sl = new Sala(codigo_sala, tipo_sala, capacidade);
                        sala.add(sl);

                    }
                }
                br.close();
                for (int i = 0; i < sala.size(); i++) {
                    System.out.println(sala.get(i));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void lerTurmas() {

        if (alunos.isEmpty()) {
            System.out.println("Insira ou carregue alunos para o software");
        } else {

            String designaco_turma;

            String[] slit;


            if (turma.isEmpty()) {
                try {

                BufferedReader br = new BufferedReader(new FileReader("turmas.txt"));
  while (br.ready()) {

                        String linha = br.readLine();
                        if (!linha.contains("designacao")) {
                            slit = linha.split(";");
                            designaco_turma = slit[0];
                            Turma tl = new Turma(designaco_turma);
                            
                            for (int i = 1; i < slit.length; i++) {
                                Alunos al1a = new Alunos(Integer.parseInt(slit[i]));
                                tl.adicionarAlunos(al1a);
                            }
                            //System.out.println(" Turma "+ tl.getDesignaco_turma()+"\n");
                            turma.add(tl);
                        }
                    }
                    br.close();
                for (int i = 0; i < sala.size(); i++) {
                    System.out.println(sala.get(i));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
                
            }
        }
    }
    public static void lerHorarios() {

      


        String designacao_turma;
        String sigla_disciplina;
        String tipo_aula;
        int dia_semana;
        int Hora_inicio;
        int duracao_aula;
        String professores;
        String salas;



        String[] slit;


        if (aula.isEmpty()) {
            try {
               BufferedReader br = new BufferedReader(new FileReader("horarios.txt")); 
                    while (br.ready()) {

                        String linha = br.readLine();
                        if (!linha.contains("designacao_turma")) {
                            slit = linha.split(";");

                            designacao_turma = slit[0];
                            sigla_disciplina = slit[1];
                            tipo_aula = slit[2];
                            dia_semana = Integer.parseInt(slit[3]);
                            Hora_inicio = Integer.parseInt(slit[4]);
                            duracao_aula = Integer.parseInt(slit[5]);

                            professores = slit[6];
                            salas = slit[7];

                            Aula h = new Aula(designacao_turma, 
                                    sigla_disciplina, tipo_aula, dia_semana,
                                    Hora_inicio, duracao_aula, professores, salas);
                            aula.add(h);
                        }
                    }
                
                for (int i = 0; i < aula.size(); i++) {
                    System.out.println(aula.get(i));
                }
                    
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    //Inserir Objectos manualmente sem ser em ficheiros de texto
    public static Alunos inserirAlunos() {
        Data d1 = new Data(1991, 07, 28);
        Alunos al = new Alunos(1111227, "Hugo Azevedo", d1, "917929594", "hugoazevedo5471@gmail.com");
        alunos.add(al);
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(alunos.get(i));
        }
        return al;

    }

    public static Professor inserirProfessores() {
        Data d1 = new Data(1960, 07, 10);
        Professor pr1 = new Professor("HAA", "Hugo de Almeida Azevedo", d1, "haa@isep.ipp.pt");
        professor.add(pr1);
        for (int i = 0; i < professor.size(); i++) {
            System.out.println(professor.get(i));
        }
        return pr1;

    }

    public static Sala inserirSalas() {

        Sala sl1 = new Sala("B101", "anfiteatro", 20);
        sala.add(sl1);
        for (int i = 0; i < sala.size(); i++) {
            System.out.println(sala.get(i));
        }
        return sl1;

    }

    public static Turma inserirTurmas() {

        Data dt1 = new Data(2013, 05, 04);
        Alunos at1 = new Alunos(9999999, "Académica de Arouca", dt1, "912345678", "a3@gmail");
        Turma t1 = new Turma("AAA");
        turma.add(t1);
        for (int i = 0; i < turma.size(); i++) {
            System.out.println(turma.get(i));
        }
        return t1;

    }
    public static Turma inserirHorarios() {

        Data dt1 = new Data(2013, 05, 04);
        Alunos at1 = new Alunos(9999999, "Académica de Arouca", dt1, "912345678", "a3@gmail");
        Turma t1 = new Turma("AAA");
        turma.add(t1);
        for (int i = 0; i < turma.size(); i++) {
            System.out.println(turma.get(i));
        }
        return t1;

    }

// Ler todos os dados    
    public static void lerDados() {
       lerAlunos();
//        inserirAlunos();
//        lerProfessores();
//        inserirProfessores();
//        lerSalas();
//        inserirSalas();
        lerTurmas();
        lerHorarios();
        inserirTurmas();
    }
}
