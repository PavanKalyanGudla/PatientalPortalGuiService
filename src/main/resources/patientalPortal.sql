show databases;
create database patientalPortal;
use patientalPortal;
show tables;
show create table user;
-- User Table
CREATE TABLE Patient (
    patientId VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    age VARCHAR(255),
    dob VARCHAR(255),
    maritialStatus VARCHAR(255),
    profilePic LONGBLOB,
    gender VARCHAR(255),
    addressId VARCHAR(255),
    insuranceInfoId VARCHAR(255)
);
CREATE TABLE PatientAddress (
    addressId VARCHAR(255) PRIMARY KEY,
    patientId VARCHAR(255),
    mobile VARCHAR(255),
    email VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zipCode VARCHAR(255),
    drNo VARCHAR(255),
    emergencyContactName VARCHAR(255),
    relationShip VARCHAR(255),
    emergencyContactMobile VARCHAR(255),
    password VARCHAR(255),
    FOREIGN KEY (patientId) REFERENCES `Patient`(patientId)
);
-- update PatientAddress set drNo = "5045 Apt A, Cochran Street" where patientId="pavangudla4";
CREATE TABLE InsuranceInfo (
    insuranceInfoId VARCHAR(255) PRIMARY KEY,
    patientId VARCHAR(255),
    providerName VARCHAR(255),
    policyNumber VARCHAR(255),
    groupNumber VARCHAR(255),
    coverageType VARCHAR(255),
    effectiveDate VARCHAR(255),
    expirationDate VARCHAR(255),
    FOREIGN KEY (patientId) REFERENCES `Patient`(patientId)
);
CREATE TABLE Doctor (
    doctor_id VARCHAR(255) NOT NULL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    specialization VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    postal_code VARCHAR(20),
    bio TEXT,
    profilePic LONGBLOB,
    date_of_birth VARCHAR(20),
    gender VARCHAR(20),
    date_added VARCHAR(20),
    date_updated VARCHAR(20),
    password VARCHAR(100)
);
ALTER TABLE Doctor ADD PRIMARY KEY (doctor_id);
CREATE TABLE appointmentTimeTable (
    date DATE,
    doctor_id VARCHAR(100),
    slot1 VARCHAR(50),
    slot2 VARCHAR(50),
    slot3 VARCHAR(50),
    slot4 VARCHAR(50),
    slot5 VARCHAR(50),
    slot6 VARCHAR(50),
    slot7 VARCHAR(50),
    slot8 VARCHAR(50),
    slot9 VARCHAR(50),
    slot10 VARCHAR(50),
    slot11 VARCHAR(50),
    slot12 VARCHAR(50),
    PRIMARY KEY (date, doctor_id)
);

CREATE TABLE Appointments (
    AppointmentID INT AUTO_INCREMENT PRIMARY KEY,
    patientId VARCHAR(100),
    doctor_id VARCHAR(100),
    AppointmentDate VARCHAR(100),
    appointmentSlot VARCHAR(100),
    StartTime VARCHAR(100),
    EndTime VARCHAR(100),
    AppointmentType VARCHAR(100),
    Status VARCHAR(50),
    CreatedOn VARCHAR(100),
    UpdatedOn VARCHAR(100),
    Notes TEXT,
    FOREIGN KEY (patientId) REFERENCES Patient(patientId),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);
ALTER TABLE Appointments
ADD HealthStatus TEXT,
ADD TestsToBeChecked TEXT,
ADD Medication TEXT;

CREATE TABLE Cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    patientId VARCHAR(100),
    products TEXT,
    added_at VARCHAR(50),
    FOREIGN KEY (patientId) REFERENCES Patient(patientId)
);

select * from cart where patientId=null;
CREATE TABLE CartOrders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    patientId VARCHAR(100),
    cart_id INT,
    total_amount DECIMAL(10, 2),
    order_status VARCHAR(20),
    created_at VARCHAR(50),
    FOREIGN KEY (patientId) REFERENCES Patient(patientId),
    FOREIGN KEY (cart_id) REFERENCES Cart(cart_id)
);

ALTER TABLE CartOrders
ADD products TEXT;
-----------


INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('john.doe','John', 'Doe', 'Cardiology', 'john.doe@gmail.com', '123-456-7890', '123 Main St', 'Houston', 'Texas', 'USA', '12345', 'Dr. John Doe specializes in cardiology.', NULL, '1975-05-15', 'Male', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('jane.smith','Jane', 'Smith', 'Pediatrics', 'jane.smith@gmail.com', '987-654-3210', '456 Oak St', 'Dallas', 'Texas', 'USA', '54321', 'Dr. Jane Smith specializes in pediatrics.', NULL, '1980-10-25', 'Female', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('michael.johnson','Michael', 'Johnson', 'Dermatology', 'michael.johnson@gmail.com', '456-789-0123', '789 Elm St', 'Austin', 'Texas', 'USA', '67890', 'Dr. Michael Johnson specializes in dermatology.', NULL, '1978-03-08', 'Male', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('emily.brown','Emily', 'Brown', 'Neurology', 'emily.brown@gmail.com', '321-654-0987', '321 Maple St', 'San Antonio', 'Texas', 'USA', '09876', 'Dr. Emily Brown specializes in neurology.', NULL, '1985-12-20', 'Female', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('david.martinez','David', 'Martinez', 'Orthopedics', 'david.martinez@gmail.com', '789-012-3456', '654 Pine St', 'Fort Worth', 'Texas', 'USA', '45678', 'Dr. David Martinez specializes in orthopedics.', NULL, '1970-09-05', 'Male', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('sarah.garcia','Sarah', 'Garcia', 'Oncology', 'sarah.garcia@gmail.com', '012-345-6789', '987 Cedar St', 'El Paso', 'Texas', 'USA', '23456', 'Dr. Sarah Garcia specializes in oncology.', NULL, '1982-07-18', 'Female', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('christopher.lopez','Christopher', 'Lopez', 'Gastroenterology', 'christopher.lopez@gmail.com', '345-678-9012', '741 Birch St', 'Arlington', 'Texas', 'USA', '34567', 'Dr. Christopher Lopez specializes in gastroenterology.', NULL, '1973-11-30', 'Male', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('amanda.hernandez','Amanda', 'Hernandez', 'Obstetrics and Gynecology', 'amanda.hernandez@gmail.com', '567-890-1234', '369 Walnut St', 'Corpus Christi', 'Texas', 'USA', '56789', 'Dr. Amanda Hernandez specializes in obstetrics and gynecology.', NULL, '1988-04-12', 'Female', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('kevin.young','Kevin', 'Young', 'Urology', 'kevin.young@gmail.com', '890-123-4567', '852 Pineapple St', 'Plano', 'Texas', 'USA', '67890', 'Dr. Kevin Young specializes in urology.', NULL, '1977-01-28', 'Male', NOW(), NOW(),'1234');

INSERT INTO Doctor (doctor_id,first_name, last_name, specialization, email, phone_number, address, city, state, country, postal_code, bio, profilePic, date_of_birth, gender, date_added, date_updated,password) 
VALUES ('jennifer.scott','Jennifer', 'Scott', 'Psychiatry', 'jennifer.scott@gmail.com', '234-567-8901', '963 Apple St', 'Lubbock', 'Texas', 'USA', '78901', 'Dr. Jennifer Scott specializes in psychiatry.', NULL, '1983-09-15', 'Female', NOW(), NOW(),'1234');
-----------------------------
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE, 'john.doe');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 1 DAY, 'john.doe');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 2 DAY, 'john.doe');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 3 DAY, 'john.doe');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 4 DAY, 'john.doe');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 5 DAY, 'john.doe');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 6 DAY, 'john.doe');
------------------------
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE, 'jane.smith');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 1 DAY, 'jane.smith');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 2 DAY, 'jane.smith');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 3 DAY, 'jane.smith');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 4 DAY, 'jane.smith');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 5 DAY, 'jane.smith');
INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE + INTERVAL 6 DAY, 'jane.smith');
-- INSERT INTO appointmentTimeTable (date, doctor_id) VALUES (CURRENT_DATE - INTERVAL 1 DAY, 'jane.smith');

select * from Patient;
select * from PatientAddress;
select * from InsuranceInfo;
select doctor_id from Doctor;
select count(*) from Doctor;
select * from appointmentTimeTable order by doctor_id;
select * from appointmentTimeTable where doctor_id = 'john.doe' and date = CURRENT_DATE;
select * from appointmentTimeTable where doctor_id = 'john.doe' and date < CURRENT_DATE;
#update appointmentTimeTable set  slot12 = 'pavangudla4' where date = '2024-04-02' and doctor_id='john.doe';
select * from Appointments where AppointmentDate = current_date and doctor_id = 'john.doe';
select * from Appointments where patientId = 'pavangudla4' and AppointmentDate;--  >= now();
select * from Appointments where patientId = 'pavangudla4' and AppointmentDate = '2024-04-02';--  >= now();
SELECT * FROM Appointments WHERE patientId = 'pavangudla4' and STR_TO_DATE(AppointmentDate, '%Y-%m-%d') < CURDATE();
desc cart;

--
INSERT INTO cart (patientId, products, added_at) VALUES ('pavangudla4', 'Product A, Product B', '2024-04-20');

UPDATE cart SET patientId = 'pavangudla4', 
    products = 'Product C, Product D',
    added_at = '2024-04-20'
WHERE cart_id = 1;
select * from cart;
select * from cartorders;
-- update cart set products = null where cart_id=1;
desc cartorders;