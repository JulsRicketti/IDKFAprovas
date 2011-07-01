package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;


public class GenericController extends Controller {
	
	@Before
	public static void isLogged ()
	{
		String logado =session.get("logado");
		
		if (logado != null) {
			if (!logado.equals("")) {
				renderArgs.put("logado", true);
			}
			
			if(logado.equals("administrador")){
				renderArgs.put("administrador", true);
			} else if(logado.equals("professor")) {
				renderArgs.put("professor", true);	
			} else if(logado.equals("aluno")) {
				renderArgs.put("aluno", true);	
			}
		}
	}
	
}
