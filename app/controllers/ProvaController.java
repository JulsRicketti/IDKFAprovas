package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class ProvaController extends GenericController {

    public static void listar() {
        List provas = Prova.find("").fetch();
        render(provas);
    }
    
    public static void criar(String codigo, float valor, Date data, String horario){
    
		 try
		 {
		 	Prova prova = new Prova(codigo, valor, data, horario);
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
