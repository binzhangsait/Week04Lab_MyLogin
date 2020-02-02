/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 798419
 */
public class AccountService {

    public User login(String username, String password) {
        if ((username.equals("adam") || username.equals("betty")) && password.equals("password")) {
            User u = new User();
            u.setUsername(username);
            u.setPassword(null);
            System.out.println("Congradulations!  User and password is validated!");
            return u;
        } else {
            System.out.println("Sorry!  User and password does not match!");
            return null;
        }
    }
}
