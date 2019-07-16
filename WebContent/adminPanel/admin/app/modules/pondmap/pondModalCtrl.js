angular.module('pondmapModule').controller('pondModalCtrl', function($scope, $uibModalInstance, pondUid, schemaList, secretSchemaList) {

	$scope.pondUid = pondUid;
	$scope.schemaList = schemaList;
	$scope.secretSchemaList = secretSchemaList;
	
	
	$scope.onCancelClick = function(){
		$uibModalInstance.dismiss();
	}
	
});