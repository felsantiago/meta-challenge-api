package br.com.challenge.meta.dto.form;

import br.com.challenge.meta.enumeration.AccessEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
  private AccessEnum access;
  private String name;
}
