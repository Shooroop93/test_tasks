-- liquibase formatted sql

-- changeset sergeev:added-column-users-v1
ALTER TABLE users
ADD COLUMN gender varchar(10) NOT NULL

-- rollback ALTER TABLE users DROP COLUMN gender;