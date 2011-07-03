package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(ProfessorArea.class)
public class QuestaoController extends GenericController {

    public static void listar() {
        List questoes = Questao.find("order by codigo asc").fetch();
        render(questoes);
    }
    
    public static void criar(String codigo, String enunciado, String tipo, String referenciaBibliografica) {
        Questao questao = new Questao(codigo, enunciado, tipo, referenciaBibliografica);
        questao.save();
        if(tipo.equals("aberta")){
		    String mensagem = "Questao Criada Com Sucesso";
		    render(mensagem);
        } else if(tipo.equals("multiplaEscolha")){
        	redirect("QuestaoController.escreverAlternativas");
        } else if(tipo.equals("verdadeiroOuFalso")){
        	redirect("QuestaoController.vOuF");
        } else if(tipo.equals("completacao")){
        	redirect("QuestaoController.completacao");
        } else if(tipo.equals("associacao")){
        	redirect("QuestaoController.fazerAssociacoes");
        }
    }
    
    public static void vOuF(){
    	render();
    }
    
    public static void completacao(){
    	render();
    }
    
    public static void fazerAssociacoes(){
		render();
	}
    
    public static void escreverAlternativas(){
    	render();
    }
    
    public static void deletar(String codigo){
    	List <Questao> questoes = Questao.find("codigo = ?", codigo).fetch();
    	for (Questao q : questoes){
    		q.delete();
    	}
    	redirect("QuestaoController.listar");
    }


}
