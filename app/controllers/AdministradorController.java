package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class AdministradorController extends Controller {

    public static void listar() {
        List administrador = Administrador.find("order by nome asc").fetch();
        render(administrador);
    }
    
    public static void criar(String nome, String senha, String codigo ) {
        Administrador administrador = new Administrador(nome, senha, codigo);
        administrador.save();
        String mensagem = "Administrador Criado Com Sucesso";
        render(mensagem);
    }
    
    public static void cadastrarAluno()
    {
    }
    
    public static void cadastrarProfessor()
    {
    }

}