





    // drop table if exists
    drop table if exists patient CASCADE;

    //drop hibernate sequence if exists
    drop sequence if exists hibernate_sequence;

    //create hibernate sequence start from 1
    create sequence hibernate_sequence start with 1 increment by 1;

    // create doctor table
    create table patient (

        id bigint not null auto_increment,
        name varchar(255) not null,
        birthdate date not null,
        gender varchar(255) not null,
        primary key (id)

    );

    INSERT INTO patient(name, birthdate, gender)
    values (
               ' Patient A',
               '1990-5-12',
               'MALE'
           );

    INSERT INTO patient(name, birthdate, gender)
    values (
               'Second Patient',
               '1980-5-12',
               'FEMALE'
           );

    INSERT INTO patient(name, birthdate, gender)
    values (
               ' Patient B',
               '1990-5-12',
               'MALE'
           );

    INSERT INTO patient(name, birthdate, gender)
    values (
               ' Patient C',
               '1980-5-12',
               'FEMALE'
           );INSERT INTO patient(name, birthdate, gender)
             values (
                        'First Patient',
                        '1990-5-12',
                        'MALE'
                    );

    INSERT INTO patient(name, birthdate, gender)
    values (
               '  Patient D',
               '1980-5-12',
               'FEMALE'
           );INSERT INTO patient(name, birthdate, gender)
             values (
                        'First Patient',
                        '1990-5-12',
                        'MALE'
                    );

    INSERT INTO patient(name, birthdate, gender)
    values (
               ' Patient E',
               '1980-5-12',
               'FEMALE'
           );
