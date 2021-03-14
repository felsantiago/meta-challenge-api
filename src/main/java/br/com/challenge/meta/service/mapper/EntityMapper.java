package br.com.challenge.meta.service.mapper;

import java.util.List;
import java.util.Set;

/**
 * Contrato para o mapeamento generico de dto para entity.
 *
 * @author Rafael Benevides
 * @param <D> - O dto
 * @param <E> - A entidade
 */
public interface EntityMapper<D, E> {

  /**
   * Este método tem como objetivo converter o DTO numa Entidade
   *
   * @param dto o dto
   * @return a entidade
   */
  E toEntity(D dto);

  /**
   * Este método tem como objetivo converter a Entidade num DTO
   *
   * @param entity a entidade
   * @return o dto
   */
  D toDto(E entity);

  /**
   * Este método tem como objetivo converter uma lista de DTO numa lista de Entidade
   *
   * @param dtoList a lista de dto
   * @return a lista de entidades
   */
  List<E> toEntity(List<D> dtoList);

  /**
   * Este método tem como objetivo converter uma lista de Entidade numa lista de DTO
   *
   * @param entityList a lista de entidade
   * @return a lista de dtos
   */
  List<D> toDto(List<E> entityList);

  /**
   * Este método tem como objetivo converter um set de DTO num set de Entidade
   *
   * @param dtoSet set de dtos
   * @return o set de entidades
   */
  Set<E> toEntity(Set<D> dtoSet);

  /**
   * Este método tem como objetivo converter um set de Entidade num set de DTO
   *
   * @param entitySet o set de entidades
   * @return o set de dtos
   */
  Set<D> toDto(Set<E> entitySet);
}
