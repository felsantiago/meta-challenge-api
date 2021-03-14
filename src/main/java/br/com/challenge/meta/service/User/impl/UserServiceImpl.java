package br.com.challenge.meta.service.User.impl;

import br.com.challenge.meta.dto.model.UserDTO;
import br.com.challenge.meta.dto.model.UserDTO;
import br.com.challenge.meta.exception.User.UserNotFoundException;
import br.com.challenge.meta.exception.User.UserNotFoundException;
import br.com.challenge.meta.filter.UserFilter;
import br.com.challenge.meta.model.User.User;
import br.com.challenge.meta.repository.UserRepository;
import br.com.challenge.meta.service.User.UserService;
import br.com.challenge.meta.service.mapper.UserMapper;
import br.com.challenge.meta.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ServerErrorException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final UserMapper mapper;

  @Override
  public List<UserDTO> findAll(UserFilter filter, Pageable pageable) {
    return mapper.toDto(repository.findAll(new UserSpecification(filter), pageable).getContent());
  }

  @Override
  public UserDTO save(UserDTO dto) {
    try {
      return mapper.toDto(this.persist(dto));
    } catch (Exception e) {
      throw new ServerErrorException("Failed delete approvalProcessing. Error: " + e.getMessage());
    }
  }

  @Override
  public UserDTO update(UserDTO dto, UUID id) {
    this.findById(id);
    try {
      return mapper.toDto(this.persist(dto));
    } catch (Exception e) {
      throw new ServerErrorException("Failed update approvalProcessing. Error: " + e.getMessage());
    }
  }

  @Override
  public Boolean delete(UUID id) {
    this.findById(id);
    try {
      this.repository.deleteById(id);
      return true;
    } catch (Exception e) {
      throw new ServerErrorException("Failed delete User. Error: " + e.getMessage());
    }
  }

  @Override
  public User findById(UUID id) {
    return this.repository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found."));
  }

  private User persist(UserDTO dto) {
    return repository.save(mapper.toEntity(dto));
  }
}
