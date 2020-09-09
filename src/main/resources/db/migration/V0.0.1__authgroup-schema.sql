



//drop hibernate sequence if exists
    drop sequence if exists hibernate_sequence;

    //create hibernate sequence start from 1
    create sequence hibernate_sequence start with 1 increment by 70;

create table authgroups(
    id bigint auto_increment primary key ,
    username varchar(80) not null  ,
    authgroup varchar(190) not null
);


insert into authgroups(username, authgroup) VALUES ( 'user','ROLE_USER' );
insert into authgroups(username, authgroup) VALUES ( 'admin','ROLE_USER' );
insert into authgroups(username, authgroup) VALUES ( 'admin','ROLE_ADMIN' );


















