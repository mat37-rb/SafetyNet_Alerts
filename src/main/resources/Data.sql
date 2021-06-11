DROP TABLE IF EXISTS persons;
 
CREATE TABLE persons (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  city VARCHAR(250) NOT NULL,
  zip VARCHAR(250) NOT NULL,
  phone VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);

 INSERT INTO persons (firstName, lastName, address, city, zip, phone, email) VALUES
('John', 'Boyd', '1509 Culver St', 'Culver', '97451', '841-874-6512', 'jaboyd@email.com');

DROP TABLE IF EXISTS firestations;
 
CREATE TABLE firestations (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  address VARCHAR(250) NOT NULL,
  station VARCHAR(250) NOT NULL
);
 

DROP TABLE IF EXISTS medicalrecords;
 
CREATE TABLE medicalrecords (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  birthdate VARCHAR(250) NOT NULL,
  medications VARCHAR(250) NOT NULL,
  allergies VARCHAR(250) NOT NULL
);
 
