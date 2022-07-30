package vcs.user.service.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serial;
import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String username;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "location")
    private String location;
    @Column(name = "profile_url")
    private String profileUrl;
    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;
}
