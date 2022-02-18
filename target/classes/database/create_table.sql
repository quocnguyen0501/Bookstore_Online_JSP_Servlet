CREATE TABLE authors
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(100),
    second_name  VARCHAR(100),
    company_name VARCHAR(100),
    CHECK ((first_name IS NOT NULL AND second_name IS NOT NULL)
        OR company_name IS NOT NULL)
);

CREATE TABLE genres
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE publishers
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE books
(
    --isbn13 format: xxx-xx-xxxxx-xx-x
    --isbn10 format: x-xxx-xxxxx-x
    isbn               VARCHAR(17) PRIMARY KEY,
    title              VARCHAR(100) NOT NULL,
    publication_date   DATE CHECK (publication_date <= now()),
    edition            INT,
    available_quantity INT          NOT NULL DEFAULT 0 CHECK (available_quantity >= 0),
    price              NUMERIC(6, 2) CHECK (price > 0),
    author             BIGINT REFERENCES authors (id) ON DELETE CASCADE,
    publisher          BIGINT REFERENCES publishers (id) ON DELETE CASCADE,
    images             VARCHAR(2083) NOT NULL
);

CREATE TABLE books_genres
(
    book_isbn  VARCHAR(17) REFERENCES books (isbn) ON DELETE CASCADE,
    genre_id BIGINT REFERENCES genres (id) ON DELETE CASCADE,
    PRIMARY KEY (book_isbn, genre_id)
);

CREATE TABLE shippers
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    phone_number VARCHAR(9)
);

CREATE TABLE discounts
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100),
    value NUMERIC(2, 2) DEFAULT 0 CHECK (value >= 0.00 AND value <= 1.00)
);

CREATE TABLE books_discounts
(
    book_isbn     VARCHAR(17) REFERENCES books (isbn) ON DELETE CASCADE,
    discount_id SERIAL REFERENCES discounts (id) ON DELETE CASCADE
);

CREATE TABLE role
(
    id            BIGINT       NOT NULL PRIMARY KEY auto_increment,
    name          VARCHAR(255) NOT NULL,
);

CREATE TABLE user_role
(
    id            BIGINT       NOT NULL PRIMARY KEY auto_increment,
    user_id       BIGINT       NOT NULL ,
    role_id       BIGINT       NOT NULL
);

CREATE TABLE users
(
    id            bigint       NOT NULL PRIMARY KEY auto_increment,
    username      VARCHAR(150) NOT NULL,
    password      VARCHAR(150) NOT NULL,
    full_name     VARCHAR(150) NULL,
    avatar        VARCHAR(2083) NULL
);

ALTER TABLE user_role ADD CONSTRAINT fk_users_user_role FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE user_role ADD CONSTRAINT fk_role_user_role FOREIGN KEY (role_id) REFERENCES role(id);

CREATE TABLE users_discounts
(
    customer_id BIGINT REFERENCES users (id) ON DELETE CASCADE,
    discount_id BIGINT REFERENCES discounts (id) ON DELETE CASCADE
);

CREATE TABLE orders
(
    id          SERIAL PRIMARY KEY,
    users_id BIGINT NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    date        DATE    DEFAULT now() CHECK (date <= now()),
    discount_id BIGINT REFERENCES discounts (id) ON DELETE CASCADE,
    shipper     BIGINT NOT NULL REFERENCES shippers (id) ON DELETE CASCADE,
    state       VARCHAR DEFAULT 'AWAITING'
        CHECK (state = 'AWAITING' OR state = 'PAID' OR state = 'SENT')
);

CREATE TABLE orders_details
(
    book_isbn  VARCHAR(17) REFERENCES books (isbn) ON DELETE CASCADE,
    order_id BIGINT NOT NULL REFERENCES orders (id) ON DELETE CASCADE,
    amount   INTEGER CHECK (amount > 0)
);

CREATE TABLE ratings
(
    id       SERIAL PRIMARY KEY,
    book_isbn  VARCHAR NOT NULL REFERENCES books (isbn) ON DELETE CASCADE,
    users_id BIGINT  NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    rating  INTEGER CHECK (rating BETWEEN 0 AND 5),
    date     DATETIME DEFAULT now()
);

CREATE TABLE comments
(
    id       SERIAL PRIMARY KEY,
    book_isbn  VARCHAR NOT NULL REFERENCES books (isbn) ON DELETE CASCADE,
    users_id BIGINT  NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    rating_id BIGINT NOT NULL REFERENCES comments (id) ON DELETE CASCADE,
    comment  TEXT NOT NULL,
    date     DATETIME DEFAULT now()
);