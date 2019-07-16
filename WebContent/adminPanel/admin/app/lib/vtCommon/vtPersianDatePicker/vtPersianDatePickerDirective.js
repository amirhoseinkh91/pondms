angular.module('vtPersianDatePicker', []).directive("vtPersianDatePicker",function() {
	return {
		restrict : 'AE',
		template : "<p class=\"input-group\">" + "<input name=\"name\" ng-disabled=\"disabled\" style=\"background-color: white;border-radius: 0;\" type=\"text\""
				+ "readonly=\"readonly\" class=\"form-control\"" + "datepicker-popup-persian=\"yyyy\/MM\/dd\" ng-model=\"model\""
				+ "ng-required=\"isRequired\" is-open=\"Data.datePicker.isOpen\""
				+ "current-text=\"امروز\" clear-text=\"پاک کردن\" close-text=\"لغو\"" + "starting-day=\"6\" \/>"
				+ "<span class=\"input-group-btn\">" + "<button type=\"button\" ng-disabled=\"disabled\"  class=\"btn btn-default\" style=\"border-radius: 0;color:#555;\"" 
				+ "ng-click=\"Data.open($event)\">" + "<i class=\"glyphicon glyphicon-calendar\"><\/i>" + "<\/button>" + "<\/span>"
				+ "<\/p>",
		scope : {
			model : '=',
			isRequired : "=",
			name : "@",
			disabled:"=?"
		},
		controller : function($scope, $rootScope) {
			$scope.$watch("model", function(newValue, oldValue) {
				if (newValue && !angular.isDate(newValue)) {
					newValue = new Date(newValue);
					$scope.model = newValue;
				}
			}, true);
			$scope.Data = {
				datePicker : {
					isOpen : false
				},
				open : function($event) {
					$event.preventDefault();
					$event.stopPropagation();
					$rootScope.$broadcast('closeDatePicker', {
						close : $scope.name
					});
					$scope.Data.datePicker.isOpen = !$scope.Data.datePicker.isOpen;
				}
			}
			$rootScope.$on('closeDatePicker', function(e, eArgs) {
				if ($scope.name != eArgs.close)
					$scope.Data.datePicker.isOpen = false;
			});
		},
		link : function(scope, element, attrs, ctrls) {
		}
	};
});