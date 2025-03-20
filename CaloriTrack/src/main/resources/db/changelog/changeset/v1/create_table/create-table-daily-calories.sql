-- liquibase formatted sql

-- changeset sergeev:create-table-daily_calories
CREATE TABLE daily_calories (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    calories NUMERIC(7,2) CHECK (calories > 0) NOT NULL,
    formula VARCHAR(255) NOT NULL
);

-- rollback DROP TABLE IF EXISTS daily_calories CASCADE;