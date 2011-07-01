package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class AdministradorController extends GenericController {

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
