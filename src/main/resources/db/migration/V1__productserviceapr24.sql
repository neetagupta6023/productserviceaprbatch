CREATE TABLE category
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at VARCHAR(255) NULL,
    title      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE jt_it
(
    id              BIGINT NOT NULL,
    special_session VARCHAR(255) NULL,
    CONSTRAINT pk_jt_it PRIMARY KEY (id)
);

CREATE TABLE jt_mt
(
    id           BIGINT NOT NULL,
    company_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mt PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id           BIGINT NOT NULL,
    numof_sesion INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_usr
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_usr PRIMARY KEY (id)
);

CREATE TABLE mps_it
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255) NULL,
    email_id        VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    special_session VARCHAR(255) NULL,
    CONSTRAINT pk_mps_it PRIMARY KEY (id)
);

CREATE TABLE mps_mt
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email_id     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_mps_mt PRIMARY KEY (id)
);

CREATE TABLE mps_ta
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email_id     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    numof_sesion INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_mps_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_at    VARCHAR(255) NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price DOUBLE NULL,
    category_id   BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE sc_usr
(
    id              BIGINT NOT NULL,
    user_type       INT NULL,
    name            VARCHAR(255) NULL,
    email_id        VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    company_name    VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    numof_sesion    INT    NOT NULL,
    special_session VARCHAR(255) NULL,
    CONSTRAINT pk_sc_usr PRIMARY KEY (id)
);

CREATE TABLE tps_it
(
    id              BIGINT NOT NULL,
    name            VARCHAR(255) NULL,
    email_id        VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    special_session VARCHAR(255) NULL,
    CONSTRAINT pk_tps_it PRIMARY KEY (id)
);

CREATE TABLE tps_mt
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email_id     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tps_mt PRIMARY KEY (id)
);

CREATE TABLE tps_ta
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email_id     VARCHAR(255) NULL,
    password     VARCHAR(255) NULL,
    numof_sesion INT    NOT NULL,
    avg_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tps_ta PRIMARY KEY (id)
);

CREATE TABLE tps_usr
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255) NULL,
    email_id VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tps_usr PRIMARY KEY (id)
);

ALTER TABLE jt_it
    ADD CONSTRAINT FK_JT_IT_ON_ID FOREIGN KEY (id) REFERENCES jt_usr (id);

ALTER TABLE jt_mt
    ADD CONSTRAINT FK_JT_MT_ON_ID FOREIGN KEY (id) REFERENCES jt_usr (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_usr (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);