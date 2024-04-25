# UUID with Spring JPA Example

## Purpose

This repo has a simple Spring JPA project that shows how to convert String -> UUID -> String in Spring.

## Running

 1. Create a Yugabyte database with this schema: `create table bank (bank_id uuid primary key, bank_location_id text, city text, state text);`
 1. In the `src/main/java/com/yugabyte/uuidexample/BankEntity.java` file, delete line 20
 1. In the `src/main/java/com/yugabyte/uuidexample/BankEntity.java` file, add this after line 16: `@Convert(converter = UuidConverter.class)`
 1. In the root of this repo, run `mvn clean test`. It should throw a postgres error about type conversion.
 1. Drop the bank table in Yugabyte: `drop table bank;`
 1. Create a new table in Yugabyte: `create table bank (bank_id text primary key, bank_location_id uuid, city text, state text);`
 1. In the `src/main/java/com/yugabyte/uuidexample/BankEntity.java` file, delete line 17.
 1. In the `src/main/java/com/yugabyte/uuidexample/BankEntity.java` file, add this after line 19: `@Convert(converter = UuidConverter.class)`
 1. In the root of this repo, run `mvn clean test`. The test should pass.
