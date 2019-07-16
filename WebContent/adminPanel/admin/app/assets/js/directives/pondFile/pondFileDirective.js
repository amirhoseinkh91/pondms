angular.module('pondFileModule').directive('pondFile', function() {
	return {
		restrict: 'EA',
		templateUrl: 'app/assets/js/directives/pondFile/pondFileTemplate.html',
		scope: {
			isEditMode: "=",
			api: "="
			
		},
		controller: function($scope, $rootScope, $uibModal, pondFileSrvc) {

			$scope.api = {
				call: function(layer){
					$scope.layer = layer;
					$scope.getLayerFileHistory(layer.uid);
				}
			}
			
			$scope.onUploadDataClick = function(){
				var modalInstance = $uibModal.open({
					size: 'md',
					templateUrl: 'app/assets/js/directives/pondFile/uploadModal.html',
					controller: 'uploadModalCtrl',
					resolve:{
						layer: function(){
							return $scope.layer;
						}
					}
				});
				modalInstance.result.then(function(data){
					$scope.importing = true;
					pondFileSrvc.uploadlayerData(data).then(function(response){
						$scope.importing = false;
						$scope.getLayerFileHistory($scope.layer.uid);
						//TODO toaster success
					}, function(err){
						$scope.importing = false;
						//TODO toaster error
					});
				});
			}

			$scope.getLayerFileHistory = function(layerUid){
				if($rootScope.features['GET_LAYER_FILES']){
					pondFileSrvc.getLayerFileHistory(layerUid).then(function(response){
						$scope.fileHistoryList = response.data;
					})
				}
			}
			
			$scope.deleteFileFromHistory = function(file) {
				if($rootScope.features['DELETE_LAYER_FILES']){
					pondFileSrvc.deleteFileFromHistory({'uid': file.uid}, $scope.layer.uid).then(function(response) {
						$scope.getLayerFileHistory($scope.layer.uid);
					})
				}
			}

		}
}});