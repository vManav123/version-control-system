package vcs.user.service.util;

import org.springframework.beans.BeanUtils;
import vcs.user.service.command.api.UserCreateCommand;
import vcs.user.service.model.dto.UserDto;
import vcs.user.service.model.entity.User;

public class UserUtility {
    public static User userDtoToUserEntity(UserDto userDto)
    {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }
    public static UserCreateCommand userDtoToUserCommand(UserDto userDto)
    {
        UserCreateCommand command = new UserCreateCommand();
        BeanUtils.copyProperties(userDto,command);
        return command;
    }

    public static UserDto userCommandToUserDto(UserCreateCommand command)
    {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(command,userDto);
        return userDto;
    }

    public static UserDto userEntityToUserDto(User user)
    {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }
}
