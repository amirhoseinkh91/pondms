angular.module('widthPickerModule', []).directive('widthPicker', function() {
	return {
		restrict: 'EA',
		templateUrl: 'app/assets/js/directives/widthPicker/widthPickerTemplate.html',
		scope: {
			isEditMode: "=",
			model: "="
			
		},
		controller: function($scope) {

			$scope.widths = [1.5, 2.5, 3.5, 4.5, 5.5];
			
			if (!$scope.model)
				$scope.model = $scope.widths[0];
			
			$scope.onWidthClick = function(width){
				$scope.model = width;
			}
			
		}
	}
});