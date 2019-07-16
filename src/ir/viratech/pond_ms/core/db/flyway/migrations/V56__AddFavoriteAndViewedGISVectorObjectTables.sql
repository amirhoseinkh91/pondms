create table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS (id bigint not null, extuid varchar(255) not
null, customerId bigint not null, gisVectorObjectId bigint not null, primary key (id));
create table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS (id bigint not null, extuid varchar(255) not null,
customerId bigint not null, gisVectorObjectId bigint not null, viewDate timestamp not null, primary key
(id));

alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS add constraint UK_i9b4o0e53li027913yh9o3ecy
unique (extuid);
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS add constraint UK_ob15ravi01ujj01i15na20tc8  unique
(extuid);


alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS add constraint FK_k0s1j4trgns3cvbph4nik8b7y foreign
key (customerId) references pond_ms.CUSTOMERS;
alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS add constraint FK_7mq30439hmyagqgfn4j6wvq2e foreign
key (gisVectorObjectId) references pond_ms.GIS_VECTOR_OBJECTS;
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS add constraint FK_5rspt1s8n0gpy44pb05871l9a foreign
key (customerId) references pond_ms.CUSTOMERS;
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS add constraint FK_637yv69jbavdwa45bpikpqxh0 foreign
key (gisVectorObjectId) references pond_ms.GIS_VECTOR_OBJECTS;