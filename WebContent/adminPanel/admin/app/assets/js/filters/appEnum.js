angular.module('appFilter').constant('appConst', {
	//example
//	management : {
//		consts : "عضو ثابت هیئت مدیره",
//		moaven : "معاون هیئت مدیره",
//		chief : "ریئس هیئت مدیره"
//	}
}).filter('appEnum', function(appConst) {

	var aggregatedConst = {};
	for (val in appConst) {
		angular.extend(aggregatedConst, appConst[val]);
	}

	return function(input,filterName) {
		if(filterName){
			if(appConst[filterName] && appConst[filterName][input]){
				return appConst[filterName][input];
			}else{
				return input;
			}
		}else{
			if (aggregatedConst[input]){
				return aggregatedConst[input];
			}else{
				return input;
			}
		}
	}

});