package edu.umb.cs680.hw04;

public class LoggedIn implements State {

    private SecurityContext sc;
    private static LoggedIn login_instance=null;

    private LoggedIn(){}

    public static LoggedIn getLoggedInInstance(){
        if(login_instance==null){
            login_instance=new LoggedIn();
        }
        return login_instance;
    }

    public void setSecurityContext(SecurityContext scx){
        sc=scx;
    }

    @Override
    public void logout() {
        LoggedOut instance=LoggedOut.getLoggedOutInstance();
        instance.setSecurityContext(sc);
        sc.ChangeState(instance);
        System.out.println("State changed to logout");
    }

    @Override
    public void login(EncryptedString password) {
        if(sc.isActive()) {
            System.out.println("User LoggedIn");
        }
    }
}
