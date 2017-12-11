create database ocena_projektu;
use projekty; 


create table logowanie(
id_u int primary key auto_increment unique,
login varchar(50),
haslo varchar(50),
permission varchar(1)
);


create table kursant(
id_k int primary key auto_increment unique,
imie varchar(50) not null,
nazwisko varchar(50),
id_g varchar(30),
email varchar(30) not null unique,
telefon varchar(9),
gh_link varchar(50)
);

create table projekt (
id_p  int primary key auto_increment unique,
temat text,
opis text,
deadline date
);


create table grupa(
id_gr int primary key auto_increment unique,
nazwa_gr varchar(50),
id_p int,
FOREIGN KEY (id_p) REFERENCES projekt(id_p)
);


create table ocena(
id_o int primary key auto_increment,
id_p int,
id_k int,
data_od date,
ocena varchar(1),
FOREIGN KEY (id_p) REFERENCES projekt(id_p),
FOREIGN KEY (id_k) REFERENCES kursant(id_k)
);


