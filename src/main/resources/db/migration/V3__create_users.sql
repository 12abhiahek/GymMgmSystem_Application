CREATE TABLE users(

                      id BIGINT PRIMARY KEY AUTO_INCREMENT,

                      first_name VARCHAR(100),

                      last_name VARCHAR(100),

                      email VARCHAR(150) UNIQUE,

                      phone VARCHAR(20),

                      password VARCHAR(255),

                      enabled BOOLEAN,

                      account_locked BOOLEAN,

                      role_id BIGINT,

                      created_at DATETIME,

                      updated_at DATETIME,

                      CONSTRAINT fk_role
                          FOREIGN KEY(role_id)
                              REFERENCES roles(id)

);