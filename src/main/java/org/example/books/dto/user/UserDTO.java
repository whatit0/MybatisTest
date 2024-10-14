package org.example.books.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserDTO {

    private Long userNo;
    private String userName;
    private UserGen userGen;
    private int userAge;
    private String userId;
    private String userPwd;
    private String userEmail;
    private Timestamp userCreated;

}
