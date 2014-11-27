package Logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import Logic.AuthUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerManager {

	public static String Login(String username, String password) throws Exception{
		
		Gson gson = new GsonBuilder().create();
		AuthUser authUser = new AuthUser();
		
		// Krypter password før det sendes over netværk.
		String encryptedPassword = encryptionAES.encrypt(password);	
		
		authUser.setAuthUserPassword(encryptedPassword);
		authUser.setAuthUserEmail(username);

		String gsonString = gson.toJson(authUser);
		String result = GetJsonFromServer(gsonString);
		return result;
	}
	
	
	
	private static String GetJsonFromServer(String jsonInput){
	
		String result = "Error";
		try {
			Socket clientSocket = new Socket("localhost", 8888);
			DataOutputStream outToServer = new DataOutputStream(
					clientSocket.getOutputStream());
			byte[] input = jsonInput.getBytes();
			byte key = (byte) 3.1470;
			byte[] encrypted = input;
			for (int i = 0; i < encrypted.length; i++)
				encrypted[i] = (byte) (encrypted[i] ^ key);

			System.out.println(encrypted);
			outToServer.write(encrypted);
			outToServer.flush();
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			result = inFromServer.readLine();
			clientSocket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}	
}