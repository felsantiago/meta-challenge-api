package br.com.challenge.meta.service.User.impl;

import br.com.challenge.meta.dto.model.UserDTO;
import br.com.challenge.meta.filter.UserFilter;
import br.com.challenge.meta.service.User.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public List<UserDTO> findAll(UserFilter filter, Pageable pageable) {
    return null;
  }

  @Override
  public UserDTO save(UserDTO dto) {
    return null;
  }

  @Override
  public UserDTO update(UserDTO dto, UUID id) {
    return null;
  }

  @Override
  public Boolean delete(UUID id) {
    return null;
  }
}
