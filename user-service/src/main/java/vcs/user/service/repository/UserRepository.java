package vcs.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vcs.user.service.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
