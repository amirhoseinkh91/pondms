
create table pond_ms.APP_MESSAGES (id bigint not null, extuid varchar(255) not null, title varchar(255)
not null, message text not null, creationDate date not null, expirationDate date, enabled boolean not
null, primary key (id));

create table pond_ms.APP_MESSAGES_IMAGES (app_message_id bigint not null, imagefile_id bigint not null,
primary key (app_message_id, imagefile_id));

ALTER table pond_ms.REVIEWS ADD COLUMN lastModifiedDate date;

UPDATE pond_ms.REVIEWS SET lastModifiedDate = creationDate;

ALTER TABLE pond_ms.REVIEWS ALTER COLUMN lastModifiedDate SET NOT NULL;

alter table pond_ms.APP_MESSAGES_IMAGES add constraint UK_84ljyb5kl1ge4l5pv8fcfpc5d  unique (imagefile_id);

alter table pond_ms.APP_MESSAGES add constraint UK_8gtvpx56ajm58b71qxy2yq6bl  unique (extuid);

alter table pond_ms.APP_MESSAGES_IMAGES add constraint FK_84ljyb5kl1ge4l5pv8fcfpc5d foreign key (imagefile_id)
references pond_ms.ABSTRACT_FILES;
alter table pond_ms.APP_MESSAGES_IMAGES add constraint FK_m17lf2yh13l0aafxt7ydvym9h foreign key (app_message_id)
references pond_ms.APP_MESSAGES;