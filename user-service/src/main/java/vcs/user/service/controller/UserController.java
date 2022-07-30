package vcs.user.service.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.hibernate.id.UUIDGenerationStrategy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vcs.user.service.command.api.UserCreateCommand;
import vcs.user.service.model.dto.UserDto;
import vcs.user.service.util.UserUtility;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final CommandGateway commandGateway;

    public UserController(final CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "/create")
    public UserDto create(@RequestBody UserDto userDto)
    {
        return Optional
                .ofNullable(userDto)
                .map(UserUtility::userDtoToUserCommand)
                .map(userCreateCommand -> {
                    userCreateCommand.setUserId(new Random().nextLong(1,10000000000L));
                    userCreateCommand.setStatus("STARTED");
                    return userCreateCommand;
                })
                .map(userCreateCommand -> (UserCreateCommand) commandGateway.sendAndWait(userCreateCommand))
                .map(UserUtility::userCommandToUserDto)
                .orElse(null);
    }

}
