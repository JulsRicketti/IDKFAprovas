package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Turma extends Model {
 
    public String codigo;
    
	@ManyToMany(cascade=CascadeType.PERSIST)
    public List <Aluno> alunos;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    public Professor professor;
    @ManyToOne(cascade=CascadeType.PERSIST)
    public Disciplina disciplina;
    
    public Turma(String codigo, Professor professor, Disciplina disciplina) {
    	this.codigo = codigo;
    	this.professor = professor;
    	this.disciplina = disciplina;
    }
 
}
