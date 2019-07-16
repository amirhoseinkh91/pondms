create table pond_ms.CUSTOMERS (id bigint not null, extuid varchar(255) not null, userId bigint not null,
phoneNumber varchar(255) not null, email varchar(255), primary key (id));

alter table pond_ms.CUSTOMERS add constraint UK_b0l7uh6btfmru3cidnymr8bcn  unique (extuid);
alter table pond_ms.CUSTOMERS add constraint UK_7xy7ofee1qxy9jj6n9eyx9p6u  unique (userId);
alter table pond_ms.CUSTOMERS add constraint UK_6a0gg9o8towa6u579k9kljagu  unique (phoneNumber);

alter table pond_ms.CUSTOMERS add constraint FK_7xy7ofee1qxy9jj6n9eyx9p6u foreign key (userId) references
pond_ms.USERS;

