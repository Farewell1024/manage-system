package com.skyeye.managesystem.domain.dto;


/**
 * Function:
 *
 * @author zhangyu
 * Date: 2018/11/7 4:25 PM
 * @since JDK 1.8
 */
public class LoginDTO {

    private String username;

    private String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
