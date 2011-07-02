package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class LoginController extends GenericController {

	public static void login()
	{
		render();
	}
	
	public static void logout()
	{
		renderArgs.put("logado", false);
		renderArgs.put("aluno", false);
		renderArgs.put("administrador", false);
		renderArgs.put("professor", false);		
		session.put("logado", "");
		render();
	}
	
	public static void doLogin(String codigo, String senha, String tipo)
	{
		if (tipo.equals("aluno")) {
			List <Aluno> alunos = Aluno.find("matricula = ? and senha = ?", codigo, senha).fetch();
			if (alunos.size() == 1)
			{
				session.put("logado", "aluno");
				redirect("Application.index");
			} else {
				renderArgs.put("mensagem", "Senha ou usuario incorretos");
				render();
			}
			
		} else if (tipo.equals("professor")) {
			List <Professor> professores = Professor.find("matricula = ? and senha = ?", codigo, senha).fetch();
			if (professores.size() == 1)
			{
				session.put("logado", "professor");
				redirect("Application.index");
			} else {
				renderArgs.put("mensagem", "Senha ou usuario incorretos");
				render();
			}
		
		} else if (tipo.equals("administrador")) {
			List <Administrador> administradores = Administrador.find("codigo = ? and senha = ?", codigo, senha).fetch();
			if (administradores.size() == 1 || (codigo.equals("admin") && senha.equals("1234")))
			{
				session.put("logado", "administrador");
				redirect("Application.index");
			} else {
				renderArgs.put("mensagem", "Senha ou usuario incorretos");
				render();
			}
		
		}
	}
}
