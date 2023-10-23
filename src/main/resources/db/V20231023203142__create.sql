create table if not exists test_entity
(
    id                     UUID primary key default gen_random_uuid(),
    name                   text,
    created_date           timestamp,
    modified_date          timestamp
    );
