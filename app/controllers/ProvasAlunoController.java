package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(AlunoArea.class)
public class ProvasAlunoController extends GenericController {
	public static void listar() {
		List<Prova> provas = Prova.all().fetch();
		List<Turma> turmas = Turma.all().fetch();
		Aluno aluno = Aluno.find("matricula = ?", session.get("matricula")).first();
		Set<Turma> turmasDoAluno = new HashSet();
		List<Prova> provasDoAluno = new ArrayList(); 
		for (Turma t : turmas) {
			if (t.alunos.contains(aluno)) {
				turmasDoAluno.add(t);
			}
		}
		for (Prova p : provas) {
			if (turmasDoAluno.contains(p.turma)) {
				provasDoAluno.add(p);
			}
		}
		Collections.sort(provasDoAluno, new Comparator() {
			public int compare(Object p1, Object p2) {
				return ((Prova)p1).data.compareTo(((Prova)p2).data);
			}
		});
		render(provasDoAluno);
	}
}
