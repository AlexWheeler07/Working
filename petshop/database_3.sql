-- Insert records into pet_food 
INSERT INTO pet_food (name, brand, type, quantity, price)
VALUES
('Premium Cat Food', 'Whiskers', 'Dry', 20, 1200.50),
('Healthy Dog Bites', 'Pawsome', 'Wet', 15, 850.75),
('Organic Rabbit Pellets', 'Hop Nibble', 'Dry', 25, 600.25),
('Natural Fish Treats', 'Finest Catch', 'Wet', 18, 950.00),
('Grain-Free Puppy Chow', 'Tail Wag', 'Dry', 22, 1100.25),
('Fresh Chicken Delight', 'Feather Feast', 'Wet', 12, 750.50),
('Nutritious Turtle Sticks', 'Shell Care', 'Dry', 30, 800.75),
('Feathered Friends Mix', 'Tweet Treats', 'Wet', 14, 600.00),
('Goat Milk Blend', 'Hoof & Horn', 'Dry', 28, 900.25),
('Soft Lamb Bites', 'Baa Treats', 'Wet', 16, 700.75),
('Ocean Delight Fish Food', 'Seaside Scales', 'Dry', 24, 1300.50),
('Fresh Veggie Crunch', 'Garden Goodies', 'Wet', 20, 1000.75),
('Crunchy Parrot Pellets', 'Colorful Chirp', 'Dry', 26, 850.25),
('Gourmet Hamster Feast', 'Tiny Treats', 'Wet', 10, 550.00),
('Country Chicken Morsels', 'Farm Fresh', 'Dry', 18, 1200.25),
('Super Seeds Blend', 'Nutty Nibbles', 'Wet', 25, 950.50),
('Snappy Snail Treats', 'Slow Munch', 'Dry', 15, 700.25),
('Wholesome Rat Mix', 'Rodent Riches', 'Wet', 23, 600.75),
('Slimy Snake Supper', 'Slither Snacks', 'Dry', 12, 800.50),
('Leafy Greens Munch', 'Turtle Tidbits', 'Wet', 30, 1100.00),
('Guinea Pig Granola', 'Piggie Paradise', 'Dry', 20, 900.75),
('Sweet Carrot Drops', 'Hop Along', 'Wet', 14, 750.25),
('Hearty Horse Hay', 'Stable Supreme', 'Dry', 26, 1300.25),
('Duck Delight Pellets', 'Quacker Quisine', 'Wet', 18, 1000.50),
('Fruity Ferret Treats', 'Ferret Feast', 'Dry', 22, 850.75),
('Piggy Pellets', 'Snout Snacks', 'Wet', 16, 600.00),
('Moo Moo Cow Chow', 'Pasture Perfect', 'Dry', 30, 1100.25),
('Chick-N-Cheese Medley', 'Cluck Cluck', 'Wet', 10, 700.50),
('Sardine Surprise', 'Sea Symphony', 'Dry', 28, 950.25),
('Healthy Hedgehog Blend', 'Spiky Snacks', 'Wet', 24, 800.75),
('Kitty Crunch Delight', 'Meow Munchies', 'Dry', 18, 850.25),
('Beefy Bites for Dogs', 'Woof N Chew', 'Wet', 14, 700.50),
('Herbivore Bunny Pellets', 'Green Graze', 'Dry', 22, 950.75),
('Salmon Sensation Treats', 'Finned Feast', 'Wet', 20, 1100.25),
('Puppy Power Kibble', 'Tiny Tails', 'Dry', 25, 1200.50),
('Chicken Pate for Pups', 'Pawlicking Good', 'Wet', 16, 900.75),
('Algae-Infused Turtle Bites', 'Shell Savvy', 'Dry', 30, 1000.00),
('Melody of Tweets Mix', 'Singing Serenade', 'Wet', 12, 800.50),
('Goat Cheese Delight', 'Hoof & Whisker', 'Dry', 28, 750.25),
('Soft Lamb Stew', 'Baa Bonanza', 'Wet', 15, 600.75),
('Tropical Fish Delicacy', 'Aqua Appetite', 'Dry', 24, 1300.50),
('Garden Greens Combo', 'Leafy Luxuries', 'Wet', 18, 1000.75),
('Parrot Paradise Pellets', 'Vibrant Vibes', 'Dry', 26, 950.25),
('Hamster Heaven Feast', 'Pocket Paradise', 'Wet', 10, 550.00),
('Country Chicken Chunks', 'Farm Fresh Fare', 'Dry', 20, 1200.25),
('Nutty Birdie Mix', 'Feathered Fusion', 'Wet', 25, 850.50),
('Crunchy Snail Treats', 'Spiral Snacks', 'Dry', 15, 700.25),
('Rich Rat Regimen', 'Rodent Royalty', 'Wet', 23, 600.75),
('Venomous Viper Vittles', 'Slithery Suppers', 'Dry', 12, 800.50),
('Leafy Turtle Treats', 'Shell Smorgasbord', 'Wet', 30, 1100.00);

-- Insert records into pet_food_relationship with specific associations
INSERT INTO pet_food_relationship (pet_id, food_id) VALUES
(1, 5), (2, 15), (3, 20), (4, 10), (5, 25),
(6, 35), (7, 45), (8, 50), (9, 30), (10, 40),
(11, 3), (12, 18), (13, 8), (14, 28), (15, 48),
(16, 38), (17, 13), (18, 23), (19, 43), (20, 33),
(21, 1), (22, 11), (23, 16), (24, 6), (25, 21),
(26, 31), (27, 41), (28, 46), (29, 26), (30, 36),
(31, 2), (32, 12), (33, 17), (34, 7), (35, 22),
(36, 32), (37, 42), (38, 47), (39, 27), (40, 37),
(41, 4), (42, 14), (43, 9), (44, 29), (45, 49),
(46, 39), (47, 24), (48, 34), (49, 44), (50, 19);

-- Insert records into suppliers for pet varieties
INSERT INTO suppliers (name, contact_person, phone_number, email, address_id) VALUES
('Pet Supply Co', 'John Smith', '123-456-7890', 'john@example.com', FLOOR(RAND() * 50) + 1),
('Animal Haven Suppliers', 'Jane Doe', '987-654-3210', 'jane@example.com', FLOOR(RAND() * 50) + 1),
('Farmers Pet Emporium', 'Bob Johnson', '555-123-4567', 'bob@example.com', FLOOR(RAND() * 50) + 1),
('Feathered Friends Distributors', 'Alice Wilson', '111-222-3333', 'alice@example.com', FLOOR(RAND() * 50) + 1),
('Furry Companions Supply', 'Charlie Brown', '888-777-6666', 'charlie@example.com', FLOOR(RAND() * 50) + 1),
('Reptile Realm Suppliers', 'Eva Garcia', '444-555-6666', 'eva@example.com', FLOOR(RAND() * 50) + 1),
('Paws and Claws Wholesale', 'David Anderson', '777-888-9999', 'david@example.com', FLOOR(RAND() * 50) + 1),
('Fluffy Friends Importers', 'Samantha Turner', '666-555-4444', 'samantha@example.com', FLOOR(RAND() * 50) + 1),
('Hoof and Horn Livestock Suppliers', 'Mark Davis', '222-333-4444', 'mark@example.com', FLOOR(RAND() * 50) + 1),
('Aquatic Wonders Distributors', 'Karen White', '999-888-7777', 'karen@example.com', FLOOR(RAND() * 50) + 1),
('Avian Adventures Suppliers', 'Kevin Thomas', '444-333-2222', 'kevin@example.com', FLOOR(RAND() * 50) + 1),
('Small Critters Supply Co', 'Laura Miller', '333-444-5555', 'laura@example.com', FLOOR(RAND() * 50) + 1),
('Rodent Retailers', 'Mike Harris', '777-666-5555', 'mike@example.com', FLOOR(RAND() * 50) + 1),
('Hoppy Homes Distributors', 'Olivia Brown', '555-666-7777', 'olivia@example.com', FLOOR(RAND() * 50) + 1),
('Shell Shack Importers', 'Henry Taylor', '111-222-3333', 'henry@example.com', FLOOR(RAND() * 50) + 1),
('Swim Fin Suppliers', 'Grace Robinson', '888-777-6666', 'grace@example.com', FLOOR(RAND() * 50) + 1),
('Feathered Friends Wholesale', 'Tom Parker', '666-555-4444', 'tom@example.com', FLOOR(RAND() * 50) + 1),
('Furry Friends Distributors', 'Mia Wilson', '555-666-7777', 'mia@example.com', FLOOR(RAND() * 50) + 1),
('Squeaky Toy Importers', 'Chris Adams', '333-444-5555', 'chris@example.com', FLOOR(RAND() * 50) + 1),
('Pet Paradise Supply Co', 'Sophie Turner', '222-333-4444', 'sophie@example.com', FLOOR(RAND() * 50) + 1),
('Exotic Pets Emporium', 'Jason Miller', '555-444-3333', 'jason@example.com', FLOOR(RAND() * 50) + 1),
('Wildlife Wholesalers', 'Emily Harris', '222-333-4444', 'emily@example.com', FLOOR(RAND() * 50) + 1),
('Feathered Friends Suppliers', 'Daniel Taylor', '999-888-7777', 'daniel@example.com', FLOOR(RAND() * 50) + 1),
('Hoof and Paw Distributors', 'Sophia Adams', '666-555-4444', 'sophia@example.com', FLOOR(RAND() * 50) + 1),
('Reptile Retreat Importers', 'Matthew Robinson', '111-222-3333', 'matthew@example.com', FLOOR(RAND() * 50) + 1),
('Aqua World Suppliers', 'Ava Turner', '888-777-6666', 'ava@example.com', FLOOR(RAND() * 50) + 1),
('Purr-fect Pets Retailers', 'William White', '444-555-6666', 'william@example.com', FLOOR(RAND() * 50) + 1),
('Livestock Haven Distributors', 'Chloe Brown', '777-888-9999', 'chloe@example.com', FLOOR(RAND() * 50) + 1),
('Winged Wonders Importers', 'Owen Thomas', '555-444-3333', 'owen@example.com', FLOOR(RAND() * 50) + 1),
('Fur and Feather Supplies', 'Lily Miller', '222-333-4444', 'lily@example.com', FLOOR(RAND() * 50) + 1),
('Scale and Tail Distributors', 'Jackson Harris', '999-888-7777', 'jackson@example.com', FLOOR(RAND() * 50) + 1),
('Avian Allies Importers', 'Madison Adams', '666-555-4444', 'madison@example.com', FLOOR(RAND() * 50) + 1),
('Fluffy and Fins Retailers', 'Logan Robinson', '111-222-3333', 'logan@example.com', FLOOR(RAND() * 50) + 1),
('Wild Companions Suppliers', 'Abigail Turner', '888-777-6666', 'abigail@example.com', FLOOR(RAND() * 50) + 1),
('Barnyard Buddies Distributors', 'Gabriel White', '444-555-6666', 'gabriel@example.com', FLOOR(RAND() * 50) + 1),
('Aquatic Associates Importers', 'Emma Brown', '777-888-9999', 'emma@example.com', FLOOR(RAND() * 50) + 1),
('Feathery Friends Retailers', 'Carter Thomas', '555-444-3333', 'carter@example.com', FLOOR(RAND() * 50) + 1),
('Small Paws and Claws Suppliers', 'Scarlett Miller', '222-333-4444', 'scarlett@example.com', FLOOR(RAND() * 50) + 1),
('Finned and Furry Imports', 'Aiden Harris', '999-888-7777', 'aiden@example.com', FLOOR(RAND() * 50) + 1),
('Winged Wonders Retailers', 'Zoe Adams', '666-555-4444', 'zoe@example.com', FLOOR(RAND() * 50) + 1),
('Pet Paradise Suppliers', 'Brayden Robinson', '111-222-3333', 'brayden@example.com', FLOOR(RAND() * 50) + 1),
('Reptile Retreat Retailers', 'Nora Turner', '888-777-6666', 'nora@example.com', FLOOR(RAND() * 50) + 1),
('Furry Friends Wholesalers', 'Eli White', '444-555-6666', 'eli@example.com', FLOOR(RAND() * 50) + 1),
('Purr-fect Partners Imports', 'Hannah Brown', '777-888-9999', 'hannah@example.com', FLOOR(RAND() * 50) + 1),
('Feathered Companions Retailers', 'Liam Thomas', '555-444-3333', 'liam@example.com', FLOOR(RAND() * 50) + 1),
('Barnyard Buddies Suppliers', 'Grace Miller', '222-333-4444', 'grace@example.com', FLOOR(RAND() * 50) + 1),
('Scales and Tails Wholesalers', 'Mason Harris', '999-888-7777', 'mason@example.com', FLOOR(RAND() * 50) + 1),
('Fur and Fins Imports', 'Addison Adams', '666-555-4444', 'addison@example.com', FLOOR(RAND() * 50) + 1),
('Wild Companions Retailers', 'Evelyn Robinson', '111-222-3333', 'evelyn@example.com', FLOOR(RAND() * 50) + 1);

-- Insert records into pet_supplier_relationship for pet and supplier associations
INSERT INTO pet_supplier_relationship (pet_id, supplier_id) VALUES
-- For Cats
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1),
-- For Dogs
(6, 2), (7, 2), (8, 2), (9, 2), (10, 2),
-- For Cows
(11, 3), (12, 3), (13, 3), (14, 3), (15, 3),
-- For Horses
(16, 4), (17, 4), (18, 4), (19, 4), (20, 4),
-- For Donkeys
(21, 5), (22, 5), (23, 5), (24, 5), (25, 5),
-- For Rabbits
(26, 6), (27, 6), (28, 6), (29, 6), (30, 6),
-- For Parrots
(31, 7), (32, 7), (33, 7), (34, 7), (35, 7),
-- For Rats
(36, 8), (37, 8), (38, 8), (39, 8), (40, 8),
-- For Pigs
(41, 9), (42, 9), (43, 9), (44, 9), (45, 9),
-- For Turtles
(46, 10), (47, 10), (48, 10), (49, 10), (50, 10);

-- Insert records into employees for animal care staff
INSERT INTO employees (first_name, last_name, position, hire_date, phone_number, email, address_id) VALUES
('John', 'Smith', 'Veterinarian', '2022-01-01', '555-1234', 'john.smith@example.com', FLOOR(RAND() * 50) + 1),
('Emily', 'Johnson', 'Veterinary Technician', '2022-02-15', '555-5678', 'emily.johnson@example.com', FLOOR(RAND() * 50) + 1),
('David', 'Williams', 'Veterinary Assistant', '2022-03-20', '555-9012', 'david.williams@example.com', FLOOR(RAND() * 50) + 1),
('Jennifer', 'Davis', 'Manager', '2021-12-01', '555-3456', 'jennifer.davis@example.com', FLOOR(RAND() * 50) + 1),
('Michael', 'Brown', 'Assistant Manager', '2022-04-10', '555-7890', 'michael.brown@example.com', FLOOR(RAND() * 50) + 1),
('Emma', 'Miller', 'Pet Groomer', '2022-05-15', '555-2345', 'emma.miller@example.com', FLOOR(RAND() * 50) + 1),
('Daniel', 'Jones', 'Grooming Assistant', '2022-06-20', '555-6789', 'daniel.jones@example.com', FLOOR(RAND() * 50) + 1),
('Sophia', 'Garcia', 'Administrative Assistant', '2022-07-01', '555-0123', 'sophia.garcia@example.com', FLOOR(RAND() * 50) + 1),
('Matthew', 'Martinez', 'Office Manager', '2022-08-15', '555-4567', 'matthew.martinez@example.com', FLOOR(RAND() * 50) + 1),
('Olivia', 'Smith', 'Animal Caretaker', '2022-09-20', '555-8901', 'olivia.smith@example.com', FLOOR(RAND() * 50) + 1),
('Ethan', 'Taylor', 'Animal Care Specialist', '2022-10-01', '555-3456', 'ethan.taylor@example.com', FLOOR(RAND() * 50) + 1),
('Ava', 'Wilson', 'Zookeeper', '2022-11-15', '555-7890', 'ava.wilson@example.com', FLOOR(RAND() * 50) + 1),
('Noah', 'Anderson', 'Security Officer', '2022-12-20', '555-1234', 'noah.anderson@example.com', FLOOR(RAND() * 50) + 1),
('Isabella', 'Thomas', 'Security Supervisor', '2023-01-01', '555-5678', 'isabella.thomas@example.com', FLOOR(RAND() * 50) + 1),
('Mason', 'Hernandez', 'Animal Nutritionist', '2023-02-15', '555-9012', 'mason.hernandez@example.com', FLOOR(RAND() * 50) + 1),
('Amelia', 'Young', 'Dietary Assistant', '2023-03-20', '555-2345', 'amelia.young@example.com', FLOOR(RAND() * 50) + 1),
('Logan', 'Scott', 'Animal Behaviorist', '2023-04-10', '555-6789', 'logan.scott@example.com', FLOOR(RAND() * 50) + 1),
('Abigail', 'King', 'Behavioral Trainer', '2023-05-15', '555-0123', 'abigail.king@example.com', FLOOR(RAND() * 50) + 1),
('Jackson', 'Evans', 'Customer Service Representative', '2023-06-20', '555-4567', 'jackson.evans@example.com', FLOOR(RAND() * 50) + 1),
('Avery', 'Baker', 'Customer Care Specialist', '2023-07-01', '555-8901', 'avery.baker@example.com', FLOOR(RAND() * 50) + 1);

-- Insert records into employee_pet_relationship
INSERT INTO employee_pet_relationship (employee_id, pet_id) VALUES
-- Veterinary Staff
(1, 1), (2, 2), (3, 3), 
-- Management
(4, 4), (5, 5), 
-- Grooming Staff
(6, 6), (7, 7), 
-- Administrative Staff
(8, 8), (9, 9), 
-- Animal Caretakers
(10, 10), (11, 11), (12, 12), 
-- Security
(13, 13), (14, 14), 
-- Nutritionist
(15, 15), (16, 16), 
-- Animal Behaviorist
(17, 17), (18, 18), 
-- Customer Service
(19, 19), (20, 20), 
-- Additional Records
(1, 21), (2, 22), (3, 23), (4, 24), (5, 25), (6, 26), (7, 27), (8, 28), (9, 29), (10, 30); 
