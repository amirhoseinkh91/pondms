create table pond_ms.CATEGORY (id bigint not null, extuid varchar(255) not null, name varchar(255) not
null, parent_id bigint, index_in_parent bigint, primary key (id));
create table pond_ms.LEAF_CATEGORY (category_id bigint not null, timeSeriesValueType varchar(255) not
null, primary key (category_id));
create table pond_ms.PARENT_CATEGORY (category_id bigint not null, primary key (category_id));
create table pond_ms.ROOT_CATEGORY (category_id bigint not null, group_id bigint, pond_id bigint, object_id
bigint, dataFile bigint not null, primary key (category_id));
create table pond_ms.TIME_SERIES_DATE_VALUE_PAIR (id bigint not null, extuid varchar(255) not null, submissionTime bigint not null, timeSeriValue varchar(255), category_id
bigint, primary key (id));
create table pond_ms.TIME_SERIES_GROUP (id bigint not null, extuid varchar(255) not null, name varchar(255)
not null, description varchar(255), primary key (id));
alter table pond_ms.CATEGORY add constraint UK_iuo1cop4rb13xf7f2vdqgvn9v  unique (extuid);
alter table pond_ms.TIME_SERIES_DATE_VALUE_PAIR add constraint UK_pyyf6oebbh10wco8ydwdmrwhc  unique (extuid);
alter table pond_ms.TIME_SERIES_GROUP add constraint UK_lyi1ieuygmwu06n61wjbdi830  unique (extuid);
alter table pond_ms.CATEGORY add constraint FK_i7fbju65h4h6e5e1d9ell8alr foreign key (parent_id) references
pond_ms.PARENT_CATEGORY;
alter table pond_ms.LEAF_CATEGORY add constraint FK_sf5xl98klj19lq0e5g1ian6ox foreign key (category_id)
references pond_ms.CATEGORY;
alter table pond_ms.PARENT_CATEGORY add constraint FK_qa6a4jb53wlx72guq5w5beu5q foreign key (category_id)
references pond_ms.CATEGORY;
alter table pond_ms.ROOT_CATEGORY add constraint FK_rik5i66y46saykoabb673wxqd foreign key (category_id)
references pond_ms.PARENT_CATEGORY;
alter table pond_ms.ROOT_CATEGORY add constraint FK_otib3mom7jp5eifn1g2b2950m foreign key (group_id) references
pond_ms.TIME_SERIES_GROUP;
alter table pond_ms.ROOT_CATEGORY add constraint FK_90s6owemc5s49h8y2tntsori5 foreign key (object_id)
references pond_ms.GIS_VECTOR_OBJECTS;
alter table pond_ms.ROOT_CATEGORY add constraint FK_fh6xhsbnrdlrtw31eme07e6x8 foreign key (pond_id) references
pond_ms.PONDS;
alter table pond_ms.TIME_SERIES_DATE_VALUE_PAIR add constraint FK_q4vdh6febhy4i2f2chyqciri0 foreign key
(category_id) references pond_ms.LEAF_CATEGORY;
alter table pond_ms.ROOT_CATEGORY add constraint UK_3l0jde07o9ef1droguin4qfyv  unique (dataFile);
alter table pond_ms.ROOT_CATEGORY add constraint FK_3l0jde07o9ef1droguin4qfyv foreign key (dataFile) references
pond_ms.DATA_FILES;

