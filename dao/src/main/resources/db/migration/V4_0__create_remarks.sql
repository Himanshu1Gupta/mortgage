CREATE TABLE IF NOT EXISTS remarks (
    id int(11) AUTO_INCREMENT NOT NULL,
    remark jsonb  NULL DEFAULT '{}'::jsonb,
    remark_type_id INTEGER NOT NULL,
    mortgage_partner_id INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);