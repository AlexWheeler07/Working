-- Create the petshop database
CREATE DATABASE IF NOT EXISTS petshop;

-- Switch to the petshop database
USE petshop;

-- Table to store information about pet categories
CREATE TABLE pet_categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

-- Table to store information about pets
CREATE TABLE pets (
    pet_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    breed VARCHAR(50) NOT NULL,
    age INT,
    price DECIMAL(10, 2),
    category_id INT,
    description TEXT,
    image_url VARCHAR(255),
    FOREIGN KEY (category_id) REFERENCES pet_categories(category_id)
);

-- Table to store information about grooming services
CREATE TABLE grooming_services (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    available BOOLEAN DEFAULT true
);

-- Table to associate pets with specific grooming services 
CREATE TABLE pet_grooming_relationship (
    pet_id INT,
    service_id INT,
    PRIMARY KEY (pet_id, service_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id),
    FOREIGN KEY (service_id) REFERENCES grooming_services(service_id)
);

-- Table to store information about vaccinations
CREATE TABLE vaccinations (
    vaccination_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2),
    available BOOLEAN DEFAULT true
);

-- Table to associate pets with specific vaccinations 
CREATE TABLE pet_vaccination_relationship (
    pet_id INT,
    vaccination_id INT,
    PRIMARY KEY (pet_id, vaccination_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id),
    FOREIGN KEY (vaccination_id) REFERENCES vaccinations(vaccination_id)
);

-- Table to store information about addresses
CREATE TABLE addresses (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    street VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(50),
    zip_code VARCHAR(20)
);

-- Table to store information about customers
CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    phone_number VARCHAR(20),
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

-- Table to store information about transactions
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    pet_id INT,
    transaction_date DATE,
    amount DECIMAL(10, 2),
    transaction_status ENUM('Success', 'Failed'),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);

-- Table to store information about pet food
CREATE TABLE pet_food (
    food_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(100),
    type VARCHAR(50),
    quantity INT,
    price DECIMAL(10, 2)
);

-- Table to associate pets with specific food 
CREATE TABLE pet_food_relationship (
    pet_id INT,
    food_id INT,
    PRIMARY KEY (pet_id, food_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id),
    FOREIGN KEY (food_id) REFERENCES pet_food(food_id)
);

-- Table to store information about suppliers
CREATE TABLE suppliers (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    contact_person VARCHAR(50),
    phone_number VARCHAR(20),
    email VARCHAR(100),
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

-- Table to associate pets with specific suppliers 
CREATE TABLE pet_supplier_relationship (
    pet_id INT,
    supplier_id INT,
    PRIMARY KEY (pet_id, supplier_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
);

-- Table to store information about employees
CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    position VARCHAR(50),
    hire_date DATE,
    phone_number VARCHAR(20),
    email VARCHAR(100),
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES addresses(address_id)
);

-- Table to associate employees with specific pets 
CREATE TABLE employee_pet_relationship (
    employee_id INT,
    pet_id INT,
    PRIMARY KEY (employee_id, pet_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
    FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);

-- Insert records into pet_categories
INSERT INTO pet_categories (name) VALUES
('Cats'),
('Dogs'),
('Cows'),
('Buffaloes'),
('Horses'),
('Donkeys'),
('Ducks'),
('Hens'),
('Goats'),
('Sheep'),
('Fishes'),
('Parrots'),
('Turtles'),
('Guinea Pigs'),
('Hamsters'),
('Chickens'),
('Geckos'),
('Rats'),
('Snakes'),
('Rabbits');

-- Insert records into pets with different categories
INSERT INTO pets (name, breed, age, price, category_id, description, image_url)
VALUES
('Bella', 'Labrador Retriever', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Friendly and energetic Labrador Retriever', 'https://example.com/labrador.jpg'),
('Whiskers', 'Persian Cat', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 1, 'Fluffy and calm Persian Cat', 'https://example.com/persiancat.jpg'),
('Max', 'German Shepherd', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Intelligent and loyal German Shepherd', 'https://example.com/germanshepherd.jpg'),
('Simba', 'Sphynx Cat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 1, 'Hairless and affectionate Sphynx Cat', 'https://example.com/sphynxcat.jpg'),
('Luna', 'Golden Retriever', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Playful and affectionate Golden Retriever', 'https://example.com/goldenretriever.jpg'),
('Mochi', 'Siamese Cat', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 1, 'Elegant and vocal Siamese Cat', 'https://example.com/siamesecat.jpg'),
('Charlie', 'Beagle', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Curious and friendly Beagle', 'https://example.com/beagle.jpg'),
('Rocky', 'Doberman Pinscher', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Alert and loyal Doberman Pinscher', 'https://example.com/dobermanpinscher.jpg'),
('Lucy', 'French Bulldog', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Adorable and easygoing French Bulldog', 'https://example.com/frenchbulldog.jpg'),
('Zoe', 'Shetland Sheepdog', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Smart and energetic Shetland Sheepdog', 'https://example.com/sheltie.jpg'),
('Cooper', 'Bulldog', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Determined and gentle Bulldog', 'https://example.com/bulldog.jpg'),
('Lola', 'Pomeranian', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Fluffy and lively Pomeranian', 'https://example.com/pomeranian.jpg'),
('Max', 'Poodle', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Intelligent and hypoallergenic Poodle', 'https://example.com/poodle.jpg'),
('Duke', 'Dalmatian', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Distinctive and friendly Dalmatian', 'https://example.com/dalmatian.jpg'),
('Mia', 'Bernese Mountain Dog', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Gentle and strong Bernese Mountain Dog', 'https://example.com/bernesemountaindog.jpg'),
('Teddy', 'Cavalier King Charles Spaniel', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Gentle and affectionate Cavalier King Charles Spaniel', 'https://example.com/cavalierkingcharles.jpg'),
('Oscar', 'Corgi', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Adorable and outgoing Corgi', 'https://example.com/corgi.jpg'),
('Chloe', 'Great Dane', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Giant and friendly Great Dane', 'https://example.com/greatdane.jpg'),
('Bailey', 'Basset Hound', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Laid-back and charming Basset Hound', 'https://example.com/bassethound.jpg'),
('Oliver', 'Maltese', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Sweet and playful Maltese', 'https://example.com/maltese.jpg'),
('Lily', 'Pug', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Charming and mischievous Pug', 'https://example.com/pug.jpg'),
('Rocky', 'Ragdoll Cat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 1, 'Gentle and laid-back Ragdoll Cat', 'https://example.com/ragdollcat.jpg'),
('Sophie', 'Chihuahua', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Tiny and spirited Chihuahua', 'https://example.com/chihuahua.jpg'),
('Milo', 'Australian Shepherd', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Intelligent and energetic Australian Shepherd', 'https://example.com/australianshepherd.jpg'),
('Ziggy', 'Maine Coon Cat', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 1, 'Fluffy and friendly Maine Coon Cat', 'https://example.com/mainecooncat.jpg'),
('Penny', 'Cocker Spaniel', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 2, 'Gentle and affectionate Cocker Spaniel', 'https://example.com/cockerspaniel.jpg'),
('Daisy', 'Holstein', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Gentle and productive Holstein cow', 'https://example.com/holstein.jpg'),
('Thunder', 'Thoroughbred', 4, ROUND(RAND() * (100000 - 100) + 100, 2), 5, 'Elegant and fast Thoroughbred horse', 'https://example.com/thoroughbred.jpg'),
('Nemo', 'Clownfish', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Colorful and playful Clownfish', 'https://example.com/clownfish.jpg'),
('Bessie', 'Jersey', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Adorable and milk-producing Jersey cow', 'https://example.com/jersey.jpg'),
('Shadow', 'Arabian', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 5, 'Graceful and intelligent Arabian horse', 'https://example.com/arabian.jpg'),
('Fin', 'Beta Fish', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Colorful and vibrant Beta Fish', 'https://example.com/betafish.jpg'),
('Meadow', 'Simmental', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Friendly and robust Simmental cow', 'https://example.com/simmental.jpg'),
('Spirit', 'Quarter Horse', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 5, 'Powerful and versatile Quarter Horse', 'https://example.com/quarterhorse.jpg'),
('Aqua', 'Goldfish', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Classic and graceful Goldfish', 'https://example.com/goldfish.jpg'),
('Rosie', 'Brown Swiss', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Docile and high-milk-yielding Brown Swiss cow', 'https://example.com/brownswiss.jpg'),
('Midnight', 'Clydesdale', 4, ROUND(RAND() * (100000 - 100) + 100, 2), 5, 'Strong and majestic Clydesdale horse', 'https://example.com/clydesdale.jpg'),
('Coral', 'Tetra Fish', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Small and colorful Tetra Fish', 'https://example.com/tetrafish.jpg'),
('Buddy', 'Charolais', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Hardy and efficient Charolais cow', 'https://example.com/charolais.jpg'),
('Misty', 'Appaloosa', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 5, 'Distinctive and spotted Appaloosa horse', 'https://example.com/appaloosa.jpg'),
('Neptune', 'Guppy', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Colorful and sociable Guppy', 'https://example.com/guppy.jpg'),
('MooMoo', 'Galloway', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Adaptable and hardy Galloway cow', 'https://example.com/galloway.jpg'),
('Shadowfax', 'Friesian', 4, ROUND(RAND() * (100000 - 100) + 100, 2), 5, 'Elegant and black-coated Friesian horse', 'https://example.com/friesian.jpg'),
('Bubble', 'Angelfish', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Graceful and delicate Angelfish', 'https://example.com/angelfish.jpg'),
('Bison', 'Bison', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 3, 'Wild and powerful American Bison', 'https://example.com/bison.jpg'),
('Thumper', 'Holland Lop', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Adorable and gentle Holland Lop rabbit', 'https://example.com/hollandlop.jpg'),
('Eeyore', 'Miniature Donkey', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Calm and small-sized Miniature Donkey', 'https://example.com/miniaturedonkey.jpg'),
('Billy', 'Boer Goat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Hardy and productive Boer Goat', 'https://example.com/boergoat.jpg'),
('Snowflake', 'Dorset Sheep', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'White and woolly Dorset Sheep', 'https://example.com/dorsetsheep.jpg'),
('Cotton', 'Jersey Wooly', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Fluffy and small Jersey Wooly rabbit', 'https://example.com/jerseywooly.jpg'),
('Burro', 'American Donkey', 4, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Sturdy and dependable American Donkey', 'https://example.com/americandonkey.jpg'),
('Cheese', 'Nubian Goat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Energetic and long-eared Nubian Goat', 'https://example.com/nubiangoat.jpg'),
('Woolly', 'Suffolk Sheep', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Black-faced and hardy Suffolk Sheep', 'https://example.com/suffolksheep.jpg'),
('Bunny', 'Mini Rex', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Soft and velvety Mini Rex rabbit', 'https://example.com/minirex.jpg'),
('Jack', 'Poitou Donkey', 5, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Large and shaggy Poitou Donkey', 'https://example.com/poitoudonkey.jpg'),
('Munchkin', 'Pygmy Goat', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Tiny and playful Pygmy Goat', 'https://example.com/pygmygoat.jpg'),
('Fleece', 'Merino Sheep', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Fine-wooled and versatile Merino Sheep', 'https://example.com/merinosheep.jpg'),
('Cocoa', 'Rex Rabbit', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Velvety and chocolate-colored Rex Rabbit', 'https://example.com/rexrabbit.jpg'),
('Eeyore II', 'American Mammoth Donkey', 6, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Tall and gentle American Mammoth Donkey', 'https://example.com/americanmammothdonkey.jpg'),
('Jumper', 'LaMancha Goat', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Earless and friendly LaMancha Goat', 'https://example.com/lamanchagoat.jpg'),
('Woolsworth', 'Corriedale Sheep', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Dual-purpose and robust Corriedale Sheep', 'https://example.com/corriedalesheep.jpg'),
('Thistle', 'English Angora', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Fluffy and docile English Angora rabbit', 'https://example.com/englishangora.jpg'),
('Gus', 'Mammoth Jackstock Donkey', 7, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Large and strong Mammoth Jackstock Donkey', 'https://example.com/mammothjackstockdonkey.jpg'),
('Chewbacca', 'Cashmere Goat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Long-haired and charming Cashmere Goat', 'https://example.com/cashmeregoat.jpg'),
('Snowball', 'Shropshire Sheep', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'White-faced and meaty Shropshire Sheep', 'https://example.com/shropshiresheep.jpg'),
('Hopscotch', 'Dwarf Hotot', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Small and distinct Dwarf Hotot rabbit', 'https://example.com/dwarphotot.jpg'),
('Charlie', 'Andalusian Donkey', 4, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Elegant and sociable Andalusian Donkey', 'https://example.com/andalusiandonkey.jpg'),
('Maple', 'Alpine Goat', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Hardy and milk-producing Alpine Goat', 'https://example.com/alpinegoat.jpg'),
('Woolly III', 'Lincoln Sheep', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Large and woolly Lincoln Sheep', 'https://example.com/lincolnsheep.jpg'),
('Fluffernutter', 'Miniature Lop', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 19, 'Laid-back and fluffy Miniature Lop rabbit', 'https://example.com/miniaturelop.jpg'),
('Dobby', 'Poitou Donkey', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 6, 'Shaggy and affectionate Poitou Donkey', 'https://example.com/poitoudonkey2.jpg'),
('Oreo', 'Saanen Goat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 9, 'Distinctive and high-milk-yielding Saanen Goat', 'https://example.com/saanengoat.jpg'),
('Fluffykins', 'Suffolk Sheep', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 10, 'Fluffy and adorable Suffolk Sheep', 'https://example.com/fluffysuffolk.jpg'),
('Rio', 'African Grey Parrot', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 11, 'Intelligent and talkative African Grey Parrot', 'https://example.com/africangreyparrot.jpg'),
('Whiskers', 'Fancy Rat', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 17, 'Curious and social Fancy Rat', 'https://example.com/fancyrat.jpg'),
('Shelly', 'Red-Eared Slider Turtle', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 12, 'Colorful and aquatic Red-Eared Slider Turtle', 'https://example.com/redearedslider.jpg'),
('Bacon', 'Mini Pig', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 18, 'Small and charming Mini Pig', 'https://example.com/minipig.jpg'),
('Kiwi', 'Eclectus Parrot', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 11, 'Vibrant and friendly Eclectus Parrot', 'https://example.com/eclectusparrot.jpg'),
('Squeaky', 'Hooded Rat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 17, 'Adorable and playful Hooded Rat', 'https://example.com/hoodedrat.jpg'),
('Splash', 'Painted Turtle', 4, ROUND(RAND() * (100000 - 100) + 100, 2), 12, 'Colorful and hardy Painted Turtle', 'https://example.com/paintedturtle.jpg'),
('Truffle', 'Teacup Pig', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 18, 'Tiny and delightful Teacup Pig', 'https://example.com/teacuppig.jpg'),
('Mango', 'Sun Conure Parrot', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 11, 'Colorful and energetic Sun Conure Parrot', 'https://example.com/sunconure.jpg'),
('Nibbles', 'Dumbo Rat', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 17, 'Cute and distinctive Dumbo Rat', 'https://example.com/dumborat.jpg'),
('Tortellini', 'Box Turtle', 5, ROUND(RAND() * (100000 - 100) + 100, 2), 12, 'Slow and fascinating Box Turtle', 'https://example.com/boxturtle.jpg'),
('Pebbles', 'Potbelly Pig', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 18, 'Friendly and compact Potbelly Pig', 'https://example.com/potbellypig.jpg'),
('Rio II', 'Macaw Parrot', 3, ROUND(RAND() * (100000 - 100) + 100, 2), 11, 'Colorful and majestic Macaw Parrot', 'https://example.com/macawparrot.jpg'),
('Rizzo', 'Himalayan Rat', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 17, 'Unique and fluffy Himalayan Rat', 'https://example.com/himalayanrat.jpg'),
('Sandy', 'Eastern Box Turtle', 6, ROUND(RAND() * (100000 - 100) + 100, 2), 12, 'Territorial and fascinating Eastern Box Turtle', 'https://example.com/easternboxturtle.jpg'),
('Pippin', 'Juliana Pig', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 18, 'Small and playful Juliana Pig', 'https://example.com/julianapig.jpg'),
('Rainbow', 'Conure Parrot', 2, ROUND(RAND() * (100000 - 100) + 100, 2), 11, 'Colorful and cheerful Conure Parrot', 'https://example.com/conureparrot.jpg'),
('Whiskerino', 'Rex Rat', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 17, 'Curly and friendly Rex Rat', 'https://example.com/rexrat.jpg'),
('Spike', 'Spotted Turtle', 7, ROUND(RAND() * (100000 - 100) + 100, 2), 12, 'Distinctive and patterned Spotted Turtle', 'https://example.com/spottedturtle.jpg'),
('Truffle II', 'Kunekune Pig', 1, ROUND(RAND() * (100000 - 100) + 100, 2), 18, 'Friendly and rotund Kunekune Pig', 'https://example.com/kunekunepig.jpg');
