package vcs.user.service.service;

import vcs.user.service.exception.UserNotFoundException;
import vcs.user.service.model.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User update(User user) throws UserNotFoundException;

    String delete(Long id) throws UserNotFoundException;

    User get(Long id);

    List<User> getAll();
}
