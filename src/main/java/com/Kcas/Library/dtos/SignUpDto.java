package com.Kcas.Library.dtos;

import com.Kcas.Library.entities.Groups;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String phonenum;
    private String email;
    private char[] password;
    private Groups groups;
}
