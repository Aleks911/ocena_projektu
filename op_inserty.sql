insert into logowanie values (1, 'kursant1', 'test', '1'); 
insert into logowanie values (2, 'admin', 'admin', '2'); 


#delete from kursant;
insert into kursant values (1, 'Adam', 'Adamski', 1 , 'kursant1@op.pl','600700321','https://github.com/Adamski'); 



insert into grupa values (null, 'D32017');

insert into projekt values  (null,'Projekt 1', 'opis testowy', '2017-12-23', 1);

insert into ocena values (null, 1, 1, null, null);


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