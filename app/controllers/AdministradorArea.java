package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class AdministradorArea extends GenericController {


	@Before
	public static void isAdmin ()
	{
		String logado = session.get("logado");
		if (logado == null || !logado.equals("admin")) {
			redirect("/LoginController/login");
		}
	}
	

}
