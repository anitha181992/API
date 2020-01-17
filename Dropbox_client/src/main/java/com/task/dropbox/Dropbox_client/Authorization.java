package com.task.dropbox.Dropbox_client;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuth;

/**
 * 
 * @author Anitha class name: Authorization
 * @input : appKey, appSecret
 * @output: Access token for dropbox account
 */

public class Authorization extends Appauthorize {
	private String appKey;
	private String appSecret;

	Authorization(String key, String secret) {
		appKey = key;
		appSecret = secret;
	}

	@Override
	public void getDetails() throws IOException {

		DbxAppInfo appInfo = new DbxAppInfo(appKey, appSecret);
		DbxRequestConfig requestConfig = new DbxRequestConfig("Dropbox-client");
		DbxWebAuth webAuth = new DbxWebAuth(requestConfig, appInfo);
		DbxWebAuth.Request webAuthRequest = DbxWebAuth.newRequestBuilder().withNoRedirect().build();

		String authorizeUrl = webAuth.authorize(webAuthRequest);
		System.out.println("1. Go to " + authorizeUrl);
		System.out.println("2. Click \"Allow\" (you might have to log in first).");
		System.out.print("3. Copy the authorization code and paste it here:");

		String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
		if (code == null) {
			System.exit(1);
			return;
		}
		code = code.trim();

		DbxAuthFinish authFinish;
		try {
			authFinish = webAuth.finishFromCode(code);
		} catch (DbxException ex) {
			System.out.println("Error in DbxWebAuth.authorize: " );
			System.exit(1);
			return;
		}

		System.out.println("Your access token: " + authFinish.getAccessToken());

	}
}
