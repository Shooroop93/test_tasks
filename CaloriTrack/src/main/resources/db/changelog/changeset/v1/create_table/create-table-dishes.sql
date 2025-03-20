-- liquibase formatted sql

-- changeset sergeev:create-table-dishes
CREATE TABLE dishes (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    calories NUMERIC(7,2) CHECK (calories >= 0) NOT NULL,
    proteins NUMERIC(7,2) CHECK (proteins >= 0) NOT NULL,
    fats NUMERIC(7,2) CHECK (fats >= 0) NOT NULL,
    carbs NUMERIC(7,2) CHECK (carbs >= 0) NOT NULL
);

-- rollback DROP TABLE IF EXISTS dishes CASCADE;