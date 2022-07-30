package vcs.user.service.exception;

import static vcs.user.service.util.UserConstant.USER_NOT_FOUND_WITH_USER_ID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException()
    {
        super(USER_NOT_FOUND_WITH_USER_ID);
    }

    public static UserNotFoundException newException()
    {
        return new UserNotFoundException();
    }
}
