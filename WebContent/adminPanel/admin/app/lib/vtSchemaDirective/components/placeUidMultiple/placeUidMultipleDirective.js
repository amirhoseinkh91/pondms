angular.module('placeUidMultiple', ["ui.select"]).directive('placeUidMultiple', function () {

    return {
        restrict: 'AEC',
        templateUrl: 'app/lib/vtSchemaDirective/components/placeUidMultiple/placeUidMultipleTemplate.html',
        scope: {
            model: '=',
            tagFunction: '=?',
            isEditMode: '=',
            api: "="
        },
        controller: function ($scope, Restangular) {

            $scope.api ? $scope.api : $scope.api = {};
            $scope.placeList = [];
            $scope.place = {};
            $scope.isLoading = false;

            $scope.removeTextInput = function (inp) {
                angular.forEach($scope.model, function (item, index) {
                    if (inp.UID == item.UID) {
                        $scope.model.splice(index, 1);
                    }
                });
            };
            $scope.onSearchClick = function () {
                $scope.isLoading = true;
                return Restangular.one('filter/placeSearch?q=' + $scope.tempStr).get().then(function (response) {
                    $scope.placeList = response.data;
                    $scope.isLoading = false;
                }, function () {
                    $scope.isLoading = false;
                });
            };
            $scope.onAddNewTextInputClick = function (place) {
                if (!$scope.model) {
                    $scope.model = [];
                }
                var isDuplicate = false;
                angular.forEach($scope.model, function (item, index) {
                    if (place.UID == item.UID) {
                        isDuplicate = true;
                    }
                });
                if (!isDuplicate) {
                    $scope.model.push(place);
                }
            };

        },
        link: function (scope, element, attrs, ctrls) {

        }
    };

});