package vcs.user.service.handler;


import io.axoniq.axonserver.grpc.command.Command;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vcs.user.service.command.api.UserCreateCommand;
import vcs.user.service.event.UserCreateEvent;
import vcs.user.service.model.entity.User;
import vcs.user.service.service.UserService;

@Slf4j
@Component
//@ProcessingGroup("UserErrorEvent")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserEventHandler {

    private UserService userService;

    @EventHandler
    @SneakyThrows
    public void on(UserCreateEvent event) {
        User user = new User();
        BeanUtils.copyProperties(event , user);
        user = userService.create(user);
        event.setUserId(user.getUserId());
        event.setStatus("SUCCESS");
    }

    @ExceptionHandler
    public void handle(Exception e) throws Exception {
        log.info("ExceptionHandler handles the exception {}",e.getMessage());
        throw e;
    }
}
