package modall;

public class Authentication {

	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("you") && password.equals("man")) {
            return true;
        }
        return false;
    }
	
}
