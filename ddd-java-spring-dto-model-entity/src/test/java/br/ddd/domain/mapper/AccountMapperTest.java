package br.ddd.domain.mapper;

import br.ddd.application.dto.AccountDTO;
import br.ddd.application.dto.ClientDTO;
import br.ddd.application.dto.ItemBuyDTO;
import br.ddd.domain.model.Account;
import br.ddd.domain.model.Client;
import br.ddd.domain.model.ItemBuy;
import br.ddd.infra.entity.AccountEntity;
import br.ddd.infra.entity.ClientEntity;
import br.ddd.infra.entity.ItemBuyEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringJUnitConfig(classes = {
    AccountMapperImpl.class,
    ClientMapperImpl.class
})
class AccountMapperTest {

  @Autowired
  private AccountMapper mapper;

  @Test
  void shouldConvertDtoToModel() {
    ClientDTO clientDTO = new ClientDTO(1L, "Maria", "12345678900");
    ItemBuyDTO itemBuyDTO_1 = new ItemBuyDTO(1L, "Produto Alfa", new BigDecimal("10.00"));
    ItemBuyDTO itemBuyDTO_2 = new ItemBuyDTO(2L, "Produto Bravo", new BigDecimal("20.00"));
    AccountDTO accountDTO = new AccountDTO(1L, clientDTO, List.of(itemBuyDTO_1, itemBuyDTO_2));

    Account model = mapper.dtoToModel(accountDTO);

    assertAll(
        () -> assertEquals(1L, model.id()),
        () -> assertEquals("Maria", model.client().name()),
        () -> assertEquals("12345678900", model.client().docNumber()),
        () -> assertEquals("Produto Alfa", model.items().get(0).description())
    );
  }

  @Test
  void shouldConvertModelToEntity() {
    Client client = new Client(1L, "Maria", "12345678900");
    ItemBuy itemBuy_1 = new ItemBuy(1L, "Produto Alfa", new BigDecimal("10.00"));
    ItemBuy itemBuy_2 = new ItemBuy(2L, "Produto Bravo", new BigDecimal("20.00"));
    Account account = new Account(null, client, List.of(itemBuy_1, itemBuy_2));

    AccountEntity entity = mapper.modelToEntity(account);

    assertAll(
        () -> assertNull(entity.getId()),
        () -> assertEquals(2, entity.getItems().size())
    );
  }

  @Test
  void shouldConvertModelToDto() {
    Client client = new Client(1L, "Maria", "12345678900");
    ItemBuy itemBuy_1 = new ItemBuy(1L, "Produto Alfa", new BigDecimal("10.00"));
    ItemBuy itemBuy_2 = new ItemBuy(2L, "Produto Bravo", new BigDecimal("20.00"));
    Account account = new Account(null, client, List.of(itemBuy_1, itemBuy_2));

    AccountDTO dto = mapper.modelToDto(account);

    assertAll(
        () -> assertNull(dto.id()),
        () -> assertEquals("Maria", dto.client().name()),
        () -> assertEquals("12345678900", dto.client().documentNumber()),
        () -> assertEquals(2, dto.items().size())

    );
  }

  @Test
  void shouldConvertEntityToModel() {
    ClientEntity clientEntity = new ClientEntity();
    clientEntity.setId(1L);
    clientEntity.setName("Maria");
    clientEntity.setDocNumber("12345678900");

    ItemBuyEntity itemBuy_1 = new ItemBuyEntity();
    itemBuy_1.setId(1L);
    itemBuy_1.setDescription("Produto Alfa");
    itemBuy_1.setValue(new BigDecimal("10.00"));
    ItemBuyEntity itemBuy_2 = new ItemBuyEntity();
    itemBuy_2.setId(2L);
    itemBuy_2.setDescription("Produto Bravo");
    itemBuy_2.setValue(new BigDecimal("20.00"));

    AccountEntity entity = new AccountEntity();
    entity.setId(1L);
    entity.setClient(clientEntity);
    entity.setItems(List.of(itemBuy_1, itemBuy_2));

    Account model = mapper.entityToModel(entity);

    assertAll(
        () -> assertEquals(1L, model.id()),
        () -> assertEquals("Maria", model.client().name()),
        () -> assertEquals("12345678900", model.client().docNumber()),
        () -> assertEquals(2, model.items().size())
    );
  }

  @Test
  void shouldReturnNullWhenDtoIsNull() {
    assertNull(mapper.dtoToModel(null));
  }

  @Test
  void shouldReturnNullWhenModelIsNull() {
    assertNull(mapper.modelToEntity(null));
    assertNull(mapper.modelToDto(null));
  }

  @Test
  void shouldReturnNullWhenEntityIsNull() {
    assertNull(mapper.entityToModel(null));
  }


}