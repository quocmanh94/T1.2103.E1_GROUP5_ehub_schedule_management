/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.DemoProjectSem04.DTO;

/**
 *
 * @author Admin
 */
public class LoginInformation {
    private String email;
    private String password;

    public LoginInformation() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginInformation(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
}
