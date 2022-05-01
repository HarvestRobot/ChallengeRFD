create table packageassignments
(
    idpackage integer not null
        constraint packageassignments_pk_2
            unique,
    idvehicle varchar not null,
    idrow     serial
        constraint packageassignments_pk
            primary key
);

alter table packageassignments
    owner to postgres;

create unique index packageassignments_idrow_uindex
    on packageassignments (idrow);

INSERT INTO public.packageassignments (idpackage, idvehicle, idrow) VALUES (2, 'A2', 2);
INSERT INTO public.packageassignments (idpackage, idvehicle, idrow) VALUES (5, 'CR2564', 10);
INSERT INTO public.packageassignments (idpackage, idvehicle, idrow) VALUES (8, 'CR2564', 27);
INSERT INTO public.packageassignments (idpackage, idvehicle, idrow) VALUES (11, 'CR2564', 44);
INSERT INTO public.packageassignments (idpackage, idvehicle, idrow) VALUES (1, 'CR25434', 56);
