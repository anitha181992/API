package com.task.dropbox.Dropbox_client;

import java.io.IOException;
import java.util.ArrayList;

import com.dropbox.core.DbxException;

/**
 * Main method accepts command-line arguments
 *
 */
public class DropboxClient {

	public static void main(String args[]) throws DbxException, IOException {

		if(args.length == 0) {
			System.out.println("Please enter commands <auth>/<info>/<list> with arguments");
			System.exit(1);
			return;
		}
		String inputCommand = args[0];
		if (verify(args.length, inputCommand)) {
			String param1 = args[1];
			String param2 = (args.length == 2) ? "" : args[2];
			AppFactory factory = new AppFactory();
			Appauthorize app = factory.execute(inputCommand, param1, param2);
			app.getDetails();
		}
		System.exit(1);
		return;
	}

//method to verify command-line arguments
	public static boolean verify(int length, String command) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("auth");
		list.add("info");
		list.add("list");

		if (list.contains(command) && !command.isEmpty()) {
			if (length != 3 && !command.equals("info")) {
				System.out.println("Usage: <command> <param1> <param2>");
				return false;
			} else if (!(length == 2 || length == 3) && command.equals("info")) {
				System.out.println("Usage: <command> <param1> <param2(opt)>");
				return false;
			}
			return true;
		} else {
			System.out.println("Invalid command: Please verify");
			return false;
		}
	}
}
