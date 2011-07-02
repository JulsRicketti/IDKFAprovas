package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Prova extends Model {
 
 	@Id
    public String codigo;
    public Date data;
    public String horario;
    public Disciplina disciplina;
    public float valor;
    
    @ElementCollection
    public List <Questao> questoes;
    
    public Prova(String codigo, float valor, Date data, String horario) throws Exception {
        this.codigo = codigo;
        this.valor = valor;
        this.data = data;
        this.horario = horario;
    }
 
}
