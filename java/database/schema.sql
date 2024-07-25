BEGIN TRANSACTION;

DROP TABLE IF EXISTS vending_machine;
DROP TABLE IF EXISTS vending_items;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE vending_items (
    id SERIAL,
    name VARCHAR NOT NULL,
    type VARCHAR NOT NULL,
    price INT NOT NULL,
    inventory INT NOT NULL
);

COMMIT TRANSACTION;
