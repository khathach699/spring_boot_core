package org.example.spring_boot_core.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @Size(min = 3, max = 50, message = "User name must be at least 3 and 50 character")
    @NotBlank(message = "User name can not blank")
    private String name;
    @NotBlank(message = "Email name can not blank")
    private String email;
    @NotBlank(message = "User name can not blank")
    @Size(min = 3, max =  50, message = "Password must be at least 3 and 50 character")
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
