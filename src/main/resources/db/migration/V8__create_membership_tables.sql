CREATE TABLE membership_plans
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    description VARCHAR(255),

    duration_months INT NOT NULL,

    price DOUBLE NOT NULL,

    active BOOLEAN DEFAULT TRUE,

    created_at DATETIME,

    updated_at DATETIME

);



CREATE TABLE member_subscriptions
(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,


    member_id BIGINT NOT NULL,


    plan_id BIGINT NOT NULL,


    start_date DATE NOT NULL,


    end_date DATE NOT NULL,


    status VARCHAR(30),


    created_at DATETIME,

    updated_at DATETIME,


    CONSTRAINT fk_subscription_member

        FOREIGN KEY(member_id)

            REFERENCES members(id),



    CONSTRAINT fk_subscription_plan

        FOREIGN KEY(plan_id)

            REFERENCES membership_plans(id)

);