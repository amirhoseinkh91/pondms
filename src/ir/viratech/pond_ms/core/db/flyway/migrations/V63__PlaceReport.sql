create table pond_ms.PLACE_REPORT
(
  id           bigint       not null,
  extuid       varchar(255) not null,
  title        varchar(255) not null,
  message      text         not null,
  creationDate timestamp    not null,
  primary key (id)
);