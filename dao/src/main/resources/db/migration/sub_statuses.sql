CREATE TABLE mortgage_partner_sub_statuses (
                                                      id int(11) AUTO_INCREMENT NOT NULL ,
                                                      status VARCHAR(200) NULL,
                                                      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                      PRIMARY KEY (id)
);