package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Professor extends Model {
 
    public String nome;
    public String matricula;
    public String senha;
    public String formacao;
    public String email;
    
    @ElementCollection
    public List <Disciplina> disciplinasLecionadas;
    
    public Professor(String nome, String senha, String matricula, String formacao, String email) {
        this.nome = nome;
        this.senha = senha;
        this.matricula = matricula;
        this.formacao = formacao;
        this.email = email;
    }
 
}
