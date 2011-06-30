package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class ProvaController extends Controller {

    public static void listar() {
        List provas = Prova.find("").fetch();
        render(provas);
    }
    
    public static void criar(String nomeUsuario, float nota, String codigo){
    
		 try
		 {
		 	Prova prova = new Prova(codigo, nota, nomeUsuario);
		 	prova.save();
		 	String mensagem = "Prova Criada Com Sucesso";
		   render(mensagem);
		  }
		  catch(Exception e)
		  {
			String mensagem = "Erro ao criar prova";
		   render(mensagem);
		  	
		  }
	}
    

}
