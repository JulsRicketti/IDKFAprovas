package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class UsuarioController extends GenericController {

    public static void listar() {
        List usuarios = Usuario.find("order by nome asc").fetch();
        render(usuarios);
    }
    
    public static void criar(String nome, String senha) {
        Usuario usuario = new Usuario(nome, senha);
        usuario.save();
        String mensagem = "Usuário Criado Com Sucesso";
        render(mensagem);
    }

}
