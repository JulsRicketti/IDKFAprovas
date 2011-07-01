package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class AlunoArea extends GenericController {


	@Before
	public static void isAluno ()
	{
		String logado = session.get("logado");
		if (logado == null || !logado.equals("aluno")) {
			redirect("/LoginController/login");
		}
	}
	

}
