--drop schema if EXISTS pond_ms cascade;
--create schema pond_ms;


alter table pond_ms.Hotels ADD iranhotelonline_name varchar(255);
alter table pond_ms.Hotels ADD iranhotelonline_code varchar(255);




