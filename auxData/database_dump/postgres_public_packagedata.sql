create table packagedata
(
    idpackage integer   not null,
    idvehicle varchar   not null,
    latitude  varchar   not null,
    longitude varchar   not null,
    timestamp timestamp not null,
    location  varchar   not null,
    idrow     serial
        constraint packagedata_pk
            primary key,
    constraint packagedata_pk_2
        unique (idpackage, timestamp)
);

alter table packagedata
    owner to postgres;

INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (1, 'A1', '6.5652445', '35.65324565', '2022-04-29 00:24:02.000000', 'Madrid', 2);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (2, 'A2', '5.653214', '2.3256523', '2022-07-30 00:24:41.000000', 'Valdepeñas', 4);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (1, 'A1', '6.5656565', '35.65656565', '2022-03-28 00:23:39.000000', 'Madrid', 1);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (2, 'A2', '5.235412', '5.2351265', '2022-06-25 00:24:22.000000', 'Valdepeñas', 3);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (5, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-09-30 00:24:41.000000', 'Madrid', 11);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (7, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 16:22:08.916554', 'Madrid', 25);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (7, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 17:13:17.893971', 'Madrid', 28);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (7, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 17:13:19.214569', 'Madrid', 29);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (99, 'TESTVEHICLE', 'TESTLATITUDE', 'TESTLONGITUDE', '2022-04-29 20:26:57.748875', 'TESTLOCATION', 33);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (99, 'TESTVEHICLE', 'TESTLATITUDE', 'TESTLONGITUDE', '2022-04-29 20:27:20.759455', 'TESTLOCATION', 34);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (1, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 18:44:17.186234', 'Madrid', 37);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (12, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 20:50:24.908000', 'Puertollano', 38);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (12, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 20:52:40.765809', 'Puertollano', 39);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (12, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 20:52:49.431827', 'Puertollano', 40);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (12, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 22:40:40.593853', 'Puertollano', 48);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (12, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 22:42:43.432118', 'Puertollano', 50);
INSERT INTO public.packagedata (idpackage, idvehicle, latitude, longitude, timestamp, location, idrow) VALUES (1, 'CR2564', '40.48725603806988', '-3.6789361594249685', '2022-04-29 22:47:35.392602', 'Madrid', 53);
