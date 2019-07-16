drop schema if exists org_chart cascade;

create table pond_ms.AUTH_USERS (id bigint not null, extuid varchar(255) not null, username varchar(255)
not null, password varchar(255) not null, enabled boolean not null, firstName varchar(255), lastName varchar(255),
phoneNumber varchar(255), userExpirationDate timestamp, passwordExpirationDate timestamp, noLoginExpirationDate
timestamp, lastLoginFailureDate timestamp, lastConsecutiveLoginFailuresCount bigint not null, primary
key (id));
create table pond_ms.FEATURES (id bigint not null, extuid varchar(255) not null, name varchar(255) not
null, description varchar(255), exposable boolean not null, primary key (id));
create table pond_ms.ORGANIZATIONS (id bigint not null, extuid varchar(255) not null, name varchar(255)
not null, code varchar(255), parentId bigint, primary key (id));
create table pond_ms.ROLES (id bigint not null, type_ varchar(255) not null, extuid varchar(255) not null,
name varchar(255) not null, description varchar(255), userDefined boolean not null, primary key (id));
create table pond_ms.ROLE_FEATURES (featureId bigint not null, roleId bigint not null, primary key (roleId,
featureId));
create table pond_ms.USERS (id bigint not null, extuid varchar(255) not null, authUserId bigint not null,
enabled boolean not null, userDefined boolean not null, avatar varchar(255), organizationId bigint, primary
key (id));
create table pond_ms.USER_ROLES (roleId bigint not null, userId bigint not null, primary key (userId,
roleId));

INSERT INTO pond_ms.organizations(id, extuid, name, code, parentid)
VALUES (1, 'JustRO', 'JustRo', 1, null);

UPDATE pond_ms.gismaps
SET organization_id=1;

DELETE FROM pond_ms.reply_reviews;
DELETE FROM pond_ms.reviews;

alter table pond_ms.AUTH_USERS add constraint UK_3p67nqhndt0u9sakus3uovc81  unique (extuid);
alter table pond_ms.AUTH_USERS add constraint UK_j7p9yectkf7l4mp4hqjjsphde  unique (username);
alter table pond_ms.FEATURES add constraint UK_c8pkbrgxfl8ghr7b75hqr8eqv  unique (extuid);
alter table pond_ms.FEATURES add constraint UK_qx1jf10esv72lwsb4d8xmbyh8  unique (name);
alter table pond_ms.ORGANIZATIONS add constraint UK_3c6etu4hcxipljwa3jrjdqpxe  unique (extuid);
alter table pond_ms.ROLES add constraint UK_hffrgdy49ff56f4w6t6pmj288  unique (extuid);
alter table pond_ms.ROLES add constraint UK_1s6p3xpt8owdb603jky0mo815  unique (name);
alter table pond_ms.USERS add constraint UK_46kvy05nqwkhpefsagvg5samv  unique (extuid);
alter table pond_ms.USERS add constraint UK_k3gm4drnorissx5s1hmnk99cj  unique (authUserId);

alter table pond_ms.GISMAPS add constraint FK_149mrpipvd4s514idbrfybiib foreign key (organization_id)
references pond_ms.ORGANIZATIONS;
alter table pond_ms.ORGANIZATIONS add constraint FK_rxfincph55ifdbn5pv5sb8k7m foreign key (parentId) references
pond_ms.ORGANIZATIONS;
alter table pond_ms.REPLY_REVIEWS add constraint FK_prub87ej8a6iebp24vnh6irtg foreign key (user_id) references
pond_ms.USERS;
alter table pond_ms.REVIEWS add constraint FK_ih30juidmhorasfjses3xutos foreign key (user_id) references
pond_ms.USERS;
alter table pond_ms.ROLE_FEATURES add constraint FK_iyd1dkloxejnurxgx72c9pwvg foreign key (roleId) references
pond_ms.ROLES;
alter table pond_ms.ROLE_FEATURES add constraint FK_23kfmjd6lt9jgjcxsgp8nmtbp foreign key (featureId)
references pond_ms.FEATURES;
alter table pond_ms.USERS add constraint FK_k3gm4drnorissx5s1hmnk99cj foreign key (authUserId) references
pond_ms.AUTH_USERS;
alter table pond_ms.USERS add constraint FK_b8wg50ku8xc27xw7llss5m4tx foreign key (organizationId) references
pond_ms.ORGANIZATIONS;
alter table pond_ms.USER_ROLES add constraint FK_ixvn2eap6pna97ymmcm11narh foreign key (userId) references
pond_ms.USERS;
alter table pond_ms.USER_ROLES add constraint FK_4vocb5yb32s4kl5a9hax6h4sa foreign key (roleId) references
pond_ms.ROLES;