package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AdministradorArea.class)
public class TurmaController extends GenericController {

    public static void listar() {
        List turmas = Turma.find("").fetch();
        List professores = Professor.find("").fetch();
        List disciplinas = Disciplina.find("").fetch(); 
        render(turmas, professores, disciplinas);
    }
    
    public static void criar(String codigo, String matriculaProfessor, String codigoDisciplina) {
    	Disciplina disciplina = Disciplina.find("codigo = ?", codigoDisciplina).first();
    	Professor professor = Professor.find("matricula = ?", matriculaProfessor).first();
    	Turma turma = new Turma(codigo, professor, disciplina);
    	turma.save();
        String mensagem = "Turma Criada Com Sucesso";
        render(mensagem);
    }
   	
   	public static void deletar(String codigo)
    {
    	List <Turma> turmas = Turma.find("codigo = ?", codigo).fetch();
    	for (Turma t : turmas){
    		t.delete();
    	}
    	redirect("TurmaController.listar");
    }
    
    public static void editarAlunos(String codigo){
		Turma turma = Turma.find("codigo = ?", codigo).first();
		List<Aluno> todosAlunos = Aluno.all().fetch();
		renderArgs.put("alunos", turma.alunos);
		renderArgs.put("codigoTurma", turma.codigo);
		render(todosAlunos);
	}
	
	public static void adicionarAluno(String codigoTurma, String matriculaAluno )
	{
		Turma turma = Turma.find("codigo = ?", codigoTurma).first();
		Aluno aluno = Aluno.find("matricula = ?", matriculaAluno).first();
		turma.alunos.add(aluno);
		turma.save();
		redirect("TurmaController.editarAlunos", codigoTurma);		
	}
	
	public static void removerAluno(String codigoTurma, String matriculaAluno)
	{		
		Turma turma = Turma.find("codigo = ?", codigoTurma).first();
		Aluno aluno = Aluno.find("matricula = ?", matriculaAluno).first();
		turma.alunos.remove(aluno);
		turma.save();
		redirect("TurmaController.editarAlunos", codigoTurma);			
	}

}
