package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {
    SecurityContext scx=new SecurityContext(new EncryptedString("hello"),"user");
    @Test
    public void TestAuthentication(){

        boolean actual=Authenticator.authenticate(new EncryptedString("hello"),scx);
        boolean expected=true;
        assertEquals(expected,actual);
    }
    @Test
    public void TestLoginWhenLoggedOut(){
        scx.logout();
        scx.login(new EncryptedString("hello"));
        assertTrue(scx.getState() instanceof LoggedIn);
    }
    @Test
    public void TestLogoutWhenLoggedIn(){
        scx.login(new EncryptedString("hello"));
        scx.logout();
       assertTrue(scx.getState() instanceof LoggedOut);
    }

    @Test
    public void TestLoginWhenLoggedIn(){
        scx.login(new EncryptedString("hello"));
        assertTrue(scx.getState() instanceof LoggedIn);
        scx.login(new EncryptedString("hello"));
        assertTrue(scx.getState() instanceof LoggedIn);
    }

    @Test
    public void TestAuthenticationFailException(){

        try{
            scx.login(new EncryptedString("hi"));
            fail("Failed to Authenticate");
        }
        catch (Exception e){
            String expected="Incorrect Password";
            assertEquals(expected,e.getMessage());
        }
    }

}