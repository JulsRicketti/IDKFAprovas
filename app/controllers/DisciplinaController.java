package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class DisciplinaController extends GenericController {

    public static void listar() {
        List disciplinas = Disciplina.find("order by nome asc").fetch();
        render(disciplinas);
    }
    
    public static void criar(String nome, String codigo, int cargaHoraria, String tipo, String ementa) {
        Disciplina disciplina = new Disciplina(nome, codigo, cargaHoraria,  tipo, ementa);
        disciplina.save();
        String mensagem = "Disciplina Criada Com Sucesso";
        render(mensagem);
    }
   	
   	public static void deletar(String codigo)
    {
    	List <Disciplina> disciplinas = Disciplina.find("codigo = ?", codigo).fetch();
    	for (Disciplina d : disciplinas){
    		d.delete();
    	}
    	redirect("DisciplinaController.listar");
    }

}
