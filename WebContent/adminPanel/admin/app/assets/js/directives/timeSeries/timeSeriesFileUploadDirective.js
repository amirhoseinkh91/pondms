angular.module('timeSeriesModule').directive('timeSeriesFileUpload', function(){
	return {
		restrict: 'E',
		templateUrl: 'app/assets/js/directives/timeSeries/timeSeriesFileUploadTemplate.html',
		scope: {
			associate: "=",
			objectType: "=",
			geoObjectUid: "="
		},
		controller: function($scope, $rootScope, $uibModal, timeSeriesSrvc) {
			$scope.api = {
				call: function(geoObjectUid) {
//					$scope.geoObjectUid = geoObjectUid;
				}
			},
			
			$scope.onUploadDataClick = function(){
				$scope.timeSeriesGroupList = timeSeriesSrvc.getTimeSeriesGroupList();
				var modalInstance = $uibModal.open({
					size: 'md',
					templateUrl: 'app/assets/js/directives/timeSeries/timeSeriesUploadModal.html',
					controller: 'timeSeriesUploadModalCtrl',
					resolve:{
						geoObjectUid: function(){
							return $scope.geoObjectUid;
						},
						list: function(){
							return $scope.timeSeriesGroupList;
						},
						objectType: function() {
							return $scope.objectType;
						}
					}
				});
				modalInstance.result.then(function(data){
					$scope.importing = true;
					timeSeriesSrvc.uploadTimeSeries(data).then(function(){
						$scope.importing = false;
//						$scope.getLayerFileHistory($scope.layer.uid);
						//TODO toaster success
					}, function(err){
						$scope.importing = false;
						//TODO toaster error
					});
				});
			}, 
			
			$scope.getTimeSeriesGroupList = function() {
				$scope.timeSeriesGroupList = [];
				timeSeriesSrvc.getTimeSeriesGroupList().then(function(response) {
					$scope.timeSeriesGroupList = response.data;
//					$scope.onUploadDataClick();
				});
			}

			var Run = function(){
				$scope.getTimeSeriesGroupList();
			}
			
			Run();
		}

	}
});
