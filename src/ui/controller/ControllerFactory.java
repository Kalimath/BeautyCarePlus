package ui.controller;

import domain.model.DatabaseService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, DatabaseService model) {
        return createHandler(key, model);
    }
    
	private RequestHandler createHandler(String handlerName, DatabaseService model) {
		RequestHandler handler = null;
		try {
			Class<?> handlerClass = Class.forName("ui.controller."+ handlerName);
			Object handlerObject = handlerClass.getConstructor().newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model);
		} catch (Exception e) {
			throw new RuntimeException("pagina bestaat niet");
		}
		return handler;
	}


}
