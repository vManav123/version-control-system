package vcs.user.service.aggregate;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import vcs.user.service.command.api.UserCreateCommand;
import vcs.user.service.event.UserCreateEvent;

import java.util.Date;

@Aggregate
@Slf4j
@NoArgsConstructor
@ToString
@Data
public class UserAggregate {

    @AggregateIdentifier
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailAddress;
    private String contactNumber;
    private String location;
    private String profileUrl;
    private Date createdDate;

    @CommandHandler
    public void aggregate(UserCreateCommand command) {
        //  You can perform validation here
        UserCreateEvent event = new UserCreateEvent();
        BeanUtils.copyProperties(command ,event);

        // Publish the event
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserCreateEvent event)
    {
        this.userId=event.getUserId();
        this.firstName=event.getFirstName();
        this.lastName=event.getLastName();
        this.username=event.getUsername();
        this.emailAddress= event.getEmailAddress();
        this.contactNumber=event.getContactNumber();
        this.location= event.getLocation();
        this.profileUrl=event.getProfileUrl();
        this.createdDate=event.getCreatedDate();
    }
    
}
