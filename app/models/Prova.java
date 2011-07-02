package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Prova extends Model {
 
 	@Id
    public String codigo;
    public float nota;
    public String nomeUsuario;
    
    @ElementCollection
    public List <Questao> questoes;
    
    public Prova(String codigo, float nota, String nomeUsuario) throws Exception {
        this.nomeUsuario = nomeUsuario;
        this.nota = nota;
        this.codigo = codigo;
    }
 
}
