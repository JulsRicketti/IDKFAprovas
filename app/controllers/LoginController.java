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
	
	public static void doLogin(String nomeUsuario, String senha)
	{
		if(nomeUsuario.equals("admin") && senha.equals("1234"))
		{
			session.put("logado", "administrador");
			redirect("/");
		} else {
			renderArgs.put("mensagem", "Senha ou usuario incorretos");
			render();
		}
	}
}
