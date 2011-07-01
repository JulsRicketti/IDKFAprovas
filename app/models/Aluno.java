package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Aluno extends Model {
 
    public String nome;
    public String matricula;
    public String senha;
    public String email;
    
    public Aluno(String nome, String senha, String matricula, String email) {
        this.nome = nome;
        this.senha = senha;
        this.matricula = matricula;
        this.email = email;
    }
 
}
