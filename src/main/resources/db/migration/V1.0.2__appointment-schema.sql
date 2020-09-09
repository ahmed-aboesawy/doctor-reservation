





    // drop table if exists
    drop table if exists appointment CASCADE;

    //drop hibernate sequence if exists
    drop sequence if exists hibernate_sequence;

    //create hibernate sequence start from 1
    create sequence hibernate_sequence start with 1 increment by 1;

    // create doctor table
    create table appointment (

                                 id bigint not null auto_increment,
                                 date date not null,
                                 doctor_doctor_id bigint,
                                 patient_id bigint,

                                 primary key (id)

    );

    // add doctor fk
    alter table appointment add constraint FKe2h5w13mux4dqv9ef26idj12e
        foreign key (doctor_doctor_id) references doctor;

    // add patient fk
    alter table appointment add constraint FK4apif2ewfyf14077ichee8g06
        foreign key (patient_id) references patient;


    insert into appointment(date, doctor_doctor_id, patient_id)
    VALUES (
               '2019-12-6',
               1,
               1
           );

    insert into appointment(date, doctor_doctor_id, patient_id)
    VALUES (
               '2019-12-6',
               1,
               3
           );

    insert into appointment(date, doctor_doctor_id, patient_id)
    VALUES (
               '2019-12-7',
               2,
               5
           );

    insert into appointment(date, doctor_doctor_id, patient_id)
    VALUES (
               '2019-12-8',
               3,
               4
           );

    insert into appointment(date, doctor_doctor_id, patient_id)
    VALUES (
               '2019-12-8',
               1,
               2
           );
































