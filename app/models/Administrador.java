package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Administrador extends Model {
 
    public String nome;
    public String codigo;
    public String senha;
    
    public Administrador(String nome, String senha, String codigo) {
        this.nome = nome;
        this.senha = senha;
        this.codigo = codigo;
    }
 
}
