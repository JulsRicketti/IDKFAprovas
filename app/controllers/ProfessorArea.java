package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class ProfessorArea extends GenericController {


	@Before
	public static void isProfessor ()
	{
		String logado = session.get("logado");
		if (logado == null || !logado.equals("professor")) {
			redirect("LoginController.login");
		}
	}
	

}
