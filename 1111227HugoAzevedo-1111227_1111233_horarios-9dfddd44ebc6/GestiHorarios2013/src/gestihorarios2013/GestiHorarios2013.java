/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestihorarios2013;

import GestiHorarios.Alunos;
import GestiHorarios.GerirHorarios;
import GestiHorarios.Professor;
import GestiHorarios.Sala;
import java.util.ArrayList;

/**
 *
 * @author Hugo Azevedo
 */
public class GestiHorarios2013 {

    // Declarar arrays necessarios 
    private static ArrayList<Alunos> alunos = new ArrayList();
    private static ArrayList<Professor> professor = new ArrayList();
    private static ArrayList<Sala> sala = new ArrayList();

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
    

    //Aceder aos arrays para escrita
    public static void setAlunos(ArrayList<Alunos> aAlunos) {
        alunos = aAlunos;
    }

    public static void setProfessor(ArrayList<Professor> aProfessor) {
        professor = aProfessor;

    }
    
    public static void setSala(ArrayList<Sala> aSala) {
        sala = aSala;
    }

    //Imprimir arrays
    public static void main(String[] args) {

        GerirHorarios.lerDados();


    }
}
