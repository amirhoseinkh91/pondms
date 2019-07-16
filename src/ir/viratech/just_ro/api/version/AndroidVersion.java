package ir.viratech.just_ro.api.version;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.just_ro.model.errors.http.Error;
import ir.viratech.just_ro.model.version.Version;

@Path("/version")
public class AndroidVersion {

	private static final String VERSION_FILE_PATH = "Version-File";
	
	@GET
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/last")
	public Response androidVersion() {
		readFromFile();
		return Response.status(Error.OK_CODE).entity(readFromFile()).build();
	}

	@POST
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/last")
	public Response androidVersionBody(String jsonString) {
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			boolean isCritical = jsonObject.getBoolean("isCritical");
			String androidVersion = jsonObject.getString("androidVersion");
			String serverVersion = jsonObject.getString("serverVersion");
			writeToFile(isCritical, androidVersion, serverVersion);
			return Response.status(Error.OK_CODE).build();
		} catch (JSONException e) {
			e.printStackTrace();
			return Response.status(Error.Bad_Request_CODE).build();
		}
	}

	private void writeToFile(boolean isCritical, String androidVersion, String serverVersion) {
		File file = new File(ApplicationContextUtil.getProperty("versionFile"));
		try {
			FileWriter writer = new FileWriter(file);
			writer.append("{" + "\n");
			writer.append("\tandroidVersion : " + androidVersion + "," + "\n");
			writer.append("\tserverVersion : " + serverVersion + "," + "\n");
			writer.append("\tisCritical : " + isCritical + "\n");
			writer.append("}");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Version readFromFile() {
		try {
			Version version = new Version();
			File file = new File(ApplicationContextUtil.getProperty(VERSION_FILE_PATH));
			Scanner scanner = new Scanner(file);

			StringBuilder builder = new StringBuilder();
			while (scanner.hasNextLine()) {
				builder.append(scanner.nextLine());
			}
			JSONObject jsonObject = new JSONObject(builder.toString());
			version.setAndroidVersion(jsonObject.getString("androidVersion"));
			version.setServerVersion(jsonObject.getString("serverVersion"));
			version.setIsCritical(jsonObject.getBoolean("isCritical"));
			scanner.close();
			return version;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

}
