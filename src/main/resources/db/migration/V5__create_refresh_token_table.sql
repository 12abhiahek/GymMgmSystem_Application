CREATE TABLE refresh_tokens(

                               id BIGINT AUTO_INCREMENT PRIMARY KEY,

                               token VARCHAR(500) NOT NULL UNIQUE,

                               user_id BIGINT NOT NULL,

                               expiry_date DATETIME NOT NULL,

                               created_at DATETIME,

                               updated_at DATETIME,

                               CONSTRAINT fk_refresh_user
                                   FOREIGN KEY(user_id)
                                       REFERENCES users(id)

);