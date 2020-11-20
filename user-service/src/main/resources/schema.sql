CREATE TABLE USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  userid int not null,
  title varchar(255) NOT NULL,
  firstname varchar(100) NOT NULL,
  lastname varchar(100) NOT NULL,
  gender varchar(255) NOT NULL,
  street varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  postcode INT NOT NULL
);

