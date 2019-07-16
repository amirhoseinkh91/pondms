alter table commons_cm.ENTITY_TYPES drop constraint FK_eohgx0gpynwgov4qsk5680qob
alter table commons_cm.ENTITY_TYPE_SNAPSHOTS drop constraint FK_iwhpy0mr84yfb154qd8cu95v8
alter table commons_cm.TOPICS drop constraint FK_o5qe2s2wkqrtgs8sr0ooutmmh
alter table pond_ms.APP_MESSAGES_IMAGES drop constraint FK_84ljyb5kl1ge4l5pv8fcfpc5d
alter table pond_ms.APP_MESSAGES_IMAGES drop constraint FK_m17lf2yh13l0aafxt7ydvym9h
alter table pond_ms.APP_MESSAGE_URLS drop constraint FK_g00ac0qk6m4mabjtwhfk6bhvv
alter table pond_ms.CATEGORY drop constraint FK_i7fbju65h4h6e5e1d9ell8alr
alter table pond_ms.CUSTOMERS drop constraint FK_7xy7ofee1qxy9jj6n9eyx9p6u
alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS drop constraint FK_k0s1j4trgns3cvbph4nik8b7y
alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS drop constraint FK_7mq30439hmyagqgfn4j6wvq2e
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS drop constraint FK_5rspt1s8n0gpy44pb05871l9a
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS drop constraint FK_637yv69jbavdwa45bpikpqxh0
alter table pond_ms.DATA_FILES drop constraint FK_clhklmyhdfsjqc396j5e5k38m
alter table pond_ms.DATA_FILES drop constraint FK_j6x72u81psdw2vn8k90ktduth
alter table pond_ms.FILE_CONTENTS drop constraint FK_q4x58sdyuy2t323yx96foy9ht
alter table pond_ms.FILE_CONTENTS_FILE_SYSTEM drop constraint FK_a4cy1gj2msjqbyxwkfk49u9ex
alter table pond_ms.GISMAPS drop constraint FK_149mrpipvd4s514idbrfybiib
alter table pond_ms.GIS_VECTOR_OBJECTS drop constraint FK_eraewk7yyphei0t4m0ml3b2ok
alter table pond_ms.GRADIENT_STOPS drop constraint FK_mxmo7feayvegbhcwh7acah626
alter table pond_ms.LAYER drop constraint FK_s2n8qnu13iimuc0k50x0ghinv
alter table pond_ms.LAYER drop constraint FK_c2i87m565u0tf88ti4myko6m2
alter table pond_ms.LAYER drop constraint FK_66t4mfbiliucwhklf0wf1jkwk
alter table pond_ms.LEAF_CATEGORY drop constraint FK_sf5xl98klj19lq0e5g1ian6ox
alter table pond_ms.LEAF_LAYERS drop constraint FK_rcx8kbi1svp9xp579yrinfqrv
alter table pond_ms.LINE_OBJECTS drop constraint FK_c3mkf3t8yhodeom2m20ou7uid
alter table pond_ms.NATIVE_FILES drop constraint FK_ljbwgjx4xtwyca9ca4rtg57q4
alter table pond_ms.ORGANIZATIONS drop constraint FK_rxfincph55ifdbn5pv5sb8k7m
alter table pond_ms.PARENT_CATEGORY drop constraint FK_qa6a4jb53wlx72guq5w5beu5q
alter table pond_ms.PARENT_LAYER drop constraint FK_kdo9pfsmeoysyn2ri2xctts4o
alter table pond_ms.POINT_OBJECTS drop constraint FK_iugjir271r0xefdjijos2s8ai
alter table pond_ms.POLYGON_OBJECTS drop constraint FK_r1l850in6rtiac4f6btv0ffog
alter table pond_ms.PONDS drop constraint FK_b2sdfq9sxf3pyaw7fhyrxfl5t
alter table pond_ms.RASTER_LAYERS drop constraint FK_cax1gmobr3k0ud29r8hagb691
alter table pond_ms.RASTER_LAYERS drop constraint FK_5vmkvi6q1gd04fqwbtjvxp2lt
alter table pond_ms.RASTER_LAYERS drop constraint FK_3afxd22253siywp7il819s6qn
alter table pond_ms.REPLY_REVIEWS drop constraint FK_prub87ej8a6iebp24vnh6irtg
alter table pond_ms.REPLY_REVIEWS drop constraint FK_au1xdc7ax39qtqivsxwh97894
alter table pond_ms.REVIEWS drop constraint FK_ih30juidmhorasfjses3xutos
alter table pond_ms.REVIEWS drop constraint FK_8vyohrop8sk7lw4b10g6ys3yc
alter table pond_ms.REVIEW_VOTES drop constraint FK_dnvpstilwlgi9onexfcp32vtg
alter table pond_ms.REVIEW_VOTES drop constraint FK_gocs1vsmyhk1n4jxsyck6ijgo
alter table pond_ms.ROLE_FEATURES drop constraint FK_23kfmjd6lt9jgjcxsgp8nmtbp
alter table pond_ms.ROLE_FEATURES drop constraint FK_iyd1dkloxejnurxgx72c9pwvg
alter table pond_ms.ROOT_CATEGORY drop constraint FK_rik5i66y46saykoabb673wxqd
alter table pond_ms.ROOT_CATEGORY drop constraint FK_otib3mom7jp5eifn1g2b2950m
alter table pond_ms.ROOT_CATEGORY drop constraint FK_fh6xhsbnrdlrtw31eme07e6x8
alter table pond_ms.ROOT_CATEGORY drop constraint FK_90s6owemc5s49h8y2tntsori5
alter table pond_ms.ROOT_CATEGORY drop constraint FK_3l0jde07o9ef1droguin4qfyv
alter table pond_ms.TIME_SERIES_DATE_VALUE_PAIR drop constraint FK_q4vdh6febhy4i2f2chyqciri0
alter table pond_ms.USERS drop constraint FK_k3gm4drnorissx5s1hmnk99cj
alter table pond_ms.USERS drop constraint FK_b8wg50ku8xc27xw7llss5m4tx
alter table pond_ms.USER_ROLES drop constraint FK_ixvn2eap6pna97ymmcm11narh
alter table pond_ms.USER_ROLES drop constraint FK_4vocb5yb32s4kl5a9hax6h4sa
alter table pond_ms.VECTOR_LAYER drop constraint FK_2obxx3wtbxdvicsakd7ipycj9
drop table if exists commons_cm.ENTITY_TYPES cascade
drop table if exists commons_cm.ENTITY_TYPE_SNAPSHOTS cascade
drop table if exists commons_cm.TOPICS cascade
drop table if exists foursquare.FOURSQUARE_KEYS cascade
drop table if exists pond_ms.ABSTRACT_FILES cascade
drop table if exists pond_ms.APP_MESSAGES cascade
drop table if exists pond_ms.APP_MESSAGES_IMAGES cascade
drop table if exists pond_ms.APP_MESSAGE_URLS cascade
drop table if exists pond_ms.AUTH_USERS cascade
drop table if exists pond_ms.CAMPAIGNS cascade
drop table if exists pond_ms.CATEGORY cascade
drop table if exists pond_ms.CONFIG_ENTRIES cascade
drop table if exists pond_ms.CUSTOMERS cascade
drop table if exists pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS cascade
drop table if exists pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS cascade
drop table if exists pond_ms.Cities cascade
drop table if exists pond_ms.DATA_FILES cascade
drop table if exists pond_ms.FEATURES cascade
drop table if exists pond_ms.FEED_BACKS cascade
drop table if exists pond_ms.FILE_CONTENTS cascade
drop table if exists pond_ms.FILE_CONTENTS_FILE_SYSTEM cascade
drop table if exists pond_ms.GISMAPS cascade
drop table if exists pond_ms.GIS_VECTOR_OBJECTS cascade
drop table if exists pond_ms.GRADIENTS cascade
drop table if exists pond_ms.GRADIENT_STOPS cascade
drop table if exists pond_ms.Google_Api_Keys cascade
drop table if exists pond_ms.Hotels cascade
drop table if exists pond_ms.LAYER cascade
drop table if exists pond_ms.LEAF_CATEGORY cascade
drop table if exists pond_ms.LEAF_LAYERS cascade
drop table if exists pond_ms.LINE_OBJECTS cascade
drop table if exists pond_ms.NATIVE_FILES cascade
drop table if exists pond_ms.ORGANIZATIONS cascade
drop table if exists pond_ms.PARENT_CATEGORY cascade
drop table if exists pond_ms.PARENT_LAYER cascade
drop table if exists pond_ms.PLACE_REPORT cascade
drop table if exists pond_ms.POINT_OBJECTS cascade
drop table if exists pond_ms.POLYGON_OBJECTS cascade
drop table if exists pond_ms.PONDS cascade
drop table if exists pond_ms.RASTER_LAYERS cascade
drop table if exists pond_ms.REPLY_REVIEWS cascade
drop table if exists pond_ms.REVIEWS cascade
drop table if exists pond_ms.REVIEW_VOTES cascade
drop table if exists pond_ms.ROLES cascade
drop table if exists pond_ms.ROLE_FEATURES cascade
drop table if exists pond_ms.ROOT_CATEGORY cascade
drop table if exists pond_ms.TIME_SERIES_DATE_VALUE_PAIR cascade
drop table if exists pond_ms.TIME_SERIES_GROUP cascade
drop table if exists pond_ms.USERS cascade
drop table if exists pond_ms.USER_ROLES cascade
drop table if exists pond_ms.VECTOR_LAYER cascade
create table commons_cm.ENTITY_TYPES (id int8 not null, key_ varchar(255) not null, name varchar(255) not null, icon varchar(255), rawJsonSchema text not null, processedJsonSchema text not null, weak boolean not null, collectionName varchar(255) not null, hotkey varchar(255), archive boolean not null, parentEntityTypeId int8, docxExportTemplate varchar(255), primary key (id))
create table commons_cm.ENTITY_TYPE_SNAPSHOTS (id int8 not null, extuid varchar(255) not null, entityTypeId int8 not null, rawJsonSchema text not null, creatorUsername varchar(255), creationDate timestamp not null, processedJsonSchema text not null, revision int4 not null, primary key (id))
create table commons_cm.TOPICS (id int8 not null, extuid varchar(255) not null, name varchar(255) not null, secretLevel int4 not null, deleted boolean not null, parentId int8, indexInParent int4, primary key (id))
create table foursquare.FOURSQUARE_KEYS (id int8 not null, extuid varchar(255) not null, client_id varchar(255) not null, client_secret varchar(255) not null, used_count int4 not null, max_usage int4 not null, busy boolean not null, last_used_date timestamp not null, primary key (id))
create table pond_ms.ABSTRACT_FILES (id int8 not null, hashCodeStr varchar(255) not null, primary key (id))
create table pond_ms.APP_MESSAGES (id int8 not null, extuid varchar(255) not null, title varchar(255) not null, message text not null, creationDate date not null, expirationDate date, enabled boolean not null, videoUrl varchar(255), videoOnly boolean not null, primary key (id))
create table pond_ms.APP_MESSAGES_IMAGES (app_message_id int8 not null, imagefile_id int8 not null, primary key (app_message_id, imagefile_id))
create table pond_ms.APP_MESSAGE_URLS (id int8 not null, indexInAppMessage int4, url varchar(255) not null, appMessageId int8, primary key (id))
create table pond_ms.AUTH_USERS (id int8 not null, extuid varchar(255) not null, username varchar(255) not null, password varchar(255) not null, enabled boolean not null, firstName varchar(255), lastName varchar(255), phoneNumber varchar(255), userExpirationDate timestamp, passwordExpirationDate timestamp, noLoginExpirationDate timestamp, lastLoginFailureDate timestamp, lastConsecutiveLoginFailuresCount int4 not null, primary key (id))
create table pond_ms.CAMPAIGNS (id int8 not null, extuid varchar(255) not null, useId varchar(255) not null, phone_num varchar(255) not null, device_name varchar(255), destination varchar(255) not null, day01 char(1), day02 char(1) not null, day03 char(1) not null, day04 char(1) not null, day05 char(1) not null, day06 char(1) not null, day07 char(1) not null, day08 char(1) not null, day09 char(1) not null, day10 char(1) not null, day11 char(1) not null, day12 char(1) not null, day13 char(1) not null, day14 char(1) not null, day15 char(1) not null, day16 char(1) not null, day17 char(1) not null, day18 char(1) not null, primary key (id))
create table pond_ms.CATEGORY (id int8 not null, extuid varchar(255) not null, name varchar(255) not null, index_in_parent int4, parent_id int8, primary key (id))
create table pond_ms.CONFIG_ENTRIES (id int8 not null, extuid varchar(255) not null, title varchar(255), configKey varchar(255) not null, configValue varchar(255), primary key (id))
create table pond_ms.CUSTOMERS (id int8 not null, extuid varchar(255) not null, userId int8 not null, phoneNumber varchar(255) not null, email varchar(255), biography varchar(255), name varchar(255), age varchar(255), gender varchar(255), locality varchar(255), lotteryCode varchar(255) not null, primary key (id))
create table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS (id int8 not null, extuid varchar(255) not null, customerId int8 not null, gisVectorObjectId int8 not null, primary key (id))
create table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS (id int8 not null, extuid varchar(255) not null, customerId int8 not null, gisVectorObjectId int8 not null, viewDate timestamp not null, primary key (id))
create table pond_ms.Cities (id int8 not null, extuid varchar(255) not null, city_name varchar(255), flight_code varchar(255), eghamat_name varchar(255), hotelyar_name varchar(255), hotelyar_code varchar(255), primary key (id))
create table pond_ms.DATA_FILES (id int8 not null, extuid varchar(255) not null, abstract_file int8 not null, dataReference varchar(255), data_collection_date timestamp, layer_id int8, idx int4, primary key (id))
create table pond_ms.FEATURES (id int8 not null, extuid varchar(255) not null, name varchar(255) not null, description varchar(255), exposable boolean not null, primary key (id))
create table pond_ms.FEED_BACKS (id int8 not null, extuid varchar(255) not null, title varchar(255), email varchar(255), comment varchar(255) not null, date timestamp not null, primary key (id))
create table pond_ms.FILE_CONTENTS (id int8 not null, legacy_data bytea, primary key (id))
create table pond_ms.FILE_CONTENTS_FILE_SYSTEM (fileContentId int8 not null, fsName varchar(255) not null, editCounter int4 not null, primary key (fileContentId))
create table pond_ms.GISMAPS (id int8 not null, extuid varchar(255) not null, title varchar(255) not null, latin_title varchar(255), description varchar(255), creation_date timestamp not null, bounding_box GEOMETRY, center GEOMETRY, min_zoom int4 default 12, max_zoom int4 default 16, default_zoom int4 default 14, organization_id int8 not null, primary key (id))
create table pond_ms.GIS_VECTOR_OBJECTS (id int8 not null, extuid varchar(255) not null, name varchar(255), creation_date timestamp not null, provider varchar(255), formUID varchar(255), reviewCount int4, favoriteCount int4, layer_id int8 not null, primary key (id))
create table pond_ms.GRADIENTS (id int8 not null, extuid varchar(255) not null, title varchar(255) not null, primary key (id))
create table pond_ms.GRADIENT_STOPS (id int8 not null, extuid varchar(255) not null, red float8 not null, green float8 not null, blue float8 not null, gradient_id int8, offset_value float8, primary key (id))
create table pond_ms.Google_Api_Keys (id int8 not null, extuid varchar(255) not null, key varchar(255), last_used_date timestamp, usedCounter int4, busy boolean not null, primary key (id))
create table pond_ms.Hotels (id int8 not null, extuid varchar(255) not null, hotel_name varchar(255), eghamat_name varchar(255), pintapin_name varchar(255), ariabooking_name varchar(255), hotelyar_name varchar(255), hotelyar_code varchar(255), iranhotelonline_name varchar(255), iranhotelonline_code varchar(255), primary key (id))
create table pond_ms.LAYER (id int8 not null, extuid varchar(255) not null, name varchar(255) not null, description varchar(255), creation_date timestamp not null, pondRelated boolean default false, map_id int8 not null, parent_id int8, index_in_parent int4, parent_map_id int8, index_in_gismap int4, secret boolean default false, primary key (id))
create table pond_ms.LEAF_CATEGORY (category_id int8 not null, timeSeriesValueType varchar(255) not null, primary key (category_id))
create table pond_ms.LEAF_LAYERS (layer_id int8 not null, primary key (layer_id))
create table pond_ms.LINE_OBJECTS (vector_object_id int8 not null, line geometry(LineString,4326), primary key (vector_object_id))
create table pond_ms.NATIVE_FILES (fileId int8 not null, fName varchar(255) not null, fileSize int8 not null, creationDate timestamp not null, modificationDate timestamp not null, contentType varchar(255) not null, primary key (fileId))
create table pond_ms.ORGANIZATIONS (id int8 not null, extuid varchar(255) not null, name varchar(255) not null, code varchar(255), parentId int8, primary key (id))
create table pond_ms.PARENT_CATEGORY (category_id int8 not null, primary key (category_id))
create table pond_ms.PARENT_LAYER (layer_id int8 not null, primary key (layer_id))
create table pond_ms.PLACE_REPORT (id int8 not null, extuid varchar(255) not null, title varchar(255) not null, message text not null, creationDate timestamp not null, primary key (id))
create table pond_ms.POINT_OBJECTS (vector_object_id int8 not null, point geometry(Point,4326), primary key (vector_object_id))
create table pond_ms.POLYGON_OBJECTS (vector_object_id int8 not null, polygon geometry(Polygon,4326), primary key (vector_object_id))
create table pond_ms.PONDS (id int8 not null, extuid varchar(255) not null, title varchar(255) not null, layer int8 not null, generalFormUID_public varchar(255), descriptiveFormUID_public varchar(255), tabularFormUID_public varchar(255), libraryFormUID_public varchar(255), galleryFormUID_public varchar(255), universalMapFormUID_public varchar(255), descriptiveFormUID_secret varchar(255), tabularFormUID_secret varchar(255), libraryFormUID_secret varchar(255), galleryFormUID_secret varchar(255), universalMapFormUID_secret varchar(255), primary key (id))
create table pond_ms.RASTER_LAYERS (layer_id int8 not null, gradient int8, rasterFile int8, primary key (layer_id))
create table pond_ms.REPLY_REVIEWS (id int8 not null, extuid varchar(255) not null, position varchar(255) not null, creationDate date not null, text text not null, confirmed boolean not null, user_id int8, review_id int8, idx int4, primary key (id))
create table pond_ms.REVIEWS (id int8 not null, extuid varchar(255) not null, title varchar(255) not null, rate int4 not null, text text not null, creationDate timestamp not null, lastModifiedDate timestamp not null, user_id int8, visitedDate timestamp not null, typeOfVisit varchar(255) not null, confirmed int4 not null, deleted boolean not null, vector_object_id int8, primary key (id))
create table pond_ms.REVIEW_VOTES (id int8 not null, extuid varchar(255) not null, vote int4 not null, date timestamp not null, userId int8 not null, reviewId int8 not null, primary key (id))
create table pond_ms.ROLES (id int8 not null, type_ varchar(255) not null, extuid varchar(255) not null, name varchar(255) not null, description varchar(255), userDefined boolean not null, primary key (id))
create table pond_ms.ROLE_FEATURES (roleId int8 not null, featureId int8 not null, primary key (roleId, featureId))
create table pond_ms.ROOT_CATEGORY (category_id int8 not null, group_id int8, pond_id int8, object_id int8, dataFile int8 not null, primary key (category_id))
create table pond_ms.TIME_SERIES_DATE_VALUE_PAIR (id int8 not null, extuid varchar(255) not null, submissionTime int8 not null, timeSeriValue varchar(255), category_id int8, primary key (id))
create table pond_ms.TIME_SERIES_GROUP (id int8 not null, extuid varchar(255) not null, name varchar(255) not null, description varchar(255), primary key (id))
create table pond_ms.USERS (id int8 not null, extuid varchar(255) not null, authUserId int8, enabled boolean not null, userDefined boolean not null, avatar varchar(255), organizationId int8, lastSeen timestamp, firebaseId varchar(255), primary key (id))
create table pond_ms.USER_ROLES (roleId int8 not null, userId int8 not null, primary key (userId, roleId))
create table pond_ms.VECTOR_LAYER (layer_id int8 not null, formSchemaKey varchar(255), vectorObjectsType varchar(255), pointIcon varchar(255), lineColor varchar(255), lineWidth varchar(255), polygonFill varchar(255), labled boolean not null, primary key (layer_id))
alter table commons_cm.ENTITY_TYPES add constraint UK_hy7ncqlvqyqq1hoakg3b0thch  unique (key_)
alter table commons_cm.ENTITY_TYPES add constraint UK_o0h99j6vn5vf8x3pggos41a2i  unique (name)
alter table commons_cm.ENTITY_TYPES add constraint UK_dfjdn461d07ac8vk3kl9ntu1b  unique (docxExportTemplate)
alter table commons_cm.ENTITY_TYPE_SNAPSHOTS add constraint key_entityType_revision  unique (entityTypeId, revision)
alter table commons_cm.ENTITY_TYPE_SNAPSHOTS add constraint UK_pykfikfel7gytc9jqgr28heke  unique (extuid)
alter table commons_cm.TOPICS add constraint UK_svjnfyc1v6mwrmn4bkiimnl79  unique (extuid)
alter table foursquare.FOURSQUARE_KEYS add constraint UK_tqlybenat1cfxkw5frk4cab8g  unique (extuid)
alter table foursquare.FOURSQUARE_KEYS add constraint UK_ml8fi3c1f6b3wp5raakfp8x3w  unique (client_id)
alter table foursquare.FOURSQUARE_KEYS add constraint UK_p79frw0xr9iexssshya2ynw54  unique (client_secret)
alter table pond_ms.ABSTRACT_FILES add constraint UK_hyts6q6q94d0nh1imdiqko4iq  unique (hashCodeStr)
alter table pond_ms.APP_MESSAGES add constraint UK_8gtvpx56ajm58b71qxy2yq6bl  unique (extuid)
alter table pond_ms.APP_MESSAGES_IMAGES add constraint UK_84ljyb5kl1ge4l5pv8fcfpc5d  unique (imagefile_id)
alter table pond_ms.AUTH_USERS add constraint UK_3p67nqhndt0u9sakus3uovc81  unique (extuid)
alter table pond_ms.AUTH_USERS add constraint UK_j7p9yectkf7l4mp4hqjjsphde  unique (username)
alter table pond_ms.CAMPAIGNS add constraint UK_f062fo13ktue3d7qq5smj4w9v  unique (extuid)
alter table pond_ms.CAMPAIGNS add constraint UK_62bwrg5y92qscr03ng24sshfd  unique (useId)
alter table pond_ms.CATEGORY add constraint UK_iuo1cop4rb13xf7f2vdqgvn9v  unique (extuid)
alter table pond_ms.CONFIG_ENTRIES add constraint UK_j5sp8e4sck4to17j34flk22xl  unique (extuid)
alter table pond_ms.CONFIG_ENTRIES add constraint UK_nmnju5x1xolso09rvh847n73o  unique (configKey)
alter table pond_ms.CUSTOMERS add constraint UK_b0l7uh6btfmru3cidnymr8bcn  unique (extuid)
alter table pond_ms.CUSTOMERS add constraint UK_7xy7ofee1qxy9jj6n9eyx9p6u  unique (userId)
alter table pond_ms.CUSTOMERS add constraint UK_6a0gg9o8towa6u579k9kljagu  unique (phoneNumber)
alter table pond_ms.CUSTOMERS add constraint UK_dliv3lx3st9igcx7o3v5lv5fp  unique (lotteryCode)
alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS add constraint UK_i9b4o0e53li027913yh9o3ecy  unique (extuid)
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS add constraint UK_ob15ravi01ujj01i15na20tc8  unique (extuid)
alter table pond_ms.Cities add constraint UK_boflduiokaq55r76exmi2ibgy  unique (extuid)
alter table pond_ms.DATA_FILES add constraint UK_igvgvtqwms9ixj7reimts9myo  unique (extuid)
alter table pond_ms.DATA_FILES add constraint UK_clhklmyhdfsjqc396j5e5k38m  unique (abstract_file)
alter table pond_ms.FEATURES add constraint UK_c8pkbrgxfl8ghr7b75hqr8eqv  unique (extuid)
alter table pond_ms.FEATURES add constraint UK_qx1jf10esv72lwsb4d8xmbyh8  unique (name)
alter table pond_ms.FEED_BACKS add constraint UK_ju3q3ew9ffd7pavo37oobdgja  unique (extuid)
alter table pond_ms.FILE_CONTENTS_FILE_SYSTEM add constraint UK_l49a2k554mr496wk60sp79db7  unique (fsName)
alter table pond_ms.GISMAPS add constraint UK_37ioud7r9u80rfcb12vw54uha  unique (extuid)
alter table pond_ms.GISMAPS add constraint UK_149mrpipvd4s514idbrfybiib  unique (organization_id)
alter table pond_ms.GIS_VECTOR_OBJECTS add constraint UK_tdlipwq0lu9tqsejkouuwe617  unique (extuid)
alter table pond_ms.GRADIENTS add constraint UK_2k7aol39o54ddk05j00xsv6qj  unique (extuid)
alter table pond_ms.GRADIENT_STOPS add constraint UK_tp0f7852agsqdhsry23qstkr1  unique (extuid)
alter table pond_ms.Google_Api_Keys add constraint UK_5boqdx7uxt05hqieax0m490h9  unique (extuid)
alter table pond_ms.Google_Api_Keys add constraint UK_tibddl0vam50k8g1702u0dm2w  unique (key)
alter table pond_ms.Hotels add constraint UK_37wadr83nxlmv4f6ngc6cdhn9  unique (extuid)
alter table pond_ms.LAYER add constraint UK_r8vtc0k2wr0s3twaoviu1b1cb  unique (extuid)
alter table pond_ms.ORGANIZATIONS add constraint UK_3c6etu4hcxipljwa3jrjdqpxe  unique (extuid)
alter table pond_ms.PLACE_REPORT add constraint UK_emo65i2cmfxm8attthjrqeqrg  unique (extuid)
alter table pond_ms.PONDS add constraint UK_2k5scjubk9nwom2qyyao7vuyj  unique (extuid)
alter table pond_ms.PONDS add constraint UK_b2sdfq9sxf3pyaw7fhyrxfl5t  unique (layer)
alter table pond_ms.RASTER_LAYERS add constraint UK_3afxd22253siywp7il819s6qn  unique (rasterFile)
alter table pond_ms.REPLY_REVIEWS add constraint UK_afaakko0jhc2ig9koy5q1k7k0  unique (extuid)
alter table pond_ms.REVIEWS add constraint UK_fnp0ctut45l6xja05ehfg7kwg  unique (extuid)
alter table pond_ms.REVIEW_VOTES add constraint UK_ReviewVote_review_user  unique (userId, reviewId)
alter table pond_ms.REVIEW_VOTES add constraint UK_kc8764l0t8tggndhpy3wcptxd  unique (extuid)
alter table pond_ms.ROLES add constraint UK_hffrgdy49ff56f4w6t6pmj288  unique (extuid)
alter table pond_ms.ROLES add constraint UK_1s6p3xpt8owdb603jky0mo815  unique (name)
alter table pond_ms.ROOT_CATEGORY add constraint UK_3l0jde07o9ef1droguin4qfyv  unique (dataFile)
alter table pond_ms.TIME_SERIES_DATE_VALUE_PAIR add constraint UK_pyyf6oebbh10wco8ydwdmrwhc  unique (extuid)
alter table pond_ms.TIME_SERIES_GROUP add constraint UK_lyi1ieuygmwu06n61wjbdi830  unique (extuid)
alter table pond_ms.USERS add constraint UK_46kvy05nqwkhpefsagvg5samv  unique (extuid)
alter table pond_ms.USERS add constraint UK_k3gm4drnorissx5s1hmnk99cj  unique (authUserId)
alter table pond_ms.USERS add constraint UK_2fwsdf7im1gbgek47naw4dpbk  unique (firebaseId)
alter table commons_cm.ENTITY_TYPES add constraint FK_eohgx0gpynwgov4qsk5680qob foreign key (parentEntityTypeId) references commons_cm.ENTITY_TYPES
alter table commons_cm.ENTITY_TYPE_SNAPSHOTS add constraint FK_iwhpy0mr84yfb154qd8cu95v8 foreign key (entityTypeId) references commons_cm.ENTITY_TYPES
alter table commons_cm.TOPICS add constraint FK_o5qe2s2wkqrtgs8sr0ooutmmh foreign key (parentId) references commons_cm.TOPICS
alter table pond_ms.APP_MESSAGES_IMAGES add constraint FK_84ljyb5kl1ge4l5pv8fcfpc5d foreign key (imagefile_id) references pond_ms.ABSTRACT_FILES
alter table pond_ms.APP_MESSAGES_IMAGES add constraint FK_m17lf2yh13l0aafxt7ydvym9h foreign key (app_message_id) references pond_ms.APP_MESSAGES
alter table pond_ms.APP_MESSAGE_URLS add constraint FK_g00ac0qk6m4mabjtwhfk6bhvv foreign key (appMessageId) references pond_ms.APP_MESSAGES
alter table pond_ms.CATEGORY add constraint FK_i7fbju65h4h6e5e1d9ell8alr foreign key (parent_id) references pond_ms.PARENT_CATEGORY
alter table pond_ms.CUSTOMERS add constraint FK_7xy7ofee1qxy9jj6n9eyx9p6u foreign key (userId) references pond_ms.USERS
alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS add constraint FK_k0s1j4trgns3cvbph4nik8b7y foreign key (customerId) references pond_ms.CUSTOMERS
alter table pond_ms.CUSTOMER_FAVORITE_GIS_VECTOR_OBJECTS add constraint FK_7mq30439hmyagqgfn4j6wvq2e foreign key (gisVectorObjectId) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS add constraint FK_5rspt1s8n0gpy44pb05871l9a foreign key (customerId) references pond_ms.CUSTOMERS
alter table pond_ms.CUSTOMER_VIEWED_GIS_VECTOR_OBJECTS add constraint FK_637yv69jbavdwa45bpikpqxh0 foreign key (gisVectorObjectId) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.DATA_FILES add constraint FK_clhklmyhdfsjqc396j5e5k38m foreign key (abstract_file) references pond_ms.ABSTRACT_FILES
alter table pond_ms.DATA_FILES add constraint FK_j6x72u81psdw2vn8k90ktduth foreign key (layer_id) references pond_ms.LEAF_LAYERS
alter table pond_ms.FILE_CONTENTS add constraint FK_q4x58sdyuy2t323yx96foy9ht foreign key (id) references pond_ms.NATIVE_FILES
alter table pond_ms.FILE_CONTENTS_FILE_SYSTEM add constraint FK_a4cy1gj2msjqbyxwkfk49u9ex foreign key (fileContentId) references pond_ms.FILE_CONTENTS
alter table pond_ms.GISMAPS add constraint FK_149mrpipvd4s514idbrfybiib foreign key (organization_id) references pond_ms.ORGANIZATIONS
alter table pond_ms.GIS_VECTOR_OBJECTS add constraint FK_eraewk7yyphei0t4m0ml3b2ok foreign key (layer_id) references pond_ms.VECTOR_LAYER
alter table pond_ms.GRADIENT_STOPS add constraint FK_mxmo7feayvegbhcwh7acah626 foreign key (gradient_id) references pond_ms.GRADIENTS
alter table pond_ms.LAYER add constraint FK_s2n8qnu13iimuc0k50x0ghinv foreign key (map_id) references pond_ms.GISMAPS
alter table pond_ms.LAYER add constraint FK_c2i87m565u0tf88ti4myko6m2 foreign key (parent_id) references pond_ms.PARENT_LAYER
alter table pond_ms.LAYER add constraint FK_66t4mfbiliucwhklf0wf1jkwk foreign key (parent_map_id) references pond_ms.GISMAPS
alter table pond_ms.LEAF_CATEGORY add constraint FK_sf5xl98klj19lq0e5g1ian6ox foreign key (category_id) references pond_ms.CATEGORY
alter table pond_ms.LEAF_LAYERS add constraint FK_rcx8kbi1svp9xp579yrinfqrv foreign key (layer_id) references pond_ms.LAYER
alter table pond_ms.LINE_OBJECTS add constraint FK_c3mkf3t8yhodeom2m20ou7uid foreign key (vector_object_id) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.NATIVE_FILES add constraint FK_ljbwgjx4xtwyca9ca4rtg57q4 foreign key (fileId) references pond_ms.ABSTRACT_FILES
alter table pond_ms.ORGANIZATIONS add constraint FK_rxfincph55ifdbn5pv5sb8k7m foreign key (parentId) references pond_ms.ORGANIZATIONS
alter table pond_ms.PARENT_CATEGORY add constraint FK_qa6a4jb53wlx72guq5w5beu5q foreign key (category_id) references pond_ms.CATEGORY
alter table pond_ms.PARENT_LAYER add constraint FK_kdo9pfsmeoysyn2ri2xctts4o foreign key (layer_id) references pond_ms.LAYER
alter table pond_ms.POINT_OBJECTS add constraint FK_iugjir271r0xefdjijos2s8ai foreign key (vector_object_id) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.POLYGON_OBJECTS add constraint FK_r1l850in6rtiac4f6btv0ffog foreign key (vector_object_id) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.PONDS add constraint FK_b2sdfq9sxf3pyaw7fhyrxfl5t foreign key (layer) references pond_ms.PARENT_LAYER
alter table pond_ms.RASTER_LAYERS add constraint FK_cax1gmobr3k0ud29r8hagb691 foreign key (layer_id) references pond_ms.LEAF_LAYERS
alter table pond_ms.RASTER_LAYERS add constraint FK_5vmkvi6q1gd04fqwbtjvxp2lt foreign key (gradient) references pond_ms.GRADIENTS
alter table pond_ms.RASTER_LAYERS add constraint FK_3afxd22253siywp7il819s6qn foreign key (rasterFile) references pond_ms.ABSTRACT_FILES
alter table pond_ms.REPLY_REVIEWS add constraint FK_prub87ej8a6iebp24vnh6irtg foreign key (user_id) references pond_ms.USERS
alter table pond_ms.REPLY_REVIEWS add constraint FK_au1xdc7ax39qtqivsxwh97894 foreign key (review_id) references pond_ms.REVIEWS
alter table pond_ms.REVIEWS add constraint FK_ih30juidmhorasfjses3xutos foreign key (user_id) references pond_ms.USERS
alter table pond_ms.REVIEWS add constraint FK_8vyohrop8sk7lw4b10g6ys3yc foreign key (vector_object_id) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.REVIEW_VOTES add constraint FK_dnvpstilwlgi9onexfcp32vtg foreign key (userId) references pond_ms.USERS
alter table pond_ms.REVIEW_VOTES add constraint FK_gocs1vsmyhk1n4jxsyck6ijgo foreign key (reviewId) references pond_ms.REVIEWS
alter table pond_ms.ROLE_FEATURES add constraint FK_23kfmjd6lt9jgjcxsgp8nmtbp foreign key (featureId) references pond_ms.FEATURES
alter table pond_ms.ROLE_FEATURES add constraint FK_iyd1dkloxejnurxgx72c9pwvg foreign key (roleId) references pond_ms.ROLES
alter table pond_ms.ROOT_CATEGORY add constraint FK_rik5i66y46saykoabb673wxqd foreign key (category_id) references pond_ms.PARENT_CATEGORY
alter table pond_ms.ROOT_CATEGORY add constraint FK_otib3mom7jp5eifn1g2b2950m foreign key (group_id) references pond_ms.TIME_SERIES_GROUP
alter table pond_ms.ROOT_CATEGORY add constraint FK_fh6xhsbnrdlrtw31eme07e6x8 foreign key (pond_id) references pond_ms.PONDS
alter table pond_ms.ROOT_CATEGORY add constraint FK_90s6owemc5s49h8y2tntsori5 foreign key (object_id) references pond_ms.GIS_VECTOR_OBJECTS
alter table pond_ms.ROOT_CATEGORY add constraint FK_3l0jde07o9ef1droguin4qfyv foreign key (dataFile) references pond_ms.DATA_FILES
alter table pond_ms.TIME_SERIES_DATE_VALUE_PAIR add constraint FK_q4vdh6febhy4i2f2chyqciri0 foreign key (category_id) references pond_ms.LEAF_CATEGORY
alter table pond_ms.USERS add constraint FK_k3gm4drnorissx5s1hmnk99cj foreign key (authUserId) references pond_ms.AUTH_USERS
alter table pond_ms.USERS add constraint FK_b8wg50ku8xc27xw7llss5m4tx foreign key (organizationId) references pond_ms.ORGANIZATIONS
alter table pond_ms.USER_ROLES add constraint FK_ixvn2eap6pna97ymmcm11narh foreign key (userId) references pond_ms.USERS
alter table pond_ms.USER_ROLES add constraint FK_4vocb5yb32s4kl5a9hax6h4sa foreign key (roleId) references pond_ms.ROLES
alter table pond_ms.VECTOR_LAYER add constraint FK_2obxx3wtbxdvicsakd7ipycj9 foreign key (layer_id) references pond_ms.LEAF_LAYERS
