package com.task.dropbox.Dropbox_client;

/**
 * 
 * @author Anitha Factory method to create subclasses based on command
 *
 */

public class AppFactory {

	public Appauthorize execute(String command, String param1, String param2) {
		if (command.equals("auth")) {
			return new Authorization(param1, param2);
		} else if (command.equals("info")) {
			return new Information(param1);
		} else if (command.equals("list")) {
			return new ListFiles(param1, param2);
		}
		return null;
	}

}
