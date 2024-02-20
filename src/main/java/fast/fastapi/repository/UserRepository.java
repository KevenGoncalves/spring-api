package fast.fastapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fast.fastapi.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
