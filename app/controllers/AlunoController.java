package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class AlunoController extends GenericController {

    public static void listar() {
        List alunos = Aluno.find("order by nome asc").fetch();
        render(alunos);
    }
    
    public static void criar(String nome, String senha, String matricula, String email ) {
        Aluno aluno = new Aluno(nome, senha, matricula, email );
        aluno.save();
        String mensagem = "Aluno Criado Com Sucesso";
        render(mensagem);
    }
   	
   	public static void deletar(String matricula)
    {
    	List <Aluno> alunos = Aluno.find("matricula = ?", matricula).fetch();
    	for (Aluno a : alunos){
    		a.delete();
    	}
    	redirect("AlunoController.listar");
    }

}
