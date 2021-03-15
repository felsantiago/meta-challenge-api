package br.com.challenge.meta.service.mapper.user;

import br.com.challenge.meta.dto.model.user.UserDTO;
import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.service.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}