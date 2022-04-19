package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("FourthProject - work with PostgreSQL !!!");
        CREATE DATABASE fourthproject;
        CREATE TABLE course(
id INTEGER PRIMARY KEY,
name VARCHAR(30),
course_starts TIMESTAMP
);

CREATE TABLE student(
id INTEGER PRIMARY KEY,
name VARCHAR(30),
age INTEGER,
course_id INTEGER REFERENCES course(id)
);

INSERT INTO student(id, name, age, course_id)
VALUES (1, 'Sultan', 29, 1),
(2, 'Arlen', 20, 2),
(3, 'Kantemir', 32, 3);

INSERT INTO course(id, name, course_starts)
VALUES (1, 'English', '2022-11-10 13:00:00'),
(2, 'IT', '2022-10-01 13:00:00'),
(3, 'Java -5', '2022-04-04 13:00:00');

SELECT * FROM student;
SELECT * FROM course;


CREATE TABLE teachers(
id INTEGER PRIMARY KEY,
name VARCHAR(40),
inn VARCHAR(30) UNIQUE,
course_id INTEGER REFERENCES courseSubjects(id)
);

CREATE TABLE courseSubjects(
id INTEGER PRIMARY KEY,
name VARCHAR(40),
salary INTEGER
);

INSERT INTO teachers(id, name, inn, course_id)
VALUES (1, 'Muhammed Allanov', '1234', 1),
(2, 'Zamir Kubanychbekov', '12345', 2),
(3, 'Viktoria Kwestura', '123', 3);

INSERT INTO courseSubjects(id, name, salary)
VALUES (1, 'English', 1000),
(2, 'IT', 2000),
(3, 'Operating System', 1300);

SELECT * FROM teachers;
SELECT * FROM courseSubjects;


CREATE TABLE restaurant(
id SERIAL PRIMARY KEY,
position VARCHAR(40),
mobile VARCHAR(40),
employees_id INTEGER REFERENCES employees(id)
);

CREATE TABLE employees(
id SERIAL PRIMARY KEY,
name VARCHAR(30),
age INTEGER
);

INSERT INTO restaurant(position, mobile, employees_id)
VALUES ('Director', '+996702702702', 1),
('Manager', '+996555555555', 2),
('Waiter', '+996707345345', 3);

INSERT INTO employees(name, age)
VALUES ('Arlen Kurbanbaev', 29),
('Dastan Nazyrbekov', 27),
('Kamila Tadjieva', 23);

SELECT * FROM restaurant;
SELECT * FROM employees;


CREATE TABLE hospital(
id SERIAL PRIMARY KEY,
name_of_pills VARCHAR(30),
price INTEGER,
patients_id SERIAL REFERENCES patients(id)
);

CREATE TABLE patients(
id SERIAL PRIMARY KEY,
name VARCHAR(40),
age INTEGER,
illness VARCHAR(30)
);

INSERT INTO hospital(name_of_pills, price)
VALUES ('Aspirin', 40),
('Antacids', 50),
('Ibuprofen', 80);

INSERT INTO patients(name, age, illness)
VALUES ('Aijan', 19, 'Headaches'),
('Nurai', 18, 'Stomach'),
('Nursultan', 29, 'Tooth');

SELECT * FROM hospital;
SELECT * FROM patients;


CREATE TABLE person(
id SERIAL PRIMARY KEY,
name VARCHAR NOT NULL,
birth_date DATE NOT NULL,
phone_number BIGINT NOT NULL,
car_id SERIAL REFERENCES car(id)
);

CREATE TABLE car(
id SERIAL PRIMARY KEY,
brand VARCHAR NOT NULL,
model VARCHAR NOT NULL,
issue_year INT NOT NULL,
price VARCHAR NOT NULL
);

INSERT INTO person(name, birth_date, phone_number)
VALUES ('Sultan', '1997-12-12', +996222555666),
('Bakyt', '2000-01-29', +996777531118),
('Ulan', '1994-07-21', +996702609050);

INSERT INTO car(brand, model, issue_year, price)
VALUES ('BMW', 'X5', 2001, '5000 $'),
('Mercedes-Benz', '1:43 G', 2020, '10000 $'),
('Toyota', 'Camry-35', 2015, '20000 $');

SELECT * FROM car;
SELECT * FROM person;
    }
}
