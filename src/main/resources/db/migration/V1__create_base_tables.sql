CREATE TABLE application_info(

                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                 app_name VARCHAR(100),

                                 version VARCHAR(20)

);

INSERT INTO application_info(app_name,version)

VALUES ('Gym Management','1.0');