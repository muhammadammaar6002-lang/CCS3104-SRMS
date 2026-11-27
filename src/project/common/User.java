package project.common;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String role;
    private String username;

    public User(String username, String role){
        this.username = username;
        this.role = role;
    }

    public String getUsername(){
        return username;
    }

    public String getRole(){
        return role;
    }
}
