--drop schema if EXISTS pond_ms cascade;
--create schema pond_ms;
create schema foursquare;

drop table if exists foursquare.FOURSQUARE_KEYS cascade;

create table foursquare.FOURSQUARE_KEYS (id bigint not null, extuid varchar(255) not null, client_id varchar(255)
not null, client_secret varchar(255) not null, used_count bigint not null, max_usage bigint not null,
busy boolean not null, last_used_date timestamp not null, primary key (id));

alter table foursquare.FOURSQUARE_KEYS add constraint UK_tqlybenat1cfxkw5frk4cab8g  unique (extuid);
alter table foursquare.FOURSQUARE_KEYS add constraint UK_ml8fi3c1f6b3wp5raakfp8x3w  unique (client_id);
alter table foursquare.FOURSQUARE_KEYS add constraint UK_p79frw0xr9iexssshya2ynw54  unique (client_secret);