package com.yugabyte.uuidexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Commit
public class BankRepositoryTests {

    private static final Log LOG = LogFactory.getLog(BankRepositoryTests.class);

    @Autowired
    BankRepository bankRepository;

    @Test
    void testInsertWithConversion() throws Exception {

        String bankId = UUID.randomUUID().toString();
        String bankLocationId = UUID.randomUUID().toString();

        BankEntity bank = new BankEntity();
        bank.setBankId(bankId);
        bank.setBankLocationId(bankLocationId);
        bank.setCity("Des Moines");
        bank.setState("IA");
        bankRepository.save(bank);

        Optional<BankEntity> savedBank = bankRepository.findById(bankId);
        assertTrue(savedBank.isPresent());
        assertEquals(savedBank.get().getBankId(), bankId);
        LOG.info(String.format("Bank id = [%s]", savedBank.get().getBankId()));

    }
}
