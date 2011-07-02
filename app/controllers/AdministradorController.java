package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class AdministradorController extends GenericController {

    public static void listar() {
        List administradores = Administrador.find("order by nome asc").fetch();
        render(administradores);
    }
    
    public static void criar(String nome, String senha, String codigo ) {
        Administrador administrador = new Administrador(nome, senha, codigo);
        administrador.save();
        String mensagem = "Administrador Criado Com Sucesso";
        render(mensagem);
    }

   	public static void deletar(String codigo)
    {
    	List <Administrador> administradores = Administrador.find("codigo = ?", codigo).fetch();
    	for (Administrador a : administradores){
    		a.delete();
    	}
    	redirect("AdministradorController.listar");
    }

}
