package vcs.user.service.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreateEvent {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String contactNumber;
    private String location;
    private String profileUrl;
    private Date createdDate;
    private String status;
}
