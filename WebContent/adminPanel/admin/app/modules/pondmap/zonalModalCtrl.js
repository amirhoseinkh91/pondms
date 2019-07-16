angular.module('pondmapModule').controller('zonalModalCtrl', function($scope, $uibModalInstance, data, layer) {

	$scope.data = data;
	$scope.layer = layer;
	
	$scope.onCloseClick = function(){
		$uibModalInstance.dismiss();
	}
	
});