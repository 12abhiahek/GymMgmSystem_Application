CREATE TABLE members
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    user_id BIGINT NOT NULL UNIQUE,


    age INT,


    gender VARCHAR(20),


    height DOUBLE,


    weight DOUBLE,


    address VARCHAR(255),


    join_date DATE,


    created_at DATETIME,


    updated_at DATETIME,


    CONSTRAINT fk_member_user
        FOREIGN KEY(user_id)
            REFERENCES users(id)

);