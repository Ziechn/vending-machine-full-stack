BEGIN TRANSACTION;

DROP TABLE IF EXISTS vending_items;
DROP TABLE IF EXISTS orders
DROP TABLE IF EXISTS wallet;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE wallet (
    id SERIAL,
    user_id INT NOT NULL,
    balance INT NOT NULL,
    CONSTRAINT PK_wallet_id PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE orders (
    id SERIAL,
    user_id INT NOT NULL,
    vending_item_id INT NOT NULL,
    date DATE NOT NULL,
    total INT NOT NULL
);

CREATE TABLE vending_items (
    id SERIAL,
    name VARCHAR NOT NULL,
    type VARCHAR NOT NULL,
    price INT NOT NULL,
    inventory INT NOT NULL,
    CONSTRAINT PK_item PRIMARY KEY (id)
);

COMMIT TRANSACTION;
