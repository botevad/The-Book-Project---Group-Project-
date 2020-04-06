package bg.codeacademy.spring.project1.service;

import bg.codeacademy.spring.project1.dto.ChangePasswordDTO;
import bg.codeacademy.spring.project1.dto.UserDTO;
import bg.codeacademy.spring.project1.dto.UserRegistration;
import bg.codeacademy.spring.project1.model.User;

import java.util.List;

public interface UserService
{

  enum ChangePasswordResult {
    OK, NOT_FOUND, BAD_CREDENTIALS
  }

  public UserDTO getUser(String userName);

  public void createUser(UserRegistration userDto);

  public boolean changePassword(String userName, ChangePasswordDTO changePasswordDTO);

  public boolean deleteUser(String userName);

  public List<UserDTO> getUsers();
}
