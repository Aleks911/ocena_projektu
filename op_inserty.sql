insert into logowanie values (1, 'kursant1', 'test', '1'); 
insert into logowanie values (2, 'admin', 'admin', '2'); 



insert into kursant values (1, 'Adam', 'Adamski', '', 'kursant1@op.pl','600700321','https://github.com/Adamski'); 

insert into projekt values  ('1','Projekt 1', 'opis testowy', '2017-12-23',null);
insert into projekt values  ('2','Projekt 2', 'opis testowy', '2017-12-24',null);

select * from projekt; 

select * from antural join 


id_p  int primary key auto_increment unique,
temat text,
opis text,
deadline date,
id_gr int,

id_k int primary key auto_increment unique,
imie varchar(50) not null,
nazwisko varchar(50),
id_g varchar(30),
email varchar(30) not null unique,
telefon varchar(9),
gh_link varchar(50)


SELECT 
    k.imie, k.nazwisko, k.id_g,  temat_g, deadline_g
FROM
    kursant
 JOIN
    grupa;