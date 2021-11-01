DROP database placement_management;
create database placement_management;
use placement_management;

create TABLE students
(
    RegisterNo      VARCHAR(9) PRIMARY KEY,
    Name            VARCHAR(40) NOT NULL,
    Email           VARCHAR(40) NOT NULL,
    Password        VARCHAR(40) NOT NULL,
    Cgpa            FLOAT       NOT NULL,
    PhoneNo         VARCHAR(10)    NOT NULL,
    PlacementStatus VARCHAR(20) NOT NULL DEFAULT 'NOT PLACED',
    PlacedIn        VARCHAR(40)
);

create TABLE recruiters
(
    recruiterId INT PRIMARY KEY AUTO_INCREMENT,
    Name        VARCHAR(40) NOT NULL,
    Role        VARCHAR(40) NOT NULL,
    Ctc         VARCHAR(20) NOT NULL,
    Duration    VARCHAR(20) NOT NULL,
    Location    VARCHAR(20) NOT NULL
);

create TABLE applications
(
    applicationId INT PRIMARY KEY AUTO_INCREMENT,
    studentId     VARCHAR(9) NOT NULL,
    recruiterId   INT     NOT NULL,
    status VARCHAR(10) NOT NULL ,
    FOREIGN KEY (studentId) REFERENCES students (RegisterNo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (recruiterId) REFERENCES recruiters (recruiterId) ON DELETE  CASCADE  ON UPDATE  CASCADE
);

create TABLE placement_officer
(
    userId       INT PRIMARY KEY,
    password VARCHAR(40) NOT NULL
)