CREATE TABLE trainers
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    user_id BIGINT NOT NULL UNIQUE,


    specialization VARCHAR(100),


    experience_years INT,


    salary DOUBLE,


    joining_date DATE,


    created_at DATETIME,


    updated_at DATETIME,


    CONSTRAINT fk_trainer_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)

);