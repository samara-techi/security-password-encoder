create database if not exists eazybytes_custom;

use eazybytes_custom;

--create table users(
--	username varchar(50) not null primary key,
--	password varchar(50) not null,
--	enabled boolean not null
--);
--
--create table authorities (
--	username varchar(50) not null,
--	authority varchar(50) not null,
--	constraint fk_authorities_users foreign key(username) references users(username)
--);
--
--insert into users
--values('happy', '12345', true);
--
--insert into authorities
--values('happy', 'write');

Create table customer (
	id bigint NOT NULL AUTO_INCREMENT,
	email varchar(45) NOT NULL,
	pwd varchar(200) NOT NULL,
	role varchar(45) NOT NULL,
	PRIMARY KEY (id)
);

insert into customer(email, pwd, role)
values
	('johndoe@example.com', '54321', 'admin');

commit;
