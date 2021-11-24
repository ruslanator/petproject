package service;

import dto.UsersDto;
import exceptions.ValidationException;

import java.util.List;

public interface UserService {

    UsersDto saveUser(UsersDto userDto);

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
