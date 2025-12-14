CREATE TABLE audit_logs (
    id BINARY(16) NOT NULL,
    action VARCHAR(50) NOT NULL,
    user_id BINARY(16),
    entity_id BINARY(16),
    ip_address VARCHAR(45),
    details JSON,
    created_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
