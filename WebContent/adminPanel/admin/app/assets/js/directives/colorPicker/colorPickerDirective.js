angular.module('colorPickerModule').directive('colorPicker', function() {
	return {
		restrict: 'EA',
		templateUrl: 'app/assets/js/directives/colorPicker/colorPickerTemplate.html',
		scope: {
			isEditMode: "=",
			model: "="
			
		},
		controller: function($scope) {

			$scope.colors = [
				'#e91e63', '#673ab7', '#2196f3', 
				'#00bcd4', '#4caf50', '#cddc39', 
				'#ffc107', '#ff5722'
			];
			if (!$scope.model) 
				$scope.model = $scope.colors[0];
			
			$scope.onColorClick = function(color){
				$scope.model = color;
			}
			
		}
	}
});