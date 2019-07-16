angular.module("bigText").controller('bigTextModalCtrl', function($scope, $uibModalInstance, model, isEditMode, direction) {

	$scope.model = model;
	$scope.isEditMode = isEditMode;
	$scope.direction = direction;

	$scope.ok = function(m) {
		$uibModalInstance.close(m);
	};

	$scope.cancel = function() {
		$uibModalInstance.dismiss('cancel');
	};
});