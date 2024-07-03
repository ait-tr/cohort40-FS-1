package cons4;


import org.mapstruct.factory.Mappers;

public interface UserMapper {

   // UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDTO userDTO);

    UserDTO userToUserDto(User user);

}
