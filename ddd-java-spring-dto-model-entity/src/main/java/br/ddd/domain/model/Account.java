package br.ddd.domain.model;

import java.util.List;

public record Account(Long id, Client client, List<ItemBuy> items) {
}
