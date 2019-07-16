alter table pond_ms.RASTER_LAYERS add column rasterFile bigint;
alter table pond_ms.RASTER_LAYERS add constraint FK_3afxd22253siywp7il819s6qn foreign key (rasterFile)
references pond_ms.ABSTRACT_FILES;
