CREATE TABLE employeesAge (
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(50),
    age INT
);

INSERT INTO employeesAge (employeeName, age) VALUES
('Кирилл', 18),
('Саша', 20),
('Катя', 25);

CREATE TABLE departmentSalary (
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(50),
    departmentName VARCHAR(50),
    salary INT
);

INSERT INTO departmentSalary (employeeName, departmentName, salary) VALUES
('Кирилл', 'IT', 30000),
('Иван', 'IT', 20000),
('Маша', 'HR', 40000);

CREATE TABLE departmentEmployee (
    id SERIAL PRIMARY KEY,
    employeeName VARCHAR(50),
    departmentId INT
);

INSERT INTO departmentEmployee (employeeName, departmentId) VALUES
('Кирилл', 1),
('Иван', 1),
('Маша', 2);

CREATE TABLE departmentLocation (
    departmentId INT PRIMARY KEY,
    departmentName VARCHAR(50),
    location VARCHAR(50)
);

INSERT INTO departmentLocation (departmentId, departmentName, location) VALUES
(1, 'IT', 'Саратов'),
(2, 'HR', 'Москва');
