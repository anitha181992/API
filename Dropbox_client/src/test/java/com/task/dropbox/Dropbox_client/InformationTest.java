package com.task.dropbox.Dropbox_client;

import java.io.IOException;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import com.dropbox.core.DbxException;

/**
 * 
 * @author Anitha
 *  Test case for Information.java
 */

public class InformationTest {

	@Test
	public void test() throws IOException, DbxException {

		PrintStream out = mock(PrintStream.class);
		System.setOut(out);
		Information info = new Information("O-zpHElDTMIAAAAAAAAAzxLzgcsHpKLCorPisuxh7DUq-F1mbNyGilyW_rMG6Beh");
		info.getDetails();

		verify(out).println(startsWith("UserID:"));
	}

}
