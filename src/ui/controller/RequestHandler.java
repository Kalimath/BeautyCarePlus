package ui.controller;

import domain.model.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class RequestHandler {
	
	private DatabaseService databaseService;
	
	public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void setModel (DatabaseService service) {
		this.databaseService = service;
	}

	public DatabaseService getDatabaseService() {
		return databaseService;
	}
	
	
}
