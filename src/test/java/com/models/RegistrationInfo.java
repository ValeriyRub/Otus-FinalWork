package com.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationInfo {
    private String name;
    private String email;
    private String password;
}
