--liquibase formatted sql

--changeset shine:1

CREATE TABLE categories(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR UNIQUE NOT NULL
);
CREATE TABLE tasks(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR UNIQUE NOT NULL,
    description VARCHAR,
    status VARCHAR,
    created_at TIMESTAMP,
    category_id BIGINT,
    constraint fk_tasks_categories FOREIGN KEY (category_id) references categories(id)
);


