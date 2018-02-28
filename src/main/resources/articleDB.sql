CREATE DATABASE IF NOT EXISTS articleDB;
USE articleDB;

CREATE TABLE IF NOT EXISTS articles (
    article_id bigint(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(200) NOT NULL,
    category varchar(100) NOT NULL
) ENGINE=InnoDB;

INSERT INTO articles (title, category) VALUES
    ('Java Streams', 'Java'),
    ('Spring Boot Hibernate', 'Spring Boot'),
    ('Java 8 Lambda Expression Tutorial', 'Java 8');