create table skill
(
    id numeric primary key,
    code varchar(255) not null
);

create table project
(
    id  numeric primary key,
    working_in_pairs_support bool not null,
    check_testing_support bool not null
);

CREATE TABLE sprint
(
    id numeric primary key,
    begin_date timestamp not null,
    end_date timestamp not null,
    project_id numeric references project(id)
);

create table person
(
    id numeric primary key,
    login varchar(255) not null,
    password varchar(255) not null,
    role_id varchar(255) not null
);

CREATE TABLE task
(
    id numeric primary key,
    title varchar(255) NOT NULL,
    description varchar(255) DEFAULT NULL,
    effort_hours numeric DEFAULT NULL,
    project_id numeric references  project(id),
    sprint_id numeric references sprint(id),
    person_id numeric references person(id)
);

create table meeting
(
    id numeric primary key,
    title varchar(255) not null,
    description varchar(255),
    cycle_type varchar(255) not null,
    start_time timestamp not null,
    end_time timestamp not null
);

create table meeting_participation
(
    id numeric primary key,
    meeting_id numeric references meeting(id),
    person_id numeric references person(id)
);
