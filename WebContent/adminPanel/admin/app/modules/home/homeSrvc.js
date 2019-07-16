angular.module('homeModule', []);
angular.module('homeModule').factory('homeSrvc', ['Restangular', 'POND_MS_MENUS', function(Restangular, POND_MS_MENUS) {
	var features;
	return {
		setMenuAndFeatures : function(userConfig) {
			features = userConfig.features;
		},

		getFeatures : function() {
			return features;
		},
		generateMenuData : function() {
			return POND_MS_MENUS;
		},
		
		changePassword: function(data){
			return Restangular.all('user/change_password').post(data);
		}

	};

} ]);
