package br.com.challenge.meta.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatusEnum {
  CHECK_AND_REVIEW("Verificar e revisar"),
  COST_CENTER_APPROVAL("Aprovação do centro de custo"),
  FIDUCIARY_APPROVAL("Aprovação fiduciária"),
  PURCHASING_MANAGER_APPROVAL("Aprovação do gerente de compras"),
  CFO_APPROVAL("Aprovação do CFO"),
  APPROVED("Aprovada"),
  REJECTED("Rejeitada");

  private String description;

  StatusEnum(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public static StatusEnum getEnum(final StatusEnum actionCampaign) {
    return StatusEnum.values()[actionCampaign.ordinal()];
  }

  public static List<StatusEnum> getAll() {
    return new ArrayList<>(Arrays.asList(StatusEnum.values()));
  }
}
