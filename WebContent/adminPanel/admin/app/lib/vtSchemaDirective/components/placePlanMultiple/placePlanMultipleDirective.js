angular.module('placePlanMultiple', []).directive('placePlanMultiple', function () {

    return {
        restrict: 'AEC',
        templateUrl: 'app/lib/vtSchemaDirective/components/placePlanMultiple/placePlanMultipleTemplate.html',
        scope: {
            model: '=',
            isEditMode: '=',
            api: "="
        },
        controller: function ($scope) {

            $scope.Data = {
                placePlanObj: {}
            };

            $scope.Func = {
                onSaveClick: function () {
                    if (!$scope.model)
                        $scope.model = [];
                    if ($scope.Data.placePlanObj.name && $scope.Data.placePlanObj.name.trim() &&
                        $scope.Data.placePlanObj.services && $scope.Data.placePlanObj.services.trim() &&
                        $scope.Data.placePlanObj.startDate && $scope.Data.placePlanObj.endDate &&
                        $scope.Data.placePlanObj.reserve && $scope.Data.placePlanObj.reserve.trim()) {
                        var placeObj = angular.copy($scope.Data.placePlanObj);
                        if (placeObj.startDate)
                            placeObj.startDate = Date.parse(placeObj.startDate);
                        if (placeObj.endDate)
                            placeObj.endDate = Date.parse(placeObj.endDate);
                        $scope.model.push(placeObj);
                        $scope.Data.placePlanObj = {};
                    }
                },
                onRemoveClick: function (item, index) {
                    $scope.model.splice(index, 1);
                }
            };

            $scope.api ? $scope.api : $scope.api = {};

        },
        link: function (scope, element, attrs, ctrls) {

        }
    };

});