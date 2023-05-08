package edu.umb.cs680.hw09.hw04;

public class Authenticator {
    public static boolean authenticate(EncryptedString password, SecurityContext sc){
        String pass=sc.getPassword().pwd;
        if(!(pass.contentEquals(password.pwd))){
            return false;
        }
        return true;
    }
}
