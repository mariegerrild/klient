package Logic;
import shared.*;

public class Client {
public static void main (String[] args){
	
	Scanner input = new Scanner(System.in);
	UserAuth UserObj = new UserAuth();
	
	System.out.println("Client running");
	boolean userAuthenticated = false;
	System.out.println("Please login");
	
	while(!userAuthenticated){
		System.out.println("User Email");
		userObj.setAuthUserEmail(input.next());
		System.out.println("User password:");
		UserObj.setAuthUserPassword(input.next());
	
		objTrans.sendObject(userObj);
		userObj = objTrans.recieveUserAuth();
		
		if(userObj.isAuthenicated()==true){
			userAuthenticated = true;
			System.out.println("Welcome to the server");
		}else{
			System.out.println("Something went wrong - try again");
		}
	}
	System.out.println("You have excited the loop");
		}
		
		

}
}
}

