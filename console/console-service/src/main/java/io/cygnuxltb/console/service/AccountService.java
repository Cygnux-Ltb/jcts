package io.cygnuxltb.console.service;

import io.cygnuxltb.console.persistence.dao.AccountDao;
import io.cygnuxltb.console.persistence.entity.TblAccount;
import io.cygnuxltb.console.service.util.DtoConverter;
import io.cygnuxltb.protocol.http.outbound.AccountDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static io.cygnuxltb.console.persistence.util.DaoExecutor.select;

@Service
public final class AccountService {

    @Resource
    private AccountDao dao;

    public List<AccountDTO> getAccount(int accountId) {
        return select(TblAccount.class,
                () -> dao.queryByAccountId(accountId))
                .stream()
                .map(DtoConverter::toDTO)
                .collect(Collectors.toList());
    }

}