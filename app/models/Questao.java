package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Questao extends Model {
 
 	public String codigo;
    public String tipo;
    public String enunciado;
    public String referenciaBibliografica;
    
    @ElementCollection
    public List <String> alternativas;
    
    public Professor autor;
    public Disciplina disciplina;
    
    public Questao(String codigo, String enunciado, String tipo, String referenciaBibliografica) {
        this.codigo = codigo;
        this.enunciado = enunciado;
        this.tipo = tipo;
        this.referenciaBibliografica = referenciaBibliografica;
    }
 
}
