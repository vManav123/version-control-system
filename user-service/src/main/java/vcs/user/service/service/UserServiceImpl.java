package vcs.user.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vcs.user.service.exception.UserNotFoundException;
import vcs.user.service.model.dto.UserDto;
import vcs.user.service.model.entity.User;
import vcs.user.service.repository.UserRepository;
import vcs.user.service.util.UserUtility;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    @Transactional
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) throws UserNotFoundException {
        return repository
                .findById(user.getUserId())
                .filter(Objects::isNull)
                .map(oldUser -> repository.save(user))
                .orElseThrow(UserNotFoundException::newException);
    }

    @Override
    @Transactional
    public String delete(Long id) throws UserNotFoundException {
        return repository
                .findById(id)
                .filter(Objects::isNull)
                .map(user -> {
                    repository.deleteById(id);
                    return "success";
                })
        .orElseThrow(UserNotFoundException::newException);

    }

    @Override
    @Transactional(readOnly = true)
    public User get(Long id) {
        return repository
                .findById(id)
                .orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return repository.findAll();
    }
}
