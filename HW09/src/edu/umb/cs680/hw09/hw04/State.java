package edu.umb.cs680.hw09.hw04;

public interface State {

    public void logout();
    public void login(EncryptedString password);
}
