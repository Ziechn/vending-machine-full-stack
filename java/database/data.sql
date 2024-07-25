BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO vending_items (name, type, price, inventory)
VALUES
('Potato Crisps', 'Chip', 305, 5),
('Stackers', 'Chip', 145, 5),
('Grain Waves', 'Chip', 275, 5),
('Cloud Popcorn', 'Chip', 365, 5),
('Moonpie', 'Candy', 180, 5),
('Cowtales', 'Candy', 150, 5),
('Wonka Bar', 'Candy', 150, 5),
('Crunchie', 'Candy', 175, 5),
('Cola', 'Drink', 125, 5),
('Dr. Salt', 'Drink', 150, 5),
('Mountain Melter', 'Drink', 150, 5),
('Heavy', 'Drink', 150, 5),
('U-Chews', 'Gum', 85, 5),
('Little League Chew', 'Gum', 95, 5),
('Chiclets', 'Gum', 75, 5),
('Triplemint', 'Gum', 75, 5);

COMMIT TRANSACTION;
