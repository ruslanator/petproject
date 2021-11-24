package service;

import dto.UsersDto;
import entity.Users;
import exceptions.ValidationException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import repository.UserRepository;


import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UserService{

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if(isNull(usersDto)){
            throw new ValidationException("Object user is null.");
        }
        if(isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is empty.");
        }
    }

    @SneakyThrows
    @Override
    public UsersDto saveUser(UsersDto usersDto) {
        validateUserDto(usersDto);
        Users savedUser = userRepository.save(userConverter.fromUserDtoToUser(usersDto));
        return userConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId){
        userRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login){
        Users users = userRepository.findByLogin(login);
        if(users != null) return userConverter.fromUserToUserDto(users);
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }


}
