angular.module('pondmapModule').controller('identifyModalCtrl', function($scope, $uibModalInstance, data, layer) {

	$scope.data = data;
	$scope.layer = layer;
	
	$scope.onCloseClick = function(){
		$uibModalInstance.dismiss();
	}
	
});