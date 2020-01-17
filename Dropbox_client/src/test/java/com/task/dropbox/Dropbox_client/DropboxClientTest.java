package com.task.dropbox.Dropbox_client;

import junit.framework.TestCase;

/**
 * 
 * @author Anitha
 * Test case for DropboxClient.java
 */


public class DropboxClientTest extends TestCase {

	public void testVerify() {
		int length = 3;
		String command = "auth";
		assertEquals(true, DropboxClient.verify(length, command));
	}

	public void testVerify1() {
		int length = 2;
		String command = "auth";
		assertEquals(false, DropboxClient.verify(length, command));
	}

	public void testVerify2() {
		int length = 2;
		String command = "info";
		assertEquals(true, DropboxClient.verify(length, command));
	}

}
