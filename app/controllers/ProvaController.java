package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(ProfessorArea.class)
public class ProvaController extends GenericController {

    public static void listar() {
        List provas = Prova.all().fetch();
        List turmas = Turma.all().fetch();
        render(provas, turmas);
    }
    
    public static void criar(int codigo, float valor, Date data, String horario, String codigoTurma){
    
		 try
		 {
		 	Turma turma = Turma.find("codigo = ?", codigoTurma).first();
		 	Prova prova = new Prova(codigo, valor, data, horario, turma);
		 	prova.save();
		 	String mensagem = "Prova Criada Com Sucesso";
		   render(mensagem);
		  }
		  catch(Exception e)
		  {
			String mensagem = "Erro ao criar prova: " + e.getMessage();
		   render(mensagem);
		  	
		  }
	}
	
	public static void editarQuestoes(int codigo){
		List<Prova> provas = Prova.find("codigo = ?", codigo).fetch();
		List<Questao> todasQuestoes = Questao.find("").fetch();
		Prova prova = provas.get(0);
		renderArgs.put("questoes", prova.questoes);
		renderArgs.put("codigoProva", prova.codigo);
		render(todasQuestoes);
	}
	
	public static void adicionarQuestao(String codigoQuestao, int codigoProva )
	{
		List<Prova> provas = Prova.find("codigo = ?", codigoProva).fetch();
		List<Questao> questoes = Questao.find("codigo = ?", codigoQuestao).fetch();
		
		Prova prova = provas.get(0);
		Questao questao = questoes.get(0);
		
		prova.questoes.add(questao);
		prova.save();
		redirect("ProvaController.editarQuestoes", codigoProva);		
	}
	
	public static void removerQuestao(String codigoQuestao, int codigoProva)
	{
		List<Prova> provas = Prova.find("codigo = ?", codigoProva).fetch();
		List<Questao> questoes = Questao.find("codigo = ?", codigoQuestao).fetch();
		Prova prova = provas.get(0);
		Questao questao = questoes.get(0);
		
		prova.questoes.remove(questao);
		prova.save();
		redirect("ProvaController.editarQuestoes", codigoProva);		
		
	}
    
    public static void deletar(int codigo){
    	Prova prova = Prova.find("codigo = ?", codigo).first();
    	prova.delete();
    	redirect("ProvaController.listar");
    }

}
