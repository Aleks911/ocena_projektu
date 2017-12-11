insert into logowanie values (1, 'kursant1', 'test', '1'); 
insert into logowanie values (2, 'admin', 'admin', '2'); 



insert into kursant values (1, 'Adam', 'Adamski', '', 'kursant1@op.pl','600700321','https://github.com/Adamski'); 

insert into projekt values  ('1','Projekt 1', 'opis testowy', '2017-12-23');


create table projekt (
id_p  int primary key auto_increment unique,
temat text,
opis text,
deadline date
);