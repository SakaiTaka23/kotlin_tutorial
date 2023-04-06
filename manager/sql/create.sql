CREATE DATABASE book_manager;

USE book_manager;

CREATE TABLE user
(
    id        BIGINT              NOT NULL,
    email     VARCHAR(256) UNIQUE NOT NULL,
    password  VARCHAR(128)        NOT NULL,
    name      VARCHAR(32)         NOT NULL,
    role_type ENUM ('ADMIN', 'USER'),
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE book
(
    id           BIGINT       NOT NULL,
    title        VARCHAR(128) NOT NULL,
    author       VARCHAR(32)  NOT NULL,
    release_date DATE         NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE rental
(
    book_id         BIGINT   NOT NULL,
    user_id         BIGINT   NOT NULL,
    rental_date     DATETIME NOT NULL,
    return_deadline DATETIME NOT NULL,
    PRIMARY KEY (book_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO book VALUES
                     (100, 'Kotlin入門', 'コトリン太郎', '1950-10-01'),
                     (200, 'Java入門', 'ジャヴァ太郎', '2005-08-29');

# password のハッシュ
INSERT INTO user VALUES
                     (1, 'admin@test.com', '$2y$05$QiMwFspXEHEgE6chqM/v/ueuj/A8XYF57iTRbVmB0Xo.xC2cOgqyW', '管理者', 'ADMIN'),
                     (2, 'user@test.com', '$2y$05$G8edlGdwsY0JKg2TNAYwi.DYtn7ml5Wdalrf4LJYfnt3Ms.hL95qq', 'ユーザー', 'USER')
