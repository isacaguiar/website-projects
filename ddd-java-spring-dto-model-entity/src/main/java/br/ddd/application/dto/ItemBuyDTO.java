package br.ddd.application.dto;

import java.math.BigDecimal;

public record ItemBuyDTO(Long id, String description, BigDecimal value) {
}