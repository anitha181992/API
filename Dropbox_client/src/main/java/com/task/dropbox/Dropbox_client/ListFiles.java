package com.task.dropbox.Dropbox_client;

import java.io.IOException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

/**
 * 
 * @author Anitha
 * @method getDetails()
 * @input acesstoken and path of the folder/name of the file
 * @output: metadata of the files within the folder
 */

public class ListFiles extends Appauthorize {

	private String accessToken;
	private String path;

	ListFiles(String token, String pathFile) {
		accessToken = token;
		path = pathFile;
	}

	@Override
	public void getDetails() throws IOException, DbxException {

		DbxRequestConfig config = new DbxRequestConfig("dropbox/test-access1992");
		DbxClientV2 client = new DbxClientV2(config, accessToken);

		if (path.contains("/")) {
			ListFolderResult result = client.files().listFolder(path);
			while (true) {
				for (Metadata metadata : result.getEntries()) {
					System.out.println("Directoryname " + path + "\n" + metadata.toString());
				}
				if (!result.getHasMore()) {
					break;
				}
				result = client.files().listFolderContinue(result.getCursor());
			}
		} else {
			ListFolderResult result = client.files().listFolder("");
			for (Metadata metadata : result.getEntries()) {
				if (metadata.getName().equals(path)) {
					System.out.println("File info"+metadata.toString());
				}
			}
		}
		System.out.println("Enter a valid file or directory name");
	}
}
