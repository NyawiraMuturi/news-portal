CREATE DATABASE news_portal;
\c news_portal

CREATE TABLE departments(
id SERIAL PRIMARY KEY,
nameofdepartment VARCHAR,
descrptofdepartment VARCHAR,
numberofemployees int
);

CREATE TABLE news(
id SERIAL PRIMARY KEY,
newstitle VARCHAR,
content VARCHAR
);

CREATE TABLE users (
id SERIAL PRIMARY KEY,
name VARCHAR,
position VARCHAR,
role VARCHAR,
iddept INT
);


CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;