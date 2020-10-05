/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatecpg.poo.p1;

import java.util.ArrayList;

/**
 *
 * @author Vinic
 */
public class Disciplina {
    
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;
    
    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmenta(){
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
    
    public int getCiclo(){
        return ciclo;
    }
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    
    public double getNota(){
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public static ArrayList getList() {
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        
        disciplinas.add(new Disciplina("Banco de Dados", "..", 4));
        disciplinas.add(new Disciplina("Engenharia de Software III", "..", 4));
        disciplinas.add(new Disciplina("Programação Orientada a Objetos", "..", 4));
        disciplinas.add(new Disciplina("Linguagem de Programação IV", "..", 4));
        disciplinas.add(new Disciplina("Segurança da Informação", "..", 4));
        disciplinas.add(new Disciplina("Sistemas Operacionais II", "..", 4));
        disciplinas.add(new Disciplina("Metodologia da Pesquisa Científico-Tecnológica", "..", 4));
        
        return disciplinas;
    };
    
}
