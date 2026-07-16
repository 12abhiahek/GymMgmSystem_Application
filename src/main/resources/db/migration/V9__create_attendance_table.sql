CREATE TABLE attendance
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    member_id BIGINT NOT NULL,


    check_in_time DATETIME NOT NULL,


    check_out_time DATETIME,


    attendance_date DATE NOT NULL,


    status VARCHAR(20),


    created_at DATETIME,

    updated_at DATETIME,


    CONSTRAINT fk_attendance_member

        FOREIGN KEY(member_id)

            REFERENCES members(id)

);