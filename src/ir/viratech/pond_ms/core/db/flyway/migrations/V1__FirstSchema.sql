--drop schema if EXISTS pond_ms cascade;
--create schema pond_ms;


create table pond_ms.ABSTRACT_FILES (id bigint not null, hashCodeStr varchar(255) not null, primary key
(id));
create table pond_ms.CONFIG_ENTRIES (id bigint not null, extuid varchar(255) not null, title varchar(255),
configKey varchar(255) not null, configValue varchar(255), primary key (id));
create table pond_ms.DATA_FILES (id bigint not null, extuid varchar(255) not null, abstract_file bigint
not null, dataReference varchar(255), data_collection_date timestamp, layer_id bigint, idx bigint, primary
key (id));
create table pond_ms.FILE_CONTENTS (id bigint not null, legacy_data bytea, primary key (id));
create table pond_ms.FILE_CONTENTS_FILE_SYSTEM (fileContentId bigint not null, fsName varchar(255) not
null, editCounter bigint not null, primary key (fileContentId));
create table pond_ms.GISMAPS (id bigint not null, extuid varchar(255) not null, title varchar(255) not
null, latin_title varchar(255), description varchar(255), creation_date timestamp not null, bounding_box
GEOMETRY, center GEOMETRY, min_zoom bigint default 12, max_zoom bigint default 16, default_zoom bigint
default 14, organization_id bigint not null, primary key (id));
create table pond_ms.GIS_VECTOR_OBJECTS (id bigint not null, extuid varchar(255) not null, name varchar(255)
not null, creation_date timestamp not null, provider varchar(255), formUID varchar(255), layer_id bigint
not null, primary key (id));
create table pond_ms.LAYER (id bigint not null, extuid varchar(255) not null, name varchar(255) not null,
description varchar(255), creation_date timestamp not null, pondRelated boolean default false, parent_id
bigint, index_in_parent bigint, map_id bigint not null, index_in_gismap bigint, secret boolean default
false, parent_map_id bigint, primary key (id));
create table pond_ms.LEAF_LAYERS (layer_id bigint not null, primary key (layer_id));
create table pond_ms.LINE_OBJECTS (vector_object_id bigint not null, line geometry(LineString,4326), primary
key (vector_object_id));
create table pond_ms.NATIVE_FILES (fileId bigint not null, fName varchar(255) not null, fileSize bigint
not null, creationDate timestamp not null, modificationDate timestamp not null, contentType varchar(255)
not null, primary key (fileId));
create table pond_ms.PARENT_LAYER (layer_id bigint not null, primary key (layer_id));
create table pond_ms.POINT_OBJECTS (vector_object_id bigint not null, point geometry(Point,4326), primary
key (vector_object_id));
create table pond_ms.POLYGON_OBJECTS (vector_object_id bigint not null, polygon geometry(Polygon,4326),
primary key (vector_object_id));
create table pond_ms.PONDS (id bigint not null, extuid varchar(255) not null, title varchar(255) not null,
layer bigint not null, descriptiveFormUID_public varchar(255), tabularFormUID_public varchar(255), libraryFormUID_public
varchar(255), galleryFormUID_public varchar(255), universalMapFormUID_public varchar(255), descriptiveFormUID_secret
varchar(255), tabularFormUID_secret varchar(255), libraryFormUID_secret varchar(255), galleryFormUID_secret
varchar(255), universalMapFormUID_secret varchar(255), primary key (id));
create table pond_ms.RASTER_LAYERS (layer_id bigint not null, primary key (layer_id));
create table pond_ms.VECTOR_LAYER (layer_id bigint not null, formSchemaKey varchar(255), vectorObjectsType
varchar(255), primary key (layer_id));
alter table pond_ms.ABSTRACT_FILES add constraint UK_hyts6q6q94d0nh1imdiqko4iq  unique (hashCodeStr);
alter table pond_ms.CONFIG_ENTRIES add constraint UK_j5sp8e4sck4to17j34flk22xl  unique (extuid);
alter table pond_ms.CONFIG_ENTRIES add constraint UK_nmnju5x1xolso09rvh847n73o  unique (configKey);
alter table pond_ms.DATA_FILES add constraint UK_igvgvtqwms9ixj7reimts9myo  unique (extuid);
alter table pond_ms.DATA_FILES add constraint UK_clhklmyhdfsjqc396j5e5k38m  unique (abstract_file);
alter table pond_ms.FILE_CONTENTS_FILE_SYSTEM add constraint UK_l49a2k554mr496wk60sp79db7  unique (fsName);
alter table pond_ms.GISMAPS add constraint UK_37ioud7r9u80rfcb12vw54uha  unique (extuid);
alter table pond_ms.GISMAPS add constraint UK_149mrpipvd4s514idbrfybiib  unique (organization_id);
alter table pond_ms.GIS_VECTOR_OBJECTS add constraint UK_tdlipwq0lu9tqsejkouuwe617  unique (extuid);
alter table pond_ms.LAYER add constraint UK_r8vtc0k2wr0s3twaoviu1b1cb  unique (extuid);
alter table pond_ms.PONDS add constraint UK_2k5scjubk9nwom2qyyao7vuyj  unique (extuid);
alter table pond_ms.PONDS add constraint UK_b2sdfq9sxf3pyaw7fhyrxfl5t  unique (layer);
alter table pond_ms.DATA_FILES add constraint FK_clhklmyhdfsjqc396j5e5k38m foreign key (abstract_file)
references pond_ms.ABSTRACT_FILES;
alter table pond_ms.DATA_FILES add constraint FK_j6x72u81psdw2vn8k90ktduth foreign key (layer_id) references
pond_ms.LEAF_LAYERS;
alter table pond_ms.FILE_CONTENTS add constraint FK_q4x58sdyuy2t323yx96foy9ht foreign key (id) references
pond_ms.NATIVE_FILES;
alter table pond_ms.FILE_CONTENTS_FILE_SYSTEM add constraint FK_a4cy1gj2msjqbyxwkfk49u9ex foreign key
(fileContentId) references pond_ms.FILE_CONTENTS;
alter table pond_ms.GISMAPS add constraint FK_149mrpipvd4s514idbrfybiib foreign key (organization_id)
references org_chart.ORGANIZATIONS;
alter table pond_ms.GIS_VECTOR_OBJECTS add constraint FK_eraewk7yyphei0t4m0ml3b2ok foreign key (layer_id)
references pond_ms.VECTOR_LAYER;
alter table pond_ms.LAYER add constraint FK_c2i87m565u0tf88ti4myko6m2 foreign key (parent_id) references
pond_ms.PARENT_LAYER;
alter table pond_ms.LAYER add constraint FK_s2n8qnu13iimuc0k50x0ghinv foreign key (map_id) references
pond_ms.GISMAPS;
alter table pond_ms.LAYER add constraint FK_66t4mfbiliucwhklf0wf1jkwk foreign key (parent_map_id) references
pond_ms.GISMAPS;
alter table pond_ms.LEAF_LAYERS add constraint FK_rcx8kbi1svp9xp579yrinfqrv foreign key (layer_id) references
pond_ms.LAYER;
alter table pond_ms.LINE_OBJECTS add constraint FK_c3mkf3t8yhodeom2m20ou7uid foreign key (vector_object_id)
references pond_ms.GIS_VECTOR_OBJECTS;
alter table pond_ms.NATIVE_FILES add constraint FK_ljbwgjx4xtwyca9ca4rtg57q4 foreign key (fileId) references
pond_ms.ABSTRACT_FILES;
alter table pond_ms.PARENT_LAYER add constraint FK_kdo9pfsmeoysyn2ri2xctts4o foreign key (layer_id) references
pond_ms.LAYER;
alter table pond_ms.POINT_OBJECTS add constraint FK_iugjir271r0xefdjijos2s8ai foreign key (vector_object_id)
references pond_ms.GIS_VECTOR_OBJECTS;
alter table pond_ms.POLYGON_OBJECTS add constraint FK_r1l850in6rtiac4f6btv0ffog foreign key (vector_object_id)
references pond_ms.GIS_VECTOR_OBJECTS;
alter table pond_ms.PONDS add constraint FK_b2sdfq9sxf3pyaw7fhyrxfl5t foreign key (layer) references pond_ms.PARENT_LAYER;
alter table pond_ms.RASTER_LAYERS add constraint FK_cax1gmobr3k0ud29r8hagb691 foreign key (layer_id) references
pond_ms.LEAF_LAYERS;
alter table pond_ms.VECTOR_LAYER add constraint FK_2obxx3wtbxdvicsakd7ipycj9 foreign key (layer_id) references
pond_ms.LEAF_LAYERS;
