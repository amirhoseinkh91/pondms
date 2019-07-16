angular.module('sourceDestination', ['rtmap']).directive('sourceDestination', function () {

    return {
        restrict: 'AEC',
        templateUrl: 'app/lib/vtSchemaDirective/components/sourceDestination/sourceDestinationTemplate.html',
        scope: {
            model: '=',
            tagFunction: '=?',
            isEditMode: '=',
            api: "=?",
            field: "="
        },
        controller: function ($scope) {

            $scope.api ? $scope.api : $scope.api = {};

            $scope.Controller = {
                sourceApi: {},
                destinationApi: {}
            };

        },
        link: function (scope, element, attrs, ctrls) {

        }
    };

});