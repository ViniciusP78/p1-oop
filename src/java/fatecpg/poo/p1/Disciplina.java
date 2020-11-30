/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatecpg.poo.p1;

import java.sql.*;
import java.util.ArrayList;
import fatecpg.poo.p1.DBListener;

/**
 *
 * @author Vinic
 */
public class Disciplina {
    
    private long rowId;
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;
    
    public static ArrayList<Disciplina> getList(){
        ArrayList<Disciplina> list = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            con = DBListener.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT rowid, * FROM disciplina");
            while(rs.next()){
                list.add(new Disciplina(
                        rs.getLong("rowid"),
                        rs.getString("nome"),
                        rs.getString("ementa"),
                        rs.getInt("ciclo"),
                        rs.getDouble("nota")
                ));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }
    
    public static void insert(String nome, String ementa, int ciclo, Double nota) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBListener.getConnection();
            stmt = con.prepareStatement("INSERT INTO disciplina VALUES(?,?,?,?");
            stmt.setString(1, nome);
            stmt.setString(2, ementa);
            stmt.setInt(3, ciclo);
            stmt.setDouble(4, nota);
            stmt.execute();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void delete(long rowid) {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try{
            con = DBListener.getConnection();
            stmt = con.prepareStatement("DELETE FROM disciplina WHERE rowid=?");
            stmt.setLong(1,rowid);
            stmt.execute();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    
    public Disciplina(long rowid, String nome, String ementa, int ciclo, double nota) {
        this.rowId = rowid;
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
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
    
    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }
    
    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplina("
                + "nome VARCHAR(50) UNIQUE NOT NULL,"
                + "ementa VARCHAR(255) UNIQUE NOT NULL,"
                + "ciclo INT NOT NULL,"
                + "nota DOUBLE NOT NULL"
                + ")";
    }
    
}
