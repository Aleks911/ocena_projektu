#drop database ocena_projektu;

create database ocena_projektu;
use ocena_projektu;

create table kursant(
id_k int primary key auto_increment unique,
imie varchar(50) not null,
nazwisko varchar(50),
id_g varchar(30),
email varchar(30) not null unique,
telefon varchar(9),
gh_link varchar(50)
);


create table logowanie(
id_u int primary key auto_increment unique,
login varchar(50),
haslo varchar(50),
permission varchar(2),
id_k int,
CONSTRAINT FK_id_k FOREIGN KEY (id_k)
        REFERENCES kursant (id_k)
        ON UPDATE CASCADE ON DELETE CASCADE
);




create table grupa(
id_gr int primary key auto_increment unique,
nazwa_gr varchar(50)
);

create table projekt (
id_p  int primary key auto_increment unique,
temat text,
opis text,
deadline date,
id_gr int,
FOREIGN KEY (id_gr) REFERENCES grupa(id_gr)
);



create table ocena(
id_o int primary key auto_increment,
id_p int,
id_k int,
data_od date,
ocena varchar(2),
FOREIGN KEY (id_p) REFERENCES projekt(id_p),
CONSTRAINT FK_id_k FOREIGN KEY (id_k)
        REFERENCES kursant (id_k)
        ON UPDATE CASCADE ON DELETE CASCADE
FOREIGN KEY (id_k) REFERENCES kursant(id_k) ON UPDATE CASCADE ON DELETE CASCADE
);

create view ocena_projektu as
SELECT 
        k.id_k,
        k.imie,
        k.nazwisko,
        p.id_p,
        p.temat,
        p.deadline,
        g.id_gr,
        o.data_od,
        o.ocena
    FROM
        projekt AS p
            JOIN
        grupa AS g ON (p.id_gr = g.id_gr)
            JOIN
        kursant AS k ON (g.id_gr = k.id_g)
			JOIN
        ocena AS o ON (k.id_k = o.id_k)
        ;

select * from ocena_projektu;



create view ocena_projektu_kursanta as
SELECT 
		k.id_k,
        p.id_p,
        p.temat,
        p.opis,
        p.deadline,
        g.id_gr,
        o.data_od,
        o.ocena
    FROM
        projekt AS p
            JOIN
        grupa AS g ON (p.id_gr = g.id_gr)
            JOIN
        kursant AS k ON (g.id_gr = k.id_g)
			JOIN
        ocena AS o ON (k.id_k = o.id_k)
        ;


create trigger logowanie
after insert on kursant
for each row
insert into logowanie set id_k = new.id_k, login = new.gh_link, permission='1', haslo = '123';

#drop trigger projekt;

#create trigger projekt
#after insert on projekt
#for each row
#insert into ocena set id_k = (select id_k from kursant where id_g = (select id_gr from projekt where id_p = new.id_p)), id_p = new.id_p;