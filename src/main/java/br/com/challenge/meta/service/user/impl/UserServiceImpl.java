package br.com.challenge.meta.service.user.impl;

import br.com.challenge.meta.dto.model.user.UserDTO;
import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.repository.user.UserRepository;
import br.com.challenge.meta.service.mapper.user.UserMapper;
import br.com.challenge.meta.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class that implements the user's service methods
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper mapper;
  private final UserRepository repository;

  /**
   * @see UserService#save(UserDTO)
   */
  @Override
  public UserDTO save(UserDTO dto) {
    return mapper.toDto(repository.save(mapper.toEntity(dto)));
  }

  /**
   * @see UserService#findByEmail(String)
   */
  @Override
  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  @Override
  public User toEntity(UserDTO dto) {
    return mapper.toEntity(dto);
  }
}
