CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE shift (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_time TIMESTAMP NOT NULL,
    update_time TIMESTAMP NOT NULL,
    is_deleted BOOLEAN NOT NULL CHECK (is_deleted = false),
    type VARCHAR(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    CONSTRAINT check_dates CHECK (start_date <= end_date)
);

INSERT INTO shift (id, creation_time, update_time, is_deleted, type, start_date, end_date) VALUES
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    'AFTERNOON',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP + INTERVAL '1 hour'
),
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    'MORNING',
    CURRENT_TIMESTAMP + INTERVAL '1 hour',
    CURRENT_TIMESTAMP + INTERVAL '3 hours'
);

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_time TIMESTAMP NOT NULL,
    update_time TIMESTAMP NOT NULL,
    is_deleted BOOLEAN NOT NULL CHECK (is_deleted = false),
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    contact_info VARCHAR(20) NOT NULL,
    role VARCHAR(255) NOT NULL,
    CONSTRAINT username_unique UNIQUE (username)
);

INSERT INTO users (id, creation_time, update_time, is_deleted, username, password, contact_info, role) VALUES
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    'john_doe',
    'Password123!',
    '12345678901',
    'ADMIN'
),
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    'jane_smith',
    'SecurePassword!2025',
    '98765432101',
    'USER'
),
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    'mike_jones',
    'P@ssword1',
    '555123456711',
    'MODERATOR'
);

CREATE TABLE shift_assignment (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    creation_time TIMESTAMP NOT NULL,
    update_time TIMESTAMP NOT NULL,
    is_deleted BOOLEAN NOT NULL CHECK (is_deleted = false),
    employee_id UUID NOT NULL,
    shift_id UUID NOT NULL,
    shift_date TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES users(id),
    CONSTRAINT fk_shift FOREIGN KEY (shift_id) REFERENCES shift(id)
);

INSERT INTO shift_assignment (id, creation_time, update_time, is_deleted, employee_id, shift_id, shift_date, status) VALUES
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    (SELECT id FROM users WHERE username = 'john_doe' LIMIT 1),
    (SELECT id FROM shift WHERE type = 'MORNING' LIMIT 1),
    CURRENT_TIMESTAMP,
    'ASSIGNED'
),
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    (SELECT id FROM users WHERE username = 'jane_smith' LIMIT 1),
    (SELECT id FROM shift WHERE type = 'AFTERNOON' LIMIT 1),
    CURRENT_TIMESTAMP + INTERVAL '1 day',
    'ASSIGNED'
),
(
    gen_random_uuid(),
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    false,
    (SELECT id FROM users WHERE username = 'mike_jones' LIMIT 1),
    (SELECT id FROM shift WHERE type = 'MORNING' LIMIT 1),
    CURRENT_TIMESTAMP + INTERVAL '2 days',
    'ASSIGNED'
);
