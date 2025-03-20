-- liquibase formatted sql

-- changeset sergeev:create-table-meal_dishes
CREATE TABLE meal_dishes (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    meal_id INT REFERENCES meals(id) ON DELETE CASCADE,
    dish_id INT REFERENCES dishes(id) ON DELETE CASCADE,
    portion INT CHECK (portion > 0) NOT NULL
);

-- rollback DROP TABLE IF EXISTS meal_dishes CASCADE;