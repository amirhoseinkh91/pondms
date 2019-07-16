var pondMS = pondMS || {};

pondMS.externalDependencies = [ 'ui.bootstrap', 'ui.router','restangular', 'ngSanitize', 'ui.sortable', 'chart.js', 'angular-intro','ngConfirm', 'ui.select'];
pondMS.internalDependency = [ 'vtCommon', 'appFilter', 'vtFile', 'vtMedia', 'rtmap', 'schemaForm', 'angular-tree',
								'pondFormModule', 'pondFileModule', 'colorPickerModule', 'widthPickerModule', 'timeSeriesModule'];
pondMS.modulesDependency = ['pondmsModule', 'homeModule', 'nationalModule', 'subPortalModule', 'pondmapModule'];

var app = angular.module('app', pondMS.externalDependencies.concat(pondMS.internalDependency).concat(pondMS.modulesDependency));

app.factory('lowLevelHttpInterceptor', function() {
	var lowLevelHttpInterceptor = {
		response : function(response) {
			switch (response.status) {
			case 401:
				window.location = "/adminPanel/static/login.html";
				break;
			default:
				return response;
				break;
			}
			return response;
		}
	}
	return lowLevelHttpInterceptor;
});

app.config(pondMS.config).run(run).filter('safeHTML', function($sce) {
	return $sce.trustAsHtml;
});


var BOOTSTRAP_ANGULAR = function() {
	fetchData().then(bootstrapApplication);

	function fetchData() {
		var $http = angular.injector([ 'ng' ]).get('$http');
		return $http.get('/api/config').then(function(data, status, headers, config) {
			var tempData = data.data;
			var features = tempData.userConfig.features;
			var obj = {};
			angular.forEach(features, function(feature) {
				obj[feature] = true;
			});
			tempData.userConfig.features = obj;
			app.constant('configObj', tempData);
		}

		, function(errorResponse) {
			window.location = "/adminPanel/static/login.html"
		});
	}

	function bootstrapApplication() {
		angular.element(document).ready(function() {

			angular.bootstrap(document, [ "app" ]);
		}

		);
	}
}

BOOTSTRAP_ANGULAR();