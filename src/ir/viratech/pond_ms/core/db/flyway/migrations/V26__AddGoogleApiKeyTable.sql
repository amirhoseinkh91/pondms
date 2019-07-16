--drop schema if EXISTS pond_ms cascade;
--create schema pond_ms;

drop table if exists pond_ms.Google_Api_Keys cascade;

create table pond_ms.Google_Api_Keys (id bigint not null, extuid varchar(255) not null, key varchar(255),
last_used_date timestamp, usedCounter bigint, busy boolean not null, primary key (id));

alter table pond_ms.Google_Api_Keys add constraint UK_5boqdx7uxt05hqieax0m490h9  unique (extuid);

alter table pond_ms.Google_Api_Keys add constraint UK_tibddl0vam50k8g1702u0dm2w  unique (key);