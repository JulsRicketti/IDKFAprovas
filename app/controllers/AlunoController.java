package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class AlunoController extends Controller {

    public static void listar() {
        List aluno = Aluno.find("order by nome asc").fetch();
        render(aluno);
    }
    
    public static void criar(String nome, String senha, String matricula, String email ) {
        Aluno aluno = new Aluno(nome, senha, matricula, email );
        aluno.save();
        String mensagem = "Aluno Criado Com Sucesso";
        render(mensagem);
    }

}
