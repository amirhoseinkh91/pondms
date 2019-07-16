angular.module('vtMap', ['rtmap']).directive('vtMap', function () {

    return {
        restrict: 'AEC',
        templateUrl: 'app/lib/vtSchemaDirective/components/vtMap/vtMapTemplate.html',
        scope: {
            model: '=',
            tagFunction: '=?',
            isEditMode: '=',
            api: "=",
            schema: "=",
            field: "="
        },
        controller: function ($scope, $timeout) {

            $scope.api ? $scope.api : $scope.api = {};
            $scope.model.point ? $scope.model.point : $scope.model.point = {
                type: "Point",
                coordinates: [
                    45.762944217422, 36.8364267569388]
            };

            $scope.Data = {
                isShow: false,
                crudName: ""
            };

            $scope.Func = {
                onSaveMapDataClick: function () {
                    var tempPoint = $scope.Controller[$scope.Data.crudName].getData("point");
                    $scope.model.point = tempPoint.geometry;
                    $scope.Controller[$scope.Data.crudName].init();
                }
            };

            $timeout(function () {
                $scope.Data.crudName = "crud" + $scope.field;
                $scope.Controller = {};
                $scope.Controller[$scope.Data.crudName] = {};
                $timeout(function () {
                    $scope.Data.isShow = true;

                    $timeout(function () {
                        $scope.Controller[$scope.Data.crudName].resetMap();
                        $timeout(function () {
                            $scope.Controller[$scope.Data.crudName].init();
                        }, 1000);
                    }, 1000);
                }, 1);
            }, 1);

        },
        link: function (scope, element, attrs, ctrls) {

        }
    };

});