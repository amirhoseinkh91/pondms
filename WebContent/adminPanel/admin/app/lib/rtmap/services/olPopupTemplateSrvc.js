angular.module('rtmap').factory('olPopupTemplateSrvc', function olPopupTemplateSrvc($filter) {
	
	
	var getTimeOfStatus = function(date) {
			var date = new Date(date);
			var hours = date.getHours();
			var minutes = "0" + date.getMinutes();
			var seconds = "0" + date.getSeconds();
			var formattedTime = hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
		return $filter('EnToFaNumber')(formattedTime);		
	};
	
	var getPersianDate = function(date) {
		return $filter('EnToFaNumber')($filter('persianDate')(new Date(date),'yyyy/MM/dd'));
	};
	
	var hasValue = function(data) {
		if(data || data == 0){
			return $filter('EnToFaNumber')(data);
		}else{
			return 'نامشخص'
		}
	};
	
	var templatePool = function(feature){
		var featureType = feature.get('entityType');
		var featureData = feature.get('data');
		switch (featureType) {
		case 'station':
			var template = '<div class=\"vehicle-popup\"><ul class=\"list-group\"><li class=\"list-group-item popup-header\"><span class="popup-att">کد ایستگاه: </span>'+
				'<span class="popup-val">'+hasValue(featureData.code)+'</span></li><li class=\"list-group-item\"><span class="popup-att">نام ایستگاه: </span>'+
				'<span class="popup-val">'+hasValue(featureData.name)+'</span></li></ul></div>';
			return template;
			break;
		case 'line':
			//TODO: call propfilter for $scope.initData.lineType[featureData.type]:'نامشخص')
			var template = '<div class=\"vehicle-popup\"><ul class=\"list-group\"><li class=\"list-group-item popup-header\"><span class="popup-att">کد خط: </span>'+
				'<span class="popup-val">'+hasValue(featureData.code)+'</span></li><li class=\"list-group-item\"><span class="popup-att">نوع خط: </span>'+
				'<span class="popup-val">'+hasValue(featureData.type)+'</span></li><li class=\"list-group-item\"><span class="popup-att">نام خط: </span>'+
				'<span class="popup-val">'+hasValue(featureData.name)+'</span></li><li class=\"list-group-item\"><span class="popup-att" style="width:75%;">تعداد اتومبیل های فعال: </span>'+
				'<span class="popup-val" style="width:25%;">'+hasValue(featureData.activeVehiclesCount)+'</span></li></ul></div>';
			return template;
			break;
		case 'vehicle':
			var template = '<div class=\"vehicle-popup\"><ul class=\"list-group\"><li class=\"list-group-item popup-header\"><span class="popup-att">کد اتومبیل: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.status.vehicle_id)+'</span></li><li class=\"list-group-item\"><span class="popup-att">مدل خودرو: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.vehicle_model)+'</span></li><li class=\"list-group-item\"><span class="popup-att">کد خط: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.status.line_id)+'</span></li><li class=\"list-group-item\"><span class="popup-att">سرعت: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.status.speed)+'</span></li><li class=\"list-group-item\"><span class="popup-att">تاریخ: </span>'+
	    		'<span class="popup-val">'+(featureData.status.tp_time?getPersianDate(featureData.status.tp_time):'نامشخص')+'</span></li><li class=\"list-group-item\"><span class="popup-att">زمان داده: </span>'+
	    		'<span class="popup-val">'+(featureData.status.tp_time?getTimeOfStatus(featureData.status.tp_time):'نامشخص')+'</span></li><li class=\"list-group-item\"><span class="popup-att">نام راننده: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.driver_fullname)+'</span></li><li class=\"list-group-item\"><span class="popup-att">منطقه: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.operational_region_name)+'</span></li></ul></div>';
			return template;
			break;
		case 'poi':
			var template = '<div class=\"vehicle-popup\" style=\"width: 400px\"><ul class=\"list-group\"><li class=\"list-group-item popup-header\"><span class="popup-att">نام فارسی: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.name_fa)+'</span></li><li class=\"list-group-item\"><span class="popup-att">نام انگلیسی: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.name_en)+'</span></li></ul></div>';
			return template;
			break;
		case 'stopPoint':
			var template = '<div class=\"vehicle-popup\" style=\"width: 400px\"><ul class=\"list-group\"><li class=\"list-group-item popup-header\"><span class="popup-att">کد راننده: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.driver_code)+'</span></li><li class=\"list-group-item\"><span class="popup-att">کد خط: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.line_code)+'</span></li><li class=\"list-group-item\"><span class="popup-att">کد خودرو: </span>'+
	    		'<span class="popup-val">'+hasValue(featureData.vehicle_id)+'</span></li><li class=\"list-group-item\"><span class="popup-att">تاریخ: </span>'+
	    		'<span class="popup-val">'+(featureData.tp_time?getPersianDate(featureData.tp_time):'نامشخص')+'</span></li><li class=\"list-group-item\"><span class="popup-att">زمان داده: </span>'+
	    		'<span class="popup-val">'+(featureData.tp_time?getTimeOfStatus(featureData.tp_time):'نامشخص')+'</span></li></ul></div>';
			return template;
			break;
		default:
			break;
		}
	};

	return{
		getTemplate: function(feature){
			return templatePool(feature);
		}
	}
});