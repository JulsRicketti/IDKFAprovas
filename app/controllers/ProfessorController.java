package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class ProfessorController extends GenericController {

    public static void listar() {
        List professores = Professor.find("order by nome asc").fetch();
        render(professores);
    }
    
    public static void criar(String nome, String senha, String matricula, String formacao, String email ) {
        Professor professor = new Professor(nome, senha, matricula, formacao, email );
        professor.save();
        String mensagem = "Professor Criado Com Sucesso";
        render(mensagem);
    }
    
    public static void deletar(String matricula)
    {
    	List <Professor> professores = Professor.find("matricula = ?", matricula).fetch();
    	for (Professor p : professores){
    		p.delete();
    	}
    	redirect("ProfessorController.listar");
    }

}
