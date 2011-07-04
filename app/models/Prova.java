package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Prova extends Model {
 	
    public int codigo;
    public Date data;
    public String horario;
    @ManyToOne(cascade=CascadeType.PERSIST)
    public Turma turma;
    public float valor;
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    public Set <Questao> questoes;
    
    public Prova(int codigo, float valor, Date data, String horario, Turma turma) throws Exception {
        this.codigo = codigo;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
        this.questoes = new HashSet <Questao>();
        this.turma = turma;
    }
 
}
