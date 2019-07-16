
create table pond_ms.REPLY_REVIEWS (id bigint not null, extuid varchar(255) not null, position varchar(255)
not null, creationDate date not null, text text not null, confirmed boolean not null, user_id bigint,
review_id bigint, idx bigint, primary key (id));
create table pond_ms.REVIEWS (id bigint not null, extuid varchar(255) not null, title varchar(255) not
null, rate bigint not null, text text not null, creationDate date not null, user_id bigint, visitedDate
date not null, typeOfVisit varchar(255) not null, confirmed boolean not null, deleted boolean not null,
vector_object_id bigint, primary key (id));

alter table pond_ms.REPLY_REVIEWS add constraint UK_afaakko0jhc2ig9koy5q1k7k0  unique (extuid);
alter table pond_ms.REVIEWS add constraint UK_fnp0ctut45l6xja05ehfg7kwg  unique (extuid);

alter table pond_ms.REPLY_REVIEWS add constraint FK_prub87ej8a6iebp24vnh6irtg foreign key (user_id) references
org_chart.USERS;
alter table pond_ms.REPLY_REVIEWS add constraint FK_au1xdc7ax39qtqivsxwh97894 foreign key (review_id)
references pond_ms.REVIEWS;
alter table pond_ms.REVIEWS add constraint FK_ih30juidmhorasfjses3xutos foreign key (user_id) references
org_chart.USERS;
alter table pond_ms.REVIEWS add constraint FK_8vyohrop8sk7lw4b10g6ys3yc foreign key (vector_object_id)
references pond_ms.GIS_VECTOR_OBJECTS;