package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class QuestaoController extends GenericController {

    public static void listar() {
        List questaoes = Questao.find("order by nome asc").fetch();
        render(questaoes);
    }
    
    public static void criar(String codigo, String enunciado, String tipo, String referenciaBibliografica) {
        Questao questao = new Questao(codigo, enunciado, tipo, referenciaBibliografica);
        questao.save();
        String mensagem = "Questao Criado Com Sucesso";
        render(mensagem);
    }
    
    public static void deletar(String matricula)
    {
    	List <Questao> questaoes = Questao.find("matricula = ?", matricula).fetch();
    	for (Questao p : questaoes){
    		p.delete();
    	}
    	redirect("QuestaoController.listar");
    }

}
