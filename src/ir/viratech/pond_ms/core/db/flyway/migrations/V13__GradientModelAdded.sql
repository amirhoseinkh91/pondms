create table pond_ms.GRADIENTS (id bigint not null, extuid varchar(255) not null, title varchar(255) not
null, primary key (id));
create table pond_ms.GRADIENT_STOPS (id bigint not null, extuid varchar(255) not null, red float8 not
null, green float8 not null, blue float8 not null, gradient_id bigint, offset_value float8, primary key
(id));

alter table pond_ms.GRADIENTS add constraint UK_2k7aol39o54ddk05j00xsv6qj  unique (extuid);
alter table pond_ms.GRADIENT_STOPS add constraint UK_tp0f7852agsqdhsry23qstkr1  unique (extuid);
alter table pond_ms.GRADIENT_STOPS add constraint FK_mxmo7feayvegbhcwh7acah626 foreign key (gradient_id)
references pond_ms.GRADIENTS;


alter table pond_ms.RASTER_LAYERS drop column colormap;
alter table pond_ms.RASTER_LAYERS add column gradient bigint;

alter table pond_ms.RASTER_LAYERS add constraint FK_5vmkvi6q1gd04fqwbtjvxp2lt foreign key (gradient) references
pond_ms.GRADIENTS;