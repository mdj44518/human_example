package security;

public class PasswordTestApp {

	public static void main(String[] args) {
		String myPassword = "myPassword123";
        
        // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordEncrypt.getSalt(30);
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordEncrypt.generateSecurePassword(myPassword, salt);
        
        // Print out protected password 
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);
        
        boolean passwordMatch = PasswordEncrypt.verifyUserPassword(myPassword, mySecurePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + myPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }
	}

}
