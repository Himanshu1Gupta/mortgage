CREATE TABLE IF NOT EXISTS remark_types (
    id int(11) AUTO_INCREMENT NOT NULL,
    remark_type VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO remark_types (remark_type, created_at, updated_at) VALUES ('agreement_remarks_by_rcm', NOW(), NOW());
INSERT INTO remark_types (remark_type, created_at, updated_at) VALUES ('payout_remarks_by_mortgage_partner', NOW(), NOW());