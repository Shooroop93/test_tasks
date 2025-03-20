-- liquibase formatted sql

-- changeset sergeev:create-table-users
CREATE TABLE users (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    age INT CHECK (age > 0),
    weight NUMERIC(7,2) CHECK (weight > 0),
    height NUMERIC(7,2) CHECK (height > 0),
    goal VARCHAR(20) NOT NULL
);

-- rollback DROP TABLE IF EXISTS users CASCADE;