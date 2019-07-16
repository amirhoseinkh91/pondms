angular.module('pondmapModule').controller('eventModalCtrl', function ($scope, $uibModalInstance, eventObj, layerSrvc, 
                                                                       pondmapSrvc, $timeout) {

    $scope.Data = {
        mapModel: {
            point: {
                type: "point",
                coordinates: [
                    45.762944217422, 36.8364267569388]
            }
        },
        mode: "view",
        vectorObject: null,
        api: {},
        selectedFeature: null,
        eventObj: angular.copy(eventObj)
    };

    $scope.Func = {
        changeEditMode: function () {
            $scope.Data.mode = 'edit';
        },
        deleteModel: function () {
            layerSrvc.deleteFeatureListInstance($scope.Data.vectorObject.organization.uid, $scope.Data.vectorObject.uid).then(function (response) {
                $uibModalInstance.close();
                // $scope.Func.onClearSearchClick();
                // $scope.Func.onCloseInfoPanelClick();
            });
        },
        saveEditMode: function () {
            $scope.Data.mode = 'view';
            var data = {};
            data.type = $scope.Data.selectedFeature.type;
            data.formInstance = {};
            for (var i = 0; i < $scope.Data.form.viewGroups[0].members.length; i++) {
                if ($scope.Data.selectedFeature.formInstance[$scope.Data.form.viewGroups[0].members[i]]) {
                    data.formInstance[$scope.Data.form.viewGroups[0].members[i]] = $scope.Data.selectedFeature.formInstance[$scope.Data.form.viewGroups[0].members[i]];
                }
                else {
                    data.formInstance[$scope.Data.form.viewGroups[0].members[i]] = null;
                }
            }
            // if (data.formInstance.Things_To_DoName) {
            //     data.name = data.formInstance.Things_To_DoName;
            // }
            // else if (data.formInstance.RestaurantName) {
            //     data.name = data.formInstance.RestaurantName;
            // }
            // else if (data.formInstance.HotelName) {
            //     data.name = data.formInstance.HotelName;
            // }
            // else {
            //     data.name = null;
            // }
            var tempPoint = $scope.Controller.crud.getData("point");
            $scope.Data.mapModel.point = tempPoint.geometry;
            data.point = $scope.Data.mapModel.point;
            $scope.Controller.crud.init();
            data.layer = {};
            data.layer.uid = $scope.Data.vectorObject.layer.uid;
            data.polygon = null;
            data.line = null;
            if (data.formInstance.Images) {
                for (var i = 0; i < data.formInstance.Images.length; i++) {
                    if (typeof data.formInstance.Images[i] === "string") {
                        data.formInstance.Images[i] = data.formInstance.Images[i];
                    } else {
                        data.formInstance.Images[i] = data.formInstance.Images[i].hash;

                    }
                }
            }
            angular.forEach(data.formInstance, function (itemVal, itemKey) {
                angular.forEach($scope.Data.pointList, function (point) {
                    if (point == itemKey) {
                        if (data.formInstance[itemKey].hasOwnProperty('point') && _.isEmpty(data.formInstance[itemKey].point)) {
                            data.formInstance[itemKey] = null;
                        } else {
                            data.formInstance[itemKey] = {
                                point: data.formInstance[itemKey].point.point,
                                name: data.formInstance[itemKey].name
                            };
                        }
                    }
                });
                angular.forEach($scope.Data.locationList, function (location) {
                    if (location == itemKey) {
                        if (data.formInstance[itemKey].hasOwnProperty('point') && _.isEmpty(data.formInstance[itemKey].point)) {
                            data.formInstance[itemKey] = null;
                        } else {
                            data.formInstance[itemKey] = {
                                point: data.formInstance[itemKey].point
                            };
                        }
                    }
                });
            });
            layerSrvc.updateFeatureListInstance($scope.Data.vectorObject.organization.uid, $scope.Data.vectorObject.uid, data).then(function (response) {
                $uibModalInstance.close();
                // $scope.Data.mode = 'view';
                // $scope.Func.onClearSearchClick();
                // $scope.Data.query = angular.copy($scope.Data.queryTmp);
                // $scope.Func.onSearchClick();
                // $scope.Data.objTmp.point = data.point;
                // $scope.Func.onSearchedObjectClick($scope.Data.objTmp);
            });
        },
        cancleEditMode: function () {
            $scope.Data.mode = 'view';
        },
        getVectorObject: function () {
            pondmapSrvc.getVectorObject($scope.Data.eventObj.uid).then(function (response) {
                pondmapSrvc.getEntityType(response.data.layer.formSchemaKey).then(function (res) {
                    $scope.Data.form = JSON.parse(res.data.schema);
                    $scope.Data.pointList = [];
                    $scope.Data.locationList = [];
                    angular.forEach($scope.Data.form.properties, function (propValue, propKey) {
                        if (propValue.type == "point") {
                            $scope.Data.pointList.push(propKey);
                        }
                        if (propValue.type == "location") {
                            $scope.Data.locationList.push(propKey);
                        }
                    });
                    // $scope.Data.pondSchema= JSON.parse(res.data.schema);
                    $scope.Data.vectorObject = response.data;
                    // $scope.leftSideType = "object";
                    // $scope.Func.onTabClick($scope.Data.tabList[1]);
                    // $scope.openLeftSide = true;
                    // $scope.featureLoading = false;
                    // $scope.Controller.func($scope.Data.vectorObject.uid);

                    $timeout(function () {
                        $scope.Controller.crud.resetMap();
                        // if (response.data.formInstance) {
                        //     response.data.formInstance.Things_To_DoName = response.data.name;
                        // }
                        $scope.Data.selectedFeature = response.data;
                        $scope.Data.mapModel.point = response.data.point;
                        $scope.Controller.crud.init();
                    }, 5000);
                });
            });
        },
        onCloseModalClick: function () {
            $uibModalInstance.dismiss();
        }
    };

    $scope.Controller = {
        crud: {}
    };

    var Run = function () {
        $scope.Func.getVectorObject();
    };

    Run();

});
