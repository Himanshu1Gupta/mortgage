CREATE TABLE agreement_signatory_details (
                                               id int(11) AUTO_INCREMENT NOT NULL ,
                                               name VARCHAR(200) NULL,
                                               phone_number VARCHAR(50) NULL,
                                               proof_url VARCHAR(200) NULL,
                                               created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                               updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                               PRIMARY KEY (id)
);