package br.ddd.domain.mapper;

import br.ddd.application.dto.ClientDTO;
import br.ddd.domain.model.Client;
import br.ddd.infra.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  @Mapping(target = "docNumber", source = "documentNumber")
  Client dtoToModel(ClientDTO dto);

  ClientEntity modelToEntity(Client vo);

  @Mapping(target = "documentNumber", source = "docNumber")
  ClientDTO modelToDto(Client vo);

  Client entityToModel(ClientEntity entity);

}
