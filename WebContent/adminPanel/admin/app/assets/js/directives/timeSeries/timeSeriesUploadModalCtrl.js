angular.module('timeSeriesModule').controller('timeSeriesUploadModalCtrl', function($scope, $uibModalInstance, geoObjectUid, list, objectType) {

	$uibModalInstance.rendered.then(function() {
		$scope.Data = {
			form: {},
			list: list.data,
			geo_object_uid: geoObjectUid,
			object_type: objectType
		}
		
		$scope.Func = {
			onSaveClick: function() {
				if ($scope.Data.object_type == 'POND')
					$scope.Data.form.pond_uid = $scope.Data.geo_object_uid;
				else if($scope.Data.object_type == 'VECTOR')
					$scope.Data.form.gis_vector_object_uid = $scope.Data.geo_object_uid;
				$scope.Data.form.file_hash = $scope.Data.file.hash;
//				$scope.Data.form.date = $scope.Data.form.date.getTime();
				$uibModalInstance.close($scope.Data.form);
			},
			onCancelClick: function(){
				$uibModalInstance.dismiss();
			}
		}

	});
	
});