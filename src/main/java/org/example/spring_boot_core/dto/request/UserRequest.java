package org.example.spring_boot_core.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @Size(min = 3, max = 50, message = "USERNAME_INVALID")
    @NotBlank(message = "USER_NOT_BLANK")
    private String name;
    @NotBlank(message = "Email name can not blank")
    private String email;
    @NotBlank(message = "PASSWORD_NOT_BLANK")
    @Size(min = 3, max =  50, message = "INVALID_PASSWORD")
    private  String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
