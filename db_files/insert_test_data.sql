-- Set schema to ecopaula_production
CREATE SCHEMA IF NOT EXISTS ecopaula_production;
SET SCHEMA 'ecopaula_production';

-- Insert test data for part_type table
INSERT INTO part_type (type) VALUES
                                 ('Tenderloin'),
                                 ('Ribeye'),
                                 ('Sirloin'),
                                 ('Flank'),
                                 ('Brisket'),
                                 ('Chuck'),
                                 ('Round'),
                                 ('Shank'),
                                 ('Short Rib'),
                                 ('Top Loin');

-- Insert test data for origin table
INSERT INTO origin (name_of_farm) VALUES
                                      ('Green Pastures Farm'),
                                      ('Sunny Meadows Farm'),
                                      ('Valley View Ranch'),
                                      ('Riverbend Farm'),
                                      ('Oakwood Estates'),
                                      ('Hillside Farm'),
                                      ('Clearwater Farms'),
                                      ('Prairie Acres'),
                                      ('Golden Harvest Farm'),
                                      ('Silver Creek Ranch');

-- Insert test data for animal table
INSERT INTO animal (weight, registration_date, origin) VALUES
                                                           (450.00, '2024-01-15', 1),
                                                           (520.50, '2024-02-20', 2),
                                                           (480.25, '2024-03-05', 3),
                                                           (495.75, '2024-03-15', 4),
                                                           (500.00, '2024-04-10', 5),
                                                           (465.30, '2024-05-01', 6),
                                                           (510.75, '2024-05-18', 7),
                                                           (470.25, '2024-06-02', 8),
                                                           (455.60, '2024-06-15', 9),
                                                           (530.45, '2024-07-04', 10);

-- Insert test data for tray table
INSERT INTO tray (max_weight, part_type) VALUES
                                             (50.00, 1),
                                             (60.00, 2),
                                             (45.00, 3),
                                             (55.00, 4),
                                             (65.00, 5),
                                             (40.00, 6),
                                             (52.00, 7),
                                             (48.00, 8),
                                             (46.00, 9),
                                             (50.00, 10);

-- Insert test data for cut table
INSERT INTO cut (weight, part_type, animal_id, tray_id) VALUES
                                                            (5.25, 1, 1, 1),
                                                            (4.50, 2, 2, 2),
                                                            (3.75, 3, 3, 3),
                                                            (4.00, 4, 4, 4),
                                                            (4.80, 5, 5, 5),
                                                            (5.10, 6, 6, 6),
                                                            (5.00, 7, 7, 7),
                                                            (4.20, 8, 8, 8),
                                                            (3.95, 9, 9, 9),
                                                            (4.50, 10, 10, 10);

-- Insert test data for product table
INSERT INTO product (description) VALUES
                                      ('Premium Beef Tenderloin'),
                                      ('Angus Ribeye Steak'),
                                      ('Grass-fed Sirloin'),
                                      ('Flank Steak'),
                                      ('Smoked Brisket'),
                                      ('Ground Chuck'),
                                      ('Top Round Roast'),
                                      ('Bone-in Shank'),
                                      ('BBQ Short Ribs'),
                                      ('New York Strip');

-- Insert test data for trays_in_product table
INSERT INTO trays_in_product (tray_id, product_id) VALUES
                                                       (1, 1),
                                                       (2, 2),
                                                       (3, 3),
                                                       (4, 4),
                                                       (5, 5),
                                                       (6, 6),
                                                       (7, 7),
                                                       (8, 8),
                                                       (9, 9),
                                                       (10, 10);

INSERT INTO trays_in_product (tray_id, product_id) VALUES
                                                       (9, 1),
                                                       (2, 1),
                                                       (3, 1);
