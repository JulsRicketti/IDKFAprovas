package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Disciplina extends Model {
 
    public String nome;
    public String codigo;
    public int cargaHoraria;
    public String tipo;
    public String ementa;
    
    public Disciplina(String nome, String codigo, int cargaHoraria, String tipo, String ementa) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.ementa = ementa;
        
    }
 
}
