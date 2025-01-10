package com.example.loginscriptjavafx;

import java.util.ArrayList;

public class UserCredentials {
    // Normally this data would be stored in a database
    // Stored as an array list for simplicity of this project
    private static ArrayList<String[]> users = new ArrayList<>();

    // Populate the array list with user credentials
    public UserCredentials() {
        users.add(new String[]{"Plutonic", "yKDBBZ4ap"});
        users.add(new String[]{"Misdrawn", "HJfJTjdl"});
        users.add(new String[]{"Zoneless", "password"});
    }

    // Getter
    public static ArrayList<String[]> getUsers() {
        return users;
    }
}
