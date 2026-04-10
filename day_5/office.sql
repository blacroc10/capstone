-- create database office;
-- use office;

-- create table department with dept_id, dept_name; [(201,202,203,204,205), (hr, finance, operations, sales, it)]
-- create table project with proj_id, proj_name, dept_id(from department table); 
-- [(301 to 310), (hiring, event(part of hr, 201, 201), audit(part of finance, 202), urban areas, semi urban (part of operations, 203, 203), social media, sales (part of sales, 204, 204), fe, be, ds(part of it, 205, 205, 205)]
-- create employee emp_id, emp_name, mgr_id, dept_id(from department table);
-- [(401-420), (AAA, BBB, CCC... till TTT), (501, 502, 504, 501, 503, 504, 505, 501, 502, 501, 506, 506, 501, 503, 504, 505, 501, 506, 502, 505), (201, 201, 201, 202, 202, 202, 202, 203, 203, 203, 203, 203, 203, 204, 204, 204, 204, 205, 205, 205, 205)]

CREATE TABLE department (
    dept_id INTEGER PRIMARY KEY,
    dept_name TEXT
);

CREATE TABLE project (
    proj_id INTEGER PRIMARY KEY,
    proj_name TEXT,
    dept_id INTEGER,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

CREATE TABLE employee (
    emp_id INTEGER PRIMARY KEY,
    emp_name TEXT,
    mgr_id INTEGER,
    dept_id INTEGER,
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

INSERT INTO department VALUES (201, 'hr'), (202, 'finance'), (203, 'operations'), (204, 'sales'), (205, 'it');

INSERT INTO project VALUES 
(301, 'hiring', 201),
(302, 'event', 201),
(303, 'audit', 202),
(304, 'urban areas', 203),
(305, 'semi urban', 203),
(306, 'social media', 204),
(307, 'sales', 204),
(308, 'fe', 205),
(309, 'be', 205),
(310, 'ds', 205);

INSERT INTO employee VALUES 
(401, 'AAA', 501, 201),
(402, 'BBB', 502, 201),
(403, 'CCC', 504, 201),
(404, 'DDD', 501, 202),
(405, 'EEE', 503, 202),
(406, 'FFF', 504, 202),
(407, 'GGG', 505, 202),
(408, 'HHH', 501, 203),
(409, 'III', 502, 203),
(410, 'JJJ', 501, 203),
(411, 'KKK', 506, 203),
(412, 'LLL', 506, 203),
(413, 'MMM', 501, 203),
(414, 'NNN', 503, 204),
(415, 'OOO', 504, 204),
(416, 'PPP', 505, 204),
(417, 'QQQ', 501, 204),
(418, 'RRR', 506, 205),
(419, 'SSS', 502, 205),
(420, 'TTT', 505, 205);

SELECT * FROM department;
SELECT * FROM project; 
SELECT * FROM employee;
