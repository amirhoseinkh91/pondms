alter table pond_ms.CUSTOMERS add column lotteryCode varchar(255);

alter table pond_ms.CUSTOMERS add constraint UK_dliv3lx3st9igcx7o3v5lv5fp  unique (lotteryCode);