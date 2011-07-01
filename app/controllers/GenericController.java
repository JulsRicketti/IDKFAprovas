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
		
		if (!(logado == null || logado.equals(""))) {
			renderArgs.put("logado", true);
		}
	}
	
}
