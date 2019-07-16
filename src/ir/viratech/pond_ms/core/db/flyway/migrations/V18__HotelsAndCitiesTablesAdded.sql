create table pond_ms.Cities (id bigint not null, extuid varchar(255) not null, city_name varchar(255),
flight_code varchar(255), eghamat_name varchar(255), hotelyar_name varchar(255), hotelyar_code varchar(255),
primary key (id));

create table pond_ms.Hotels (id bigint not null, extuid varchar(255) not null, hotel_name varchar(255),
eghamat_name varchar(255), pintapin_name varchar(255), ariabooking_name varchar(255), hotelyar_name varchar(255),
hotelyar_code varchar(255), primary key (id));

alter table pond_ms.Cities add constraint UK_boflduiokaq55r76exmi2ibgy  unique (extuid);

alter table pond_ms.Hotels add constraint UK_37wadr83nxlmv4f6ngc6cdhn9  unique (extuid);
