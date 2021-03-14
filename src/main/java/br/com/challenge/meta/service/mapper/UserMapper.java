package br.com.challenge.meta.service.mapper;

import br.com.challenge.meta.dto.model.UserDTO;
import br.com.challenge.meta.model.User.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}