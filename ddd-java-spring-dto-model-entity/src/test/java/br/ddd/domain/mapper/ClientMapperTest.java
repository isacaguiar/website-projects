package br.ddd.domain.mapper;

import br.ddd.application.dto.ClientDTO;
import br.ddd.domain.model.Client;
import br.ddd.infra.entity.ClientEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringJUnitConfig(classes = {
    ClientMapperImpl.class
})
class ClientMapperTest {

  @Autowired
  private ClientMapper mapper;

  @Test
  void shouldConvertDtoToModel() {
    ClientDTO dto = new ClientDTO(null, "Maria", "12345678900");

    Client model = mapper.dtoToModel(dto);

    assertAll(
        () -> assertNull(model.id()),
        () -> assertEquals("Maria", model.name()),
        () -> assertEquals("12345678900", model.docNumber())
    );
  }

  @Test
  void shouldConvertModelToEntity() {
    Client model = new Client(null, "Maria", "12345678900");

    ClientEntity entity = mapper.modelToEntity(model);

    assertAll(
        () -> assertNull(entity.getId()),
        () -> assertEquals("Maria", entity.getName()),
        () -> assertEquals("12345678900", entity.getDocNumber())
    );
  }

  @Test
  void shouldConvertModelToDto() {
    Client model = new Client(null, "Maria", "12345678900");

    ClientDTO dto = mapper.modelToDto(model);

    assertAll(
        () -> assertNull(dto.id()),
        () -> assertEquals("Maria", dto.name()),
        () -> assertEquals("12345678900", dto.documentNumber())
    );
  }

  @Test
  void shouldConvertEntityToModel() {
    ClientEntity entity = new ClientEntity();
    entity.setName("Maria");
    entity.setDocNumber("12345678900");

    Client model = mapper.entityToModel(entity);

    assertAll(
        () -> assertNull(model.id()),
        () -> assertEquals("Maria", model.name()),
        () -> assertEquals("12345678900", model.docNumber())
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