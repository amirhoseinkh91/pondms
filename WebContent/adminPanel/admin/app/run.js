function run(Restangular, toaster, $location, $rootScope, $state, $templateCache, configSrvc, vtShowMessageSrvc) {

	var getBaseRequestUrl = function() {
		return "/api";
	};

	Restangular.addResponseInterceptor(function(data, operation, what, url, response, deferred) {
		vtShowMessageSrvc.hideLoadingDialog();
		if (response.data.metadata && response.data.metadata.isShow) {
			angular.forEach(response.data.messages, function(a) {
				vtShowMessageSrvc.showMassage(a.type.toLowerCase(), '', a.text);
			});
		}
		return response.data;
	});

	Restangular.setErrorInterceptor(function(response) {
		vtShowMessageSrvc.hideLoadingDialog();
		if (response.data.metadata && response.data.metadata.isShow) {
			angular.forEach(response.data.messages, function(a) {
				vtShowMessageSrvc.showMassage(a.type.toLowerCase(), '', a.text);
			});
		}
		switch (response.status) {
		case 403:
			window.location = "/adminPanel/static/error-403.html";
			break;
		case 401:
			window.location = "/adminPanel/static/login.html";
			break;
		case 419:
			window.location = "/adminPanel/#/change_password";
			break;
		default:
			break;
		}
		return true;
	});

	Restangular.addFullRequestInterceptor(function(element, operation, route, url, headers, params, httpConfig) {
		vtShowMessageSrvc.showLoadingDialog();

		return {
			element : element,
			params : params,
			headers : headers,
			httpConfig : httpConfig

		};
	});

	Restangular.setResponseExtractor(function(response, operation, what, url, response2, deferred) {
		if(response.items && angular.isArray(response.items) && response.items.length>100){
			return response.items;
		}else{
			var newResponse = angular.copy(response) || {};
			if (operation === 'getList') {
				if (!angular.isArray(response)) {
					newResponse = response.items;
					delete response.items;
					angular.extend(newResponse, response);
				}
			} else if (response.items) {
				newResponse = response.items;
				delete response.items;
				angular.extend(newResponse, response);
			}
			var newResponse2 = newResponse;
			newResponse2.originalElement = angular.copy(newResponse);
			if (angular.isObject(response)) {
				angular.extend(newResponse2.originalElement, response);
			}
			return newResponse2;
		}
	});

	Restangular.setBaseUrl(getBaseRequestUrl());
	Restangular.setDefaultHeaders({'Content-Type': 'application/json'});
	Restangular.setOnElemRestangularized(function(elem, isCollection, route) {
		return elem;
	});

	$rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
		configSrvc.getConfigAndConfigModules().then(function(config) {
			if (config.userConfig.features["API_CHANGE_PASSWORD"] && Object.keys(config.userConfig.features).length== 1) {
				window.location = "static/changePassword.html"
			}
		});
	});
};