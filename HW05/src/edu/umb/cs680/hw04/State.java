package edu.umb.cs680.hw04;

import edu.umb.cs680.hw04.EncryptedString;

public interface State {

    public void logout();
    public void login(EncryptedString password);
}
