

    // drop table if exists
    drop table if exists doctor CASCADE;

    //drop hibernate sequence if exists
    drop sequence if exists hibernate_sequence;

    //create hibernate sequence start from 1
    create sequence hibernate_sequence start with 1 increment by 1;


    // create doctor table
    create table doctor (
        doctor_id bigint not null auto_increment,
        address varchar(255) not null,
        education varchar(255) not null,
        name varchar(255) not null,
        speciality varchar(255) not null,
        doctor_manager_doctor_id bigint, primary key (doctor_id)
    );

    // add drManager fk
    alter table doctor
        add constraint FKfpf8s1ay351bnhrek97cq3mah foreign key (doctor_manager_doctor_id)
            references doctor;

    // insert into table
    insert into doctor(address, education, name, speciality, doctor_manager_doctor_id) values (

                                  ' None ',
                                  ' None ',
                                  '  Manager Number  0',
                                  ' None ',
                                  null
                              );

    insert into doctor (address, education, name, speciality, doctor_manager_doctor_id) values (

                                  '--------------------',
                                  '-------------------',
                                  '  Manager Number  1',
                                  'eyes',
                                  null
                              );



    insert into doctor(address, education, name, speciality,doctor_manager_doctor_id)
    values (

               '--------------------',
               'Sub for  Manager --------  1',
               'Doctor Number 1',
               'eyes',
               1
           );




    insert into doctor(address, education, name, speciality,doctor_manager_doctor_id)
    values (

               '--------------------',
               'Sub_2 for  Manager --------  1',
               'Doctor Number 2',
               'eyes',
               1
           );

    insert into doctor(address, education, name, speciality,doctor_manager_doctor_id)
    values (

               '*******************',
               '******************',
               '  Manager Number  2',
               'Surgery',
               null
           );

    insert into doctor(address, education, name, speciality,doctor_manager_doctor_id)
    values (

               '--------------------',
               'Sub_3 for  Manager --------  1',
               'Doctor Number 3',
               'eyes',
               1
           );

    insert into doctor(address, education, name, speciality,doctor_manager_doctor_id)
    values (

               '*******************',
               'Sub_1 for Manager_2',
               'Doctor Number 4',
               'Surgery',
               4
           );
