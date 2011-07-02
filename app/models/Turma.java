package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Turma extends Model {
 
    public String codigo;
    
    public Professor professor;
    public Disciplina disciplina;
    
    public Turma(String codigo) {
    	this.codigo = codigo;
    }
 
}
