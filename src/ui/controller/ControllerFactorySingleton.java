package ui.controller;

import domain.model.DatabaseService;

public class ControllerFactorySingleton {
	private static ControllerFactorySingleton uniqueInstance;

	private ControllerFactorySingleton(){}
	
    public static ControllerFactorySingleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ControllerFactorySingleton ();
		}
		return uniqueInstance;
    }
    
	public RequestHandler getController(String handlerName, DatabaseService model) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("ui.controller."+ handlerName);
			Object handlerObject = handlerClass.getConstructor().newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model);
		} catch (Exception e) {
			System.out.println("Handler \""+handlerName+"\" bestaat niet");
			throw new IllegalArgumentException("Handler \""+handlerName+"\" bestaat niet");
		}
		return handler;
	}


}

