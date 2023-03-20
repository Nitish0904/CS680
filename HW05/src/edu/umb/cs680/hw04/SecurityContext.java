package edu.umb.cs680.hw04;

public class SecurityContext {
    String username;
    EncryptedString password;
    State s;

    public SecurityContext(EncryptedString pass, String user){
        LoggedOut inst=LoggedOut.getLoggedOutInstance();
        inst.setSecurityContext(this);
        this.s=inst;
        this.password=pass;
        this.username=user;
    }

    public void ChangeState(State changedState){
        this.s=changedState;
    }

    public void logout(){
        this.s.logout();
    }

    public void login(EncryptedString password){
        this.s.login(password);
    }

    public boolean isActive(){
        if(this.s instanceof LoggedIn){
            return true;
        }
        return false;
    }

    public EncryptedString getPassword(){
        return this.password;
    }
    public State getState(){
        return this.s;
    }

}
