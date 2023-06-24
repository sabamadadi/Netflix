package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    static NetflixService service;

    public Authenticator(NetflixService input_service) {
        service = input_service;
    }

    private static int Hash(String password) {
        int MOD = 1000847, Base = 256;
        int ans = 0;
        for(int i = 0; i < password.length(); i++) {
            ans = (ans * Base) + (int)password.charAt(i);
            ans %= MOD;
        }
        return ans;
    }

    public static User Userlogin() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);

        for(int i = 0; i < service.users.size(); i++) {
            if(service.users.get(i).username.equals(name) && service.users.get(i).password == hash_password) {
                return service.users.get(i);
            }
        }
        return null;
    }

    public static User UserRegister() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();

        for(int i = 0; i < service.users.size(); i++) {
            if(service.users.get(i).username.equals(name)){
                System.out.println("username already exists !");
                return null;
            }
        }

        System.out.println("Enter Password");
        String password = cs.nextLine();
        int hash_password = Hash(password);

        User new_User = new User(name, hash_password, service);
        return new_User;
    }

    public static void UserRemove() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();

        for(int i = 0; i < service.users.size(); i++) {
            if(service.users.get(i).username.equals(name)) {
                service.users.remove(i);
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
    }

    public static void UserUpdate() {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter Username");
        String name = cs.nextLine();
        System.out.println("Enter new password");
        String new_password = cs.nextLine();

        int hash_password = Hash(new_password);
        for(int i = 0; i < service.users.size(); i++) {
            if(service.users.get(i).username.equals(name)) {
                service.users.get(i).password = hash_password;
                return;
            }
        }
        System.out.println("User doesn't exist");
        return;
    }
}
