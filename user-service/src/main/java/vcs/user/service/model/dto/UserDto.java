package vcs.user.service.model.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String contactNumber;
    private String location;
    private String profileUrl;
    private Date createdDate;
}
