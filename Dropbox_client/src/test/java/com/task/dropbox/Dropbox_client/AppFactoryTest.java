package com.task.dropbox.Dropbox_client;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Anitha Test case for AppFactory
 */

public class AppFactoryTest {

	@Test
	public void testExecute() {

		String inputCommand = "auth";
		String param1 = "swmswbpmiqltsn8";
		String param2 = "gc0m5gt4rkindhf";
		Authorization authorization = new Authorization(param1, param2);

		AppFactory app = new AppFactory();
		Appauthorize app1 = app.execute(inputCommand, param1, param2);
		Appauthorize app2 = authorization;
		assertEquals(app1.getClass(), app2.getClass());

	}

	@Test
	public void testExecute1() {

		String inputCommand = "info";
		String param1 = "O-zpHElDTMIAAAAAAAAAzxLzgcsHpKLCorPisuxh7DUq-F1mbNyGilyW_rMG6Beh";
		String param2 = "";
		Information info = new Information(param1);

		AppFactory app = new AppFactory();
		Appauthorize app1 = app.execute(inputCommand, param1, param2);
		Appauthorize app2 = info;
		assertEquals(app1.getClass(), app2.getClass());

	}

	@Test
	public void testExecute2() {

		String inputCommand = "list";
		String param1 = "O-zpHElDTMIAAAAAAAAAzxLzgcsHpKLCorPisuxh7DUq-F1mbNyGilyW_rMG6Beh";
		String param2 = "/documents";
		ListFiles list = new ListFiles(param1, param2);

		AppFactory app = new AppFactory();
		Appauthorize app1 = app.execute(inputCommand, param1, param2);
		Appauthorize app2 = list;
		assertEquals(app1.getClass(), app2.getClass());

	}

}
