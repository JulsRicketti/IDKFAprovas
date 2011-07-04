package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import javax.persistence.*;
import models.*;

@With(ProfessorArea.class)
public class QuestaoController extends GenericController {

    public static void listar() {
        List questoes = Questao.find("order by codigo asc").fetch();
        render(questoes);
    }
    
    public static void criar(String codigo, String enunciado, String tipo, String referenciaBibliografica, String multiplaEscolhaAlternativas, String verdadeiroOuFalsoAfirmacoes, String completacao, String associacaoA, String associacaoB) {
        Questao questao = new Questao(codigo, enunciado, tipo, referenciaBibliografica);
        
        if(tipo.equals("aberta")){

        } else if(tipo.equals("multiplaEscolha")){
        	questao.alternativas = Arrays.asList(multiplaEscolhaAlternativas.split("\n"));

        } else if(tipo.equals("verdadeiroOuFalso")){
        	questao.afirmacoes = Arrays.asList(verdadeiroOuFalsoAfirmacoes.split("\n"));        	
        } else if(tipo.equals("completacao")){
        	questao.completacao = completacao;
        } else if(tipo.equals("associacao")){
        	questao.associacaoA = Arrays.asList(associacaoA.split("\n"));
        	questao.associacaoB = Arrays.asList(associacaoB.split("\n"));
        }
        questao.save();
	    String mensagem = "Questao Criada Com Sucesso";
	    render(mensagem);
    }

    public static void deletar(String codigo) {
    	try {
			List <Questao> questoes = Questao.find("codigo = ?", codigo).fetch();

			for (Questao q : questoes) {
				q.delete();
			}
			redirect("QuestaoController.listar");
    	} catch (PersistenceException p) {
    		String mensagem = "Não foi possível deletar a questão, pois ela está sendo usada em uma prova existente.";
    		render(mensagem);
    	}
    }


}
