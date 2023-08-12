package com.Kcas.Library.dtos;

import com.Kcas.Library.entities.Groups;
import com.Kcas.Library.entities.LikedBooks;
import com.Kcas.Library.entities.TakenBooks;
import com.Kcas.Library.security.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phonenum;
    private String email;
    private LocalDate birthday;
    private String address;
    private Groups groups;
    private byte[] profileImage;
    private UserRole userRole;
    private Boolean locked;
    private Boolean enabled;

    private String token;
}
