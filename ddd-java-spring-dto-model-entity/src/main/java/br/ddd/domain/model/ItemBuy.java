package br.ddd.domain.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public record ItemBuy(Long id, String description, BigDecimal value) {
}
