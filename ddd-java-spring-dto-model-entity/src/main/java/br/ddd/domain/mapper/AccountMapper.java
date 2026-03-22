package br.ddd.domain.mapper;

import br.ddd.application.dto.AccountDTO;
import br.ddd.domain.model.Account;
import br.ddd.infra.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface AccountMapper {
  Account dtoToModel(AccountDTO dto);

  AccountEntity modelToEntity(Account model);

  Account entityToModel(AccountEntity entity);

  AccountDTO modelToDto(Account vo);
}
