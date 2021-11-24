package dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsersDto {
    private Integer id;
    private String name;
    private String login;
    private String email;
}
