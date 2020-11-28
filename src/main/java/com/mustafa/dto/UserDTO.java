package com.mustafa.dto;

import com.mustafa.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String passWord;
    private boolean enabled;
    private String phone;
    private RoleDTO role;
    private Gender gender;


}
