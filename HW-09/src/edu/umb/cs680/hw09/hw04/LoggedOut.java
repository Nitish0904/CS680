package edu.umb.cs680.hw09.hw04;

public class LoggedOut implements State {

    private SecurityContext sc;
    private static LoggedOut logout_instance=null;

    private LoggedOut(){

    }
    public static LoggedOut getLoggedOutInstance(){
        if(logout_instance==null){
            logout_instance=new LoggedOut();
        }
        return logout_instance;
    }
    public void setSecurityContext(SecurityContext scx){
        sc=scx;
    }

    @Override
    public void logout() {
        System.out.println("User LoggedOut");
    }

    @Override
    public void login(EncryptedString password) {
        if(!(Authenticator.authenticate(password,sc))){
            throw new RuntimeException("Incorrect Password");
        }
        else{
            LoggedIn inst= LoggedIn.getLoggedInInstance();
            inst.setSecurityContext(sc);
            sc.ChangeState(inst);
            System.out.println("State changed to login");
        }
    }
}
