package br.com.challenge.meta.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AccessEnum {
  ACTIVE("Ativo"),
  INACTIVE("Inativo");

  private String description;

  AccessEnum(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static AccessEnum getEnum(final AccessEnum access) {
    return AccessEnum.values()[access.ordinal()];
  }

  public static List<AccessEnum> getAll() {
    return new ArrayList<>(Arrays.asList(AccessEnum.values()));
  }
}
