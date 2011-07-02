package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Prova extends Model {
 
    public String codigo;
    public float nota;
    public String nomeUsuario;
    
    public Prova(String codigo, float nota, String nomeUsuario) throws Exception {
        this.nomeUsuario = nomeUsuario;
        this.nota = nota;
        this.codigo = codigo;
    }
 
}
