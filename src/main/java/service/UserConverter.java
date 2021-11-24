package service;

import dto.UsersDto;
import entity.Users;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UsersDto fromUserToUserDto(Users users){
        return UsersDto.builder().
                id(users.getId()).
                login(users.getLogin()).
                name(users.getName()).
                email(users.getEmail()).
                build();
    }

    public Users fromUserDtoToUser(UsersDto usersDto){
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        return users;
    }
}
