#delete from kursant;
insert into kursant values (1, 'Adam', 'Adamski', 1 , 'kursant1@op.pl','600700321','https://github.com/Adamski'); 

insert into logowanie values (1, 'kursant1', 'test', '1', 1); 
insert into logowanie values (2, 'admin', 'admin', '2', null); 

insert into grupa values (null, 'D32017');
insert into grupa values (null, 'D42017');
insert into grupa values (null, 'D52017');

insert into kursant values (null, 'Adam', 'Adamski', 1 , 'kursant1@op.pl','600700321','Adamski1'); 
insert into kursant values (null, 'Adam', 'Adamski', 2 , 'kursant2@op.pl','600700321','Adamski2'); 
insert into kursant values (null, 'Adam', 'Adamski', 3 , 'kursant3@op.pl','600700321','Adamski3'); 


insert into logowanie values (null, 'kursant1', 'test', '1', 1); 
insert into logowanie values (null, 'kursant2', 'test', '1', 2); 
insert into logowanie values (null, 'kursant3', 'test', '1', 3); 
insert into logowanie values (null, 'admin', 'admin', '2', null); 

insert into projekt values  (null,'Projekt 1', 'opis testowy', '2017-12-21', 1);
insert into projekt values  (null,'Projekt 2', 'opis testowy', '2017-12-22', 2);
insert into projekt values  (null,'Projekt 3', 'opis testowy', '2017-12-23', 3);

#czy to można zrobić trigerem zeby do danej osoby przydzielał się projekt po dodaniu go do projektów
insert into ocena values (null, 1, 1, null, null);
insert into ocena values (null, 2, 2, null, null);
insert into ocena values (null, 3, 3, null, null);

select * from ocena_projektu;
select * from projekt;

SELECT 
        k.id_k,
        k.imie,
        k.nazwisko,
        p.id_p,
        p.temat,
        p.deadline,
        g.id_gr
    FROM
        projekt AS p
            JOIN
        grupa AS g ON (p.id_gr = g.id_gr)
            JOIN
        kursant AS k ON (g.id_gr = k.id_g);


        

select * from ocena_projektu;


UPDATE ocena SET data_od = '2013-12-01' WHERE id_p = 1;

select * from ocena;

select * from grupa;
select * from ocena_projektu_kursanta;