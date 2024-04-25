package com.yugabyte.uuidexample;

import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<BankEntity, String> {

}
