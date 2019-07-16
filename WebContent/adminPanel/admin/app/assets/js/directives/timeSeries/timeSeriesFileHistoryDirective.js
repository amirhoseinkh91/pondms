angular.module('timeSeriesModule').directive('timeSeriesFileHistory', function(){
	return {
		restrict: 'E',
		templateUrl: 'app/assets/js/directives/timeSeries/timeSeriesFileHistoryTemplate.html',
		scope: {
			associate: "=",
			func: "=",
		},
		controller: function($scope, $rootScope, $uibModal, timeSeriesSrvc) {
			
			$scope.func = function(uid){
				timeSeriesSrvc.getTimeSeriesRootCategories(uid).then(function(response) {
					$scope.timeSeriesGroupList = response.data;
				});
			}

		}

	}
});
