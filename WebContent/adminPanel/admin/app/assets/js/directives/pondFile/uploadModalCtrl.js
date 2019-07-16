angular.module('pondFileModule').controller('uploadModalCtrl', function($scope, $uibModalInstance, layer) {

	$uibModalInstance.rendered.then(function() {
		$scope.Data = {
			form: {}
		}

		$scope.Func = {
			onSaveClick: function() {
				$scope.Data.form.layer_uid = layer.uid;
				$scope.Data.form.type = layer.type;
				$scope.Data.form.file_hash = $scope.Data.file.hash;
				$scope.Data.form.date = $scope.Data.form.date.getTime();
				
				$uibModalInstance.close($scope.Data.form);
			},
			onCancelClick: function(){
				$uibModalInstance.dismiss();
			}
		}

	});
});