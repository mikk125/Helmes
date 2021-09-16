INSERT INTO sector (id, depth, text) VALUES (1, 0,'Manufacturing');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (19, 1, 1, 'Construction materials');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (18, 1, 1, 'Electronics and Optics');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (6, 1, 1, 'Food and Beverage');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (342, 6, 2, 'Bakery & confectionery products');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (43, 6, 2, 'Beverages');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (42, 6, 2, 'Fish & fish products');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (40, 6, 2, 'Meat & meat products');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (39, 6, 2, 'Milk & dairy products');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (437, 6, 2, 'Other');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (378, 6, 2, 'Sweets & snack food');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (13, 1, 1, 'Furniture');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (389, 13, 2, 'Bathroom/sauna');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (385, 13, 2, 'Bedroom');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (390, 13, 2, 'Childrens room');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (98, 13, 2, 'Kitchen');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (101, 13, 2, 'Living room');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (392, 13, 2, 'Office');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (394, 13, 2, 'Other (Furniture)');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (341, 13, 2, 'Outdoor');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (99, 13, 2, 'Project furniture');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (12, 1, 1, 'Machinery');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (94, 12, 2, 'Machinery components');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (91, 12, 2, 'Machinery equipment/tools');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (224, 12, 2, 'Manufacture of machinery');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (97, 12, 2, 'Maritime');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (271, 97, 3, 'Aluminium and steel workboats');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (269, 97, 3, 'Boat/Yacht building');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (230, 97, 3, 'Ship repair and conversion');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (93, 12, 2, 'Metal structures');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (508, 12, 2, 'Other');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (227, 12, 2, 'Repair and maintenance service');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (11, 1, 1, 'Metalworking');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (67, 11, 2, 'Construction of metal structures');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (263, 11, 2, 'Houses and buildings');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (267, 11, 2, 'Metal products');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (542, 11, 2, 'Metal works');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (75, 542, 3, 'CNC-machining');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (62, 542, 3, 'Forgings, Fasteners');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (69, 542, 3, 'Gas, Plasma, Laser cutting');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (66, 542, 3, 'MIG, TIG, Aluminium welding');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (9, 1, 1, 'Plastic and Rubber');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (54, 9, 2, 'Packaging');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (556, 9, 2, 'Plastic goods');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (559, 9, 2, 'Plastic processing technology');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (55, 559, 3, 'Blowing');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (57, 559, 3, 'Moulding');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (53, 559, 3, 'Plastics welding and processing');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (560, 9, 2, 'Plastic profiles');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (5, 1, 1, 'Printing');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (148, 5, 2, 'Advertising');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (150, 5, 2, 'Book/Periodicals printing');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (145, 5, 2, 'Labelling and packaging printing');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (7, 1, 1, 'Textile and Clothing');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (44, 7, 2, 'Clothing');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (45, 7, 2, 'Textile');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (8, 1, 1, 'Wood');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (337, 8, 2, 'Other (Wood)');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (51, 8, 2, 'Wooden building materials');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (47, 8, 2, 'Wooden houses');

INSERT INTO sector (id, depth, text) VALUES (3, 0, 'Other');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (37, 3, 1, 'Creative industries');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (29, 3, 1, 'Energy technology');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (33, 3, 1, 'Environment');

INSERT INTO sector (id, depth, text) VALUES (2, 0, 'Service');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (25, 2, 1, 'Business services');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (35, 2, 1, 'Engineering');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (28, 2, 1, 'Information Technology and Telecommuncation');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (581, 28, 2, 'Data processing, Web portals, E-marketing');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (576, 28, 2, 'Programming, Consultancy');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (121, 28, 2, 'Software, Hardware');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (122, 28, 2, 'Telecommuncations');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (22, 2, 1, 'Tourism');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (141, 2, 1, 'Translation services');

INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (21, 2, 1, 'Transport and Logistics');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (111, 21, 2, 'Air');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (114, 21, 2, 'Rail');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (112, 21, 2, 'Road');
INSERT INTO sector (id, parent_sector_id, depth, text) VALUES (113, 21, 2, 'Water');

