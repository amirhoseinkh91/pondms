alter table org_chart.ROLES add column systemAdministrative boolean default false not null;
alter table pond_ms.GIS_VECTOR_OBJECTS alter name drop not null;
alter table pond_ms.RASTER_LAYERS alter gradient drop not null;

UPDATE org_chart.roles 
SET systemadministrative = true
WHERE name='sysadmin' or name='admin';