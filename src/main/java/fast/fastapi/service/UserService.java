package fast.fastapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fast.fastapi.model.UserModel;
import fast.fastapi.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public UserModel createUser(UserModel user) {
    return userRepository.save(user);
  }

  public UserModel getUser(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public List<UserModel> listUsers() {
    return userRepository.findAll();
  }

  public UserModel updateUser(Long id, UserModel user) {
    UserModel existingUser = userRepository.findById(id).orElse(null);
    if (existingUser == null) {
      return null;
    }

    existingUser.setName(user.getName());
    existingUser.setSurname(user.getSurname());
    existingUser.setEmail(user.getEmail());
    existingUser.setAge(user.getAge());
    existingUser.setPassword(user.getPassword());

    return userRepository.save(existingUser);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
