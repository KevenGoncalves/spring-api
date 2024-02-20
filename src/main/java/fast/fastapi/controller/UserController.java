package fast.fastapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fast.fastapi.model.UserModel;
import fast.fastapi.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/")
  public List<UserModel> list() {
    return userService.listUsers();
  }

  @PostMapping("/")
  public UserModel create(@RequestBody UserModel user) {
    return userService.createUser(user);
  }

  @PutMapping("/{id}")
  public UserModel update(
      @PathVariable(value = "id") Long id,
      @RequestBody UserModel user) {
    return userService.updateUser(id, user);
  }

  @GetMapping("/{id}")
  public UserModel get(@PathVariable(value = "id") Long id) {
    return userService.getUser(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable(value = "id") Long id) {
    userService.deleteUser(id);
  }

}
