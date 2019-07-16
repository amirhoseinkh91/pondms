angular.module('layerModule').controller('featureCtrl', function ($scope, $state, layerSrvc) {

    $scope.Data = {
        viewMode: 'view',
        orgUid: $state.params.orgUid,
        layerUid: $state.params.layerUid,
        mapModel: {
            point: {
                type: "point",
                coordinates: [
                    45.762944217422, 36.8364267569388]
            }
        },
        featureList: [],
        schem: {},
        api: {},
        selectedFeature: {
            formInstance: {}
        }
    }

    $scope.Func = {
        changeEditMode: function () {
            $scope.Data.viewMode = 'edit';
            $scope.Data.editMode = true;
            $scope.Data.api.getModelTemp();
        },
        cancleEditMode: function () {
            $scope.Data.viewMode = 'view';
            $scope.Data.editMode = false;
            $scope.Data.api.resetModel();
        },
        saveEditMode: function () {
            $scope.Data.viewMode = 'view';
            $scope.Data.editMode = false;
            var data = {};
            data.type = $scope.Data.selectedFeature.type;
            data.formInstance = {};
            console.log("==========data=========",$scope.Data)
            for (var i = 0; i < $scope.Data.schema.viewGroups[0].members.length; i++) {
                if ($scope.Data.selectedFeature.formInstance[$scope.Data.schema.viewGroups[0].members[i]]) {
                    data.formInstance[$scope.Data.schema.viewGroups[0].members[i]] = $scope.Data.selectedFeature.formInstance[$scope.Data.schema.viewGroups[0].members[i]];
                }
                else {
                    data.formInstance[$scope.Data.schema.viewGroups[0].members[i]] = null;
                }
            }
            if (data.formInstance.Things_To_DoName) {
                data.name = data.formInstance.Things_To_DoName;
            }
            else if (data.formInstance.RestaurantName) {
                data.name = data.formInstance.RestaurantName;
            }
            else if (data.formInstance.HotelName) {
                data.name = data.formInstance.HotelName;
            }
            else if (data.formInstance.AgencyName) {
                data.name = data.formInstance.AgencyName;
            }
            else {
                data.name = null;
            }
            var tempPoint = $scope.Controller.crud.getData("point");
            $scope.Data.mapModel.point = tempPoint.geometry;
            data.point = $scope.Data.mapModel.point;
            $scope.Controller.crud.init();
            data.layer = {};
            data.layer.uid = $scope.Data.layerUid;
            data.polygon = null;
            data.line = null;
            if (data.formInstance.Images) {
                data.formInstance.Images = _.filter(data.formInstance.Images, function (item) {
                    return ((typeof item === "string" && item.indexOf('http') == -1) || _.isObject(item))
                });
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
            layerSrvc.updateFeatureListInstance($scope.Data.orgUid, $scope.Data.selectedFeature.uid, data).then(function (response) {
                $scope.Controller.listController.refreshList();
            });


        },
        saveNewModel: function () {
            $scope.Data.viewMode = 'view';
            $scope.Data.editMode = false;
            var data = {};
            data.type = "Point";
            data.formInstance = {};
            for (var i = 0; i < $scope.Data.schema.viewGroups[0].members.length; i++) {
                if ($scope.Data.selectedFeature.formInstance[$scope.Data.schema.viewGroups[0].members[i]]) {
                    data.formInstance[$scope.Data.schema.viewGroups[0].members[i]] = $scope.Data.selectedFeature.formInstance[$scope.Data.schema.viewGroups[0].members[i]];
                }
                else {
                    data.formInstance[$scope.Data.schema.viewGroups[0].members[i]] = null;
                }
            }
            if (data.formInstance.Things_To_DoName) {
                data.name = data.formInstance.Things_To_DoName;
            }
            else if (data.formInstance.RestaurantName) {
                data.name = data.formInstance.RestaurantName;
            }
            else if (data.formInstance.HotelName) {
                data.name = data.formInstance.HotelName;
            }
            else {
                data.name = null;
            }
            var tempPoint = $scope.Controller.crud.getData("point");
            $scope.Data.mapModel.point = tempPoint.geometry;
            data.point = $scope.Data.mapModel.point;
            $scope.Controller.crud.resetMap();
            $scope.Controller.crud.init();
            data.layer = {};
            data.layer.uid = $scope.Data.layerUid;
            data.polygon = null;
            data.line = null;
            if (data.formInstance.Images) {
                for (var i = 0; i < data.formInstance.Images.length; i++) {
                    data.formInstance.Images[i] = data.formInstance.Images[i].hash;
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
            layerSrvc.saveNewInstance($scope.Data.orgUid, data).then(function (response) {
                $scope.Controller.listController.refreshList();
            });

        },
        deleteModel: function () {
            layerSrvc.deleteFeatureListInstance($scope.Data.orgUid, $scope.Data.selectedFeature.uid).then(function (response) {
                $scope.Controller.listController.refreshList();
            });

        },
        createModel: function () {
            $scope.Data.viewMode = 'add';
            $scope.Data.editMode = true;
            if ($scope.Data.selectedFeature) {
                $scope.Data.selectedFeature.formInstance = {};
            } else {
                $scope.Data.selectedFeature = {};
                $scope.Data.selectedFeature.formInstance = {};
            }
            angular.forEach($scope.Data.pointList, function (point) {
                $scope.Data.selectedFeature.formInstance[point] = {
                    name: "",
                    point: {}
                };
            });
            angular.forEach($scope.Data.locationList, function (location) {
                $scope.Data.selectedFeature.formInstance[location] = {point: {}};
            });
            $scope.Controller.crud.resetMap();
            $scope.Controller.crud.init();
        },
        cancleNewModel: function () {
            $scope.Data.viewMode = 'view';
            $scope.Data.editMode = false;
            $scope.Data.api.resetModel();
        },
        getLayer: function () {
            layerSrvc.getlayer($scope.Data.orgUid, $scope.Data.layerUid).then(function (response) {
                $scope.Func.getFormSchema(response.data.formSchemaKey);
            })
        },

        getFormSchema: function (key) {
            layerSrvc.getEntityType(key).then(function (response) {
                $scope.Data.schema = JSON.parse(response.data.schema);
                $scope.Data.pointList = [];
                $scope.Data.locationList = [];
                angular.forEach($scope.Data.schema.properties, function (propValue, propKey) {
                    if (propValue.type == "point") {
                        $scope.Data.pointList.push(propKey);
                    }
                    if (propValue.type == "location") {
                        $scope.Data.locationList.push(propKey);
                    }
                });
                if ($scope.Data.selectedFeature) {
                    $scope.Data.selectedFeature.formInstance = {};
                } else {
                    $scope.Data.selectedFeature = {};
                    $scope.Data.selectedFeature.formInstance = {};
                }
                angular.forEach($scope.Data.pointList, function (point) {
                    $scope.Data.selectedFeature.formInstance[point] = {
                        name: "",
                        point: {}
                    };
                });
                angular.forEach($scope.Data.locationList, function (location) {
                    $scope.Data.selectedFeature.formInstance[location] = {point: {}};
                });
            })
        },

        onFeatureClick: function (feature) {
            $scope.Controller.crud.resetMap();
            if (feature.formInstance) {
                feature.formInstance.Things_To_DoName = feature.name;
                if (feature.formInstance.FoursquarePhotos && feature.formInstance.FoursquarePhotos.length > 0 && !feature.formInstance.isConcated) {
                    feature.formInstance.isConcated = true;
                    angular.forEach(feature.formInstance.FoursquarePhotos, function (Foursquare) {
                        feature.formInstance.Images.push(Foursquare);
                    });
                }
            }

            $scope.Data.selectedFeature = feature;
            $scope.Data.mapModel.point = feature.point;
            $scope.Controller.crud.init();

        },
    }

    $scope.Controller = {
        crud: {},
        listController: {
            headers: [
                {key: 'name', label: 'نام', type: 'string'},
                {key: 'type', label: 'نوع', type: 'string'},
                {key: 'creationDate', label: 'تاریخ ایجاد', type: 'date'},
            ],
            getList: function (start, len) {
                return layerSrvc.getFeatureList($scope.Data.layerUid, start, len);
            },
            onListItemSelect: $scope.Func.onFeatureClick
        }
    }

    var Run = function () {
        $scope.Func.getLayer();

    }

    Run();
});