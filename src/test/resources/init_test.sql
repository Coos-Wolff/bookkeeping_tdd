DROP TABLE user IF EXISTS;

CREATE TABLE user (
  id INT(11) NOT NULL ,
  first_name VARCHAR (255) ,
  last_name VARCHAR (255) ,
  date_of_birth DATE NOT NULL ,
  nickname VARCHAR (255) NOT NULL ,
  email VARCHAR (255) NOT NULL ,
  username VARCHAR (255) NOT NULL ,
  password VARCHAR (255) NOT NULL ,
  PRIMARY KEY (id)
);

DROP TABLE account IF EXISTS;

CREATE TABLE account (
  id INT(11) NOT NULL ,
  user_id INT(11) NOT NULL ,
  account_number VARCHAR (60) NOT NULL ,
  balance DECIMAL NOT NULL ,
  PRIMARY KEY (id)
);