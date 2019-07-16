create table pond_ms.REVIEW_VOTES (id bigint not null, extuid varchar(255) not null, vote bigint not null,
date timestamp not null, userId bigint not null, reviewId bigint not null, primary key (id));

alter table pond_ms.REVIEW_VOTES add constraint UK_ReviewVote_review_user  unique (userId, reviewId);
alter table pond_ms.REVIEW_VOTES add constraint UK_kc8764l0t8tggndhpy3wcptxd  unique (extuid);

alter table pond_ms.REVIEW_VOTES add constraint FK_dnvpstilwlgi9onexfcp32vtg foreign key (userId) references
pond_ms.USERS;
alter table pond_ms.REVIEW_VOTES add constraint FK_gocs1vsmyhk1n4jxsyck6ijgo foreign key (reviewId) references
pond_ms.REVIEWS;