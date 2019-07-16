angular.module('pondmsModule').constant('POND_MS_MENUS', 
	[{
		title: "نقشه",
		uiSref: "home.pondmap",
		feature: "*",
		order: 1
	},{
		title: "مدیریت",
		uiSref: "home.national",
		feature: "*",
		order: 1
	}]
).constant('NATIONAL_MENUS', 
	[{
		title : "مدیریت نقش‌ها",
		uiSref : "home.national.userrole",
		feature : "MANAGEMENT_ROLE",
		icon : "glyphicon glyphicon-user"
	},{
		title : "مدیریت پورتال‌ها",
		uiSref : "home.national.portal",
		feature : "MANAGEMENT_PORTAL",
		icon : "glyphicon glyphicon-tasks"
	},{
		title : "مدیریت فرم‌ها",
		uiSref : "home.national.form",
		feature : "ACCESS_CM",
		icon : "glyphicon glyphicon-folder-open"
	}]
).constant('SUBPORTAL_MENUS', 
	[{
		title : "مدیریت کاربران",
		uiSref : "home.subPortal.user",
		feature : "MANAGEMENT_USER",
		icon : "glyphicon glyphicon-user"
	},{
		title : "مدیریت لایه‌ها",
		uiSref : "home.subPortal.layer",
		feature : "MANAGEMENT_LAYER",
		icon : "glyphicon glyphicon-menu-hamburger"
	},{
		title : "مدیریت تالاب‌ها",
		uiSref : "home.subPortal.pond",
		feature : "MANAGEMENT_POND",
		icon : "glyphicon glyphicon-tree-conifer"
	}]
);