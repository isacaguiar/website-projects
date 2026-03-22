package br.ddd.application.dto;

import java.util.List;

public record AccountDTO(Long id, ClientDTO client, List<ItemBuyDTO> items) {
  public AccountDTO {
    items = items == null ? List.of() : List.copyOf(items);
  }
}