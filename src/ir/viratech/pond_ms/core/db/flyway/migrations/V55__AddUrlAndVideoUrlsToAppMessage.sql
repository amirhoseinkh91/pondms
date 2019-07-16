alter table pond_ms.APP_MESSAGES add column videoUrl varchar(255);

create table pond_ms.APP_MESSAGE_URLS (id bigint not null, indexInAppMessage bigint, url varchar(255)
not null, appMessageId bigint, primary key (id));

alter table pond_ms.APP_MESSAGE_URLS add constraint FK_g00ac0qk6m4mabjtwhfk6bhvv foreign key (appMessageId)
references pond_ms.APP_MESSAGES;




