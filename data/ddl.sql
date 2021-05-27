create table "user"
(
    user_id              serial primary key,
    username             varchar(20)  null,
    password             varchar(30)  null,
    email                varchar(80)  null,
    registration_date    timestamp    null,
    role                 varchar(100) null,
    gender               varchar(2)   null,
    password_change_date timestamp    null,
    registration_ip      varchar(80)  null
);

create table hospital
(
    hospital_id   serial primary key,
    hospital_name varchar(255) null,
    address       varchar(255) null
);

create table doctor
(
    doctor_id       serial primary key,
    hospital_id     int          not null,
    doctor_name     varchar(255) null,
    doctor_gender   varchar(255) null,
    doctor_birthday varchar(255) null,
    department      varchar(255) null,
    constraint doctor_hospital
        foreign key (hospital_id) references hospital (hospital_id)
);

create table medicine
(
    medicine_id   serial primary key,
    medicine_name varchar(255) null,
    manufacturer  varchar(255) null,
    introduction  varchar(255) null,
    type          varchar(255) null
);

create table patient
(
    patient_id       serial primary key,
    patient_name     varchar(255) not null,
    doctor_id        int          not null,
    hospital_id      int          not null,
    patient_gender   varchar(255) null,
    patient_birthday timestamp    null,
    onset_place      varchar(255) null,
    onset_date       timestamp    null,
    confirm_date     timestamp    null,
    status           varchar(100) null,
    is_doctor        int          null,
    constraint patient_doctor
        foreign key (doctor_id) references doctor (doctor_id)
            on delete cascade,
    constraint patient_hospital
        foreign key (hospital_id) references hospital (hospital_id)
            on delete cascade
);

create table prescription
(
    prescription_id   serial primary key,
    patient_id        int          null,
    medicine_id       int          null,
    dosage            varchar(255) null,
    usage             varchar(255) null,
    doctor_id         int          not null,
    prescription_date timestamp    null,
    constraint prescription_doctor
        foreign key (doctor_id) references doctor (doctor_id)
            on delete cascade,
    constraint prescription_medicine
        foreign key (medicine_id) references medicine (medicine_id)
            on delete cascade,
    constraint prescription_patient
        foreign key (patient_id) references patient (patient_id)
            on delete cascade
);

create table image
(
    image_id             serial primary key,
    patient_id           int          null,
    doctor_id            int          null,
    image_picture        varchar(255) null,
    conclusion           varchar(255) null,
    conclusion_doctor_id int          null,
    scanning_doctor_id   varchar(255) null,
    constraint image_doctor_id
        foreign key (doctor_id) references doctor (doctor_id),
    constraint image_patient_id
        foreign key (patient_id) references patient (patient_id)
);

create table diagnosis
(
    diagnosis_id serial primary key,
    patient_id   int          null,
    doctor_id    int          null,
    time         timestamp    null,
    symptom      varchar(255) null,
    temperature  varchar(255) null,
    nucleic_acid varchar(255) null,
    constraint diagnosis_doctor
        foreign key (doctor_id) references doctor (doctor_id)
            on delete cascade,
    constraint diagnosis_patient
        foreign key (patient_id) references patient (patient_id)
            on delete cascade
);

-- INDEX
create index main
    on doctor (doctor_id, hospital_id);

create index doctor_hospital
    on doctor (hospital_id);

create index doctor_id
    on doctor (doctor_id);

create index index_hospital
    on patient (patient_id, hospital_id);

create index patient_hospital
    on patient (hospital_id);

create index patient_doctor
    on patient (doctor_id);

create index index_patient
    on patient (patient_id);

create index prescription_doctor
    on prescription (doctor_id);

create index prescription_medicine
    on prescription (medicine_id);

create index prescription_patient
    on prescription (patient_id);

create index diagnosis_patient
    on diagnosis (patient_id);

create index diagnosis_doctor
    on diagnosis (doctor_id);
