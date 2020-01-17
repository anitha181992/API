package com.task.dropbox.Dropbox_client;

import static org.mockito.Matchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.dropbox.core.DbxException;

/**
 * 
 * @author Anitha 
 * Test case for ListFiles.java
 */

public class ListFilesTest {

	@Test
	public void testGetDetails() throws IOException, DbxException {
		PrintStream out = mock(PrintStream.class);
		System.setOut(out);
		String param1 = "O-zpHElDTMIAAAAAAAAAzxLzgcsHpKLCorPisuxh7DUq-F1mbNyGilyW_rMG6Beh";
		String param2 = "Test.txt";
		ListFiles list = new ListFiles(param1, param2);
		list.getDetails();

		verify(out).println(startsWith("File"));
	}

}
