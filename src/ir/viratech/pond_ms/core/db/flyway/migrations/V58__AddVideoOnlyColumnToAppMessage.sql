alter table pond_ms.APP_MESSAGES add column videoOnly boolean;

update pond_ms.APP_MESSAGES set videoOnly=false;

alter table pond_ms.APP_MESSAGES ALTER COLUMN videoOnly set not null;