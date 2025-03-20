-- liquibase formatted sql

-- changeset sergeev:create-table-meals
CREATE TABLE meals (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    date DATE NOT NULL
);

-- rollback DROP TABLE IF EXISTS meals CASCADE;