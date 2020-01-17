package com.task.dropbox.Dropbox_client;

import java.io.IOException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

/**
 * 
 * @author Anitha
 * @method getDetails()
 * @input AccessToken for Dropbox API
 * @Output Details of the account
 */

public class Information extends Appauthorize {
	private String accessToken;

	Information(String token) {
		accessToken = token;
	}

	@Override
	public void getDetails() throws IOException, DbxException {

		DbxRequestConfig config = new DbxRequestConfig("dropbox/test-access1992");
		DbxClientV2 client = new DbxClientV2(config, accessToken);

		FullAccount account = client.users().getCurrentAccount();
		System.out.println("UserID:" + account.getAccountId());
		System.out.println("Display name:" + account.getName().getDisplayName());
		System.out.println("Name:" + account.getName());
		System.out.println("Email:" + account.getEmail() + "Verified");
		System.out.println("Country:" + account.getCountry());
		System.out.println("Referrel Link:" + account.getReferralLink());

	}
}
