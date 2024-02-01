CREATE TABLE IF NOT EXISTS professional_details (
    id int(11) AUTO_INCREMENT NOT NULL,
    pan_number VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(255) NOT NULL,
    email_address VARCHAR(255),
    gst_number VARCHAR(255),
    legal_name_of_organization VARCHAR(255),
    trade_of_the_organization VARCHAR(255),
    address_of_the_organization VARCHAR(255),
    state_of_the_organization VARCHAR(255),
    pin_code_of_the_organization VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);