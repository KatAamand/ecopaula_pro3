CREATE SCHEMA IF NOT EXISTS ecopaula_production;
SET SCHEMA 'ecopaula_production';

CREATE TABLE part_type (
    id SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE origin (
    id SERIAL PRIMARY KEY,
    name_of_farm VARCHAR(255) NOT NULL
);

CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    weight DECIMAL(5, 2) NOT NULL,
    registration_date DATE NOT NULL,
    origin int NOT NULL,
    FOREIGN KEY (origin) REFERENCES origin(id)
);

CREATE TABLE tray (
    id SERIAL PRIMARY KEY,
    max_weight DECIMAL(5, 2) NOT NULL,
    part_type INT NOT NULL,
    FOREIGN KEY (part_type) REFERENCES part_type(id)
);

CREATE TABLE cut (
     id SERIAL,
     weight DECIMAL(5, 2) NOT NULL,
     part_type INT NOT NULL,
     animal_id INT NOT NULL,
     tray_id INT,
     PRIMARY KEY (animal_id, id),
     FOREIGN KEY (part_type) REFERENCES part_type(id),
     FOREIGN KEY (animal_id) REFERENCES animal(id),
     FOREIGN KEY (tray_id) REFERENCES tray(id)
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL
);

CREATE TABLE trays_in_product (
      tray_id INT,
      product_id INT,
      PRIMARY KEY (tray_id, product_id),
      FOREIGN KEY (tray_id) REFERENCES tray(id),
      FOREIGN KEY (product_id) REFERENCES product(id)
);


