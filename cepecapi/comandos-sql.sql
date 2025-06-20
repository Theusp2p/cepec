/*Não definitiva*/
create table study (
   id serial primary key,
   code varchar(20) not null,
   title varchar(50) not null,
   phase varchar(50) not null,
   sponsor varchar(50) not null,
   type_study varchar(50) not null,
   objective varchar(255),
   start_date timestamp,
   end_date timestamp,
   status varchar(15) not null,
   main_responsible varchar(80),
   email_contact varchar(80),
   phone_contact varchar(20),
   protocol_description varchar(100),
   observations varchar(500)
);

/*Não definitiva*/
create table participant (
     id serial primary key,
     code varchar(20) not null,
     name varchar(80) not null ,
     cpf varchar(15) not null,
     email varchar(80) not null,
     phone varchar(20) not null
);
/*Não definitiva*/
create table study_participant (
    study_id bigint not null,
    participant_id bigint not null,
    primary key (study_id, participant_id),
    foreign key (study_id) references study(id),
    foreign key (participant_id) references participant(id)
);