

CREATE TABLE users (
  id       INT          NOT NULL ,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL PRIMARY KEY,
  house_id int not null,
  room       INT          NOT NULL,
    enabled boolean NOT NULL);
	
	


ALTER TABLE users OWNER TO postgres;


CREATE TABLE houses (
house_id int primary key,
adress varchar(255) not null,
users varchar(255)	
);

ALTER TABLE houses OWNER TO postgres;

CREATE TABLE user_roles (
  user_id smallint NOT NULL,  
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_id),
  
 
  CONSTRAINT fk_username FOREIGN KEY (email) REFERENCES users (email));

ALTER TABLE user_roles OWNER TO postgres;

    ALTER TABLE ONLY users
    ADD CONSTRAINT fkhyk17jmcujmo1992pv7ibty3y  FOREIGN KEY (house_id) REFERENCES houses(house_id) ON DELETE CASCADE;
    
    ALTER TABLE ONLY houses
    ADD CONSTRAINT fkhyk17jmcujmo1992pv7ibty3y  FOREIGN KEY (users) REFERENCES users(email) ON DELETE CASCADE;
	
	
    
    INSERT INTO houses (id,adress) VALUES ('2','Timura Kizizakova 13');
 insert into houses(id,adress) values('1','Semenova 2');
 
INSERT INTO users(id,firstname,lastname,password,email,room,enabled) VALUES (1, 'mila','yovovich', '111', 'mila','3',true);
INSERT INTO users(id,firstname,lastname,password,email,room,enabled) VALUES (2, 'maya','yoich', '111', 'maya','4',true);
INSERT INTO users(id,firstname,lastname,password,email,room,enabled) VALUES (3, 'mila','yovovich', 'y', 'y@y','5',true);
INSERT INTO users(id,firstname,lastname,password,email,room,enabled) VALUES (4, 'mila','yovovich', '111', 'mi','6',true);

INSERT INTO user_roles (user_id, role)
VALUES ('1', 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES ('1', 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role)
VALUES ('3', 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES ('4', 'ROLE_MANAGER');


insert into counters(id,amount,rate,servicename) values ('1','240','3','water');
insert into counters(id,amount,rate,servicename) values ('2','14048','1.25','gas');
insert into counters(id,amount,rate,servicename) values ('3','345056','0.76','electricity');

insert into user_counter (user_id, counter_id) values ('3','1');
insert into user_counter (user_id, counter_id) values ('3','2');
insert into user_counter (user_id, counter_id) values ('3','3');
