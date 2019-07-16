angular.module('pondmapModule').controller('pondmapCtrl', function($scope, $rootScope, $state, $uibModal, pondmsSrvc, pondmapSrvc, mapSrvc, colorPickerSrvc, layerSrvc, $timeout) {

	$scope.map = new ol.RTMap({
		target: 'map',
		layers: [
			new ol.layer.Vector({
				name: 'search_layer',
				source: new ol.source.Vector()
			})
		]
	});

	$scope.Data = {
		api: {},
		fileApi: {},
		query: '',
		showInfo: false,
		drawing: false,
		vectorObject: null,
		selectedFeature: null,
		timeSeriesMode: null,
		selectedMap: {},
		pondSecretSchemaList: [],
		pondSchemaList: [],
		searchedLayerList: [],
		searchedObjectList: [],
		layerList: [],
		tabList: [{
			id: 0,
			title: 'توضیحات',
			types: ['layer'],
			active: true
		}, {
			id: 1,
			title: 'فرم',
			types: ['object', 'pond']
		}, {
			id: 2,
			title: 'سری زمانی',
			types: ['object', 'pond']
		}, {
			id: 3,
			title: 'تاریخچه فایل',
			types: ['layer']
		}],
		mode: "view",
		mapModel:{
			point:{
				type:"point",
				coordinates:[
					45.762944217422,36.8364267569388]
			}
		}
	}
		
	$scope.Func = {
		onSelectMap: function(map){
			if($scope.Data.selectedMap.uid != map.uid){
				var layers = $scope.map.getLayers().getArray();
				pondmapSrvc.getGisMap(map.uid).then(function(response){
					$scope.Data.selectedMap = response.data.originalElement;
					$scope.map.changeConfig($scope.Data.selectedMap);
				});
			}
		},
		
		selectLayer: function(layer){
			$scope.Func.onSelectMap(layer.map);
			$scope.Data.selectedLayer = layer;
			if(layer.type == 'vector')
				$scope.Func.getFormSchema(layer.formSchemaKey);
		},
		onSelectLayer: function(layer){
			$scope.Func.selectLayer(layer);
			if(layer.isPond){
				$scope.timeSeriesMode = 'pond';
				$scope.leftSideType = "pond";
				$scope.openLeftSide = true;
				$scope.Func.onTabClick($scope.Data.tabList[1]);
				$scope.Func.getPondForm(layer.pond);
		    	$scope.Controller.func(layer.pond.uid);
			}
			
			if(layer.type=='raster' || layer.type=='vector'){
				$scope.leftSideType = "layer";
				$scope.Func.onTabClick($scope.Data.tabList[0]);
				$scope.openLeftSide = true;
				$scope.Data.fileApi.call(layer);
			}
		},
		
		createLayer: function(layer){
			if(layer.type == 'raster'){
		        var rasterLayer = new ol.layer.Tile({
                	name: layer.name,
//                	extent: ol.proj.transformExtent([48.80, 30, 50, 32], "EPSG:4326", "EPSG:3857"),
                	source: new ol.source.XYZ({
                		tileUrlFunction: function(coordinate) {
	            	        if(coordinate == null){
	            	        	return "";
	            	        } 
	            	        var z = coordinate[0];
	            	        var x = coordinate[1];
	            	        var y = (1 << z) + coordinate[2];
	            	        return '/RasterCache/' + layer.uid + '/' + z + '/' + z + '_' + x + '_'+ y + '.png';
            	        }
                	}),
                	visible: true
                })
		        rasterLayer.setOpacity(1)
		        return rasterLayer;
			}
			
			if(layer.type == 'vector'){
				return new ol.layer.Vector({
					name: layer.name,
					source: new ol.source.Vector(),
					visible: true
				});
			}
		},
		
		onChangeShowLabel: function(layer){
			var features = $scope.map.getLayer(layer.name).getSource().getFeatures();
			if(layer.eye){
				_.forEach(features, function(f){
					f.getStyle().getText().setText(f.get('name'))
					f.changed();
				});
			}else{
				_.forEach(features, function(f){
					f.getStyle().getText().setText(undefined)
					f.changed();
				});
			}
		},
		
		onChangeLayerVisibility: function(layer, checked){
			if(checked){
				$scope.Func.selectLayer(layer);
				$scope.Data.layerList.push(layer);
				if(layer.type == 'raster'){
					$scope.Func.addLayer(layer);
				}else if(layer.type=='vector'){
					pondmapSrvc.getVectorObjectList(layer.uid).then(function(response){
						$scope.Func.addLayer(layer, response.data);
					});
				}
			}else{
				var targetLayer;
				$scope.map.getLayers().forEach(function (lyr) {
					if (layer.name == lyr.get('name')) {
						targetLayer = lyr;
					}            
				});
				for (var i = 0; i < $scope.Data.layerList.length; i++) {
					if(layer.uid == $scope.Data.layerList[i].uid){
						$scope.Data.layerList.splice(i, 1);
						break;
					}
				}
				if(layer.type=='vector')
					targetLayer.getSource().clear();
				$scope.map.removeLayer(targetLayer);
			}
		},
		
		addLayer: function(layer, objects){
			var targetLayer = $scope.Func.createLayer(layer);
			$scope.map.addLayer(targetLayer);
			if(objects){
				if(!layer.metaData)layer.metaData={};
				if(!layer.icon)layer.icon='red';
				if(!layer.color)layer.color='red';
				if(!layer.width)layer.width=1.5;
				if(!layer.fill)layer.fill='rgba(255,255,255,0.5)';

				var randomCoords;
				objects.forEach(function(obj){
					var coords = $scope.Func.addObject(obj, targetLayer, layer);
					if(!randomCoords)randomCoords = coords;
				});
				$scope.map.panToCoords(randomCoords);
			
			}else{
				$scope.Func.onSelectMap(layer.map);
			}
		},
		addObject: function(obj, layer, options){
			var panCoords;
			var text = new ol.style.Text({
		        scale: 1.3,
		        fill: new ol.style.Fill({
		        	color: '#000000'
		        }),
		        stroke: new ol.style.Stroke({
		        	color: '#FFFF99',
		        	width: 3.5
		        })
			});
			if(obj.type == 'Polygon'){
				mapSrvc.createPolygon(layer, {
					uid: obj.uid,
					name: obj.name,
					coords: [obj.polygon.coordinates],
					style: new ol.style.Style({
						fill: new ol.style.Fill({
							color: colorPickerSrvc.convertHex((options.fill?options.fill:'#cccccc'), 50)
						}),
						stroke: new ol.style.Stroke({
							color: options.color,
							width: parseFloat(options.width)
						}),
						text: text
					})
				});
				panCoords = obj.polygon.coordinates[0];
			}else if(obj.type == 'LineString'){
				mapSrvc.createLine(layer, {
					uid: obj.uid,
					name: obj.name,
					coords: obj.line.coordinates,
					style: new ol.style.Style({
					    stroke: new ol.style.Stroke({
					        color: options.color,
					        width: parseFloat(options.width)
					    })
					}),
					text: text
				});
				panCoords = obj.line.coordinates[0];
			}else if(obj.type == 'Point'){
				mapSrvc.createPoint(layer, {
					uid: obj.uid,
					name: obj.name,
					coords: obj.point.coordinates,
					style: new ol.style.Style({
			            image: new ol.style.Icon({
			                anchor: [0.5, 50],
			                anchorXUnits: 'fraction',
			                anchorYUnits: 'pixels',
			                opacity: 0.90,
			                snapToPixel: true,
			                src: 'app/lib/rtmap/assets/img/map-marker-' + options.icon + '.png'
			            }),
			            text: text
			        })
				});
				panCoords = obj.point.coordinates;
			}
			return panCoords;
		},
		
		onVectorObjectClick: function(feature, layer) {
			if(feature && feature.getId()){
				$scope.featureLoading = true;
				if($scope.Data.selectedFeature){
					//TODO reset previous feature style to default
				}
				//TODO set selected style to current feature
				$scope.Data.selectedFeature = feature;
				$scope.timeSeriesMode = 'vector';
				
			    pondmapSrvc.getVectorObject(feature.getId()).then(function(response){

					pondmapSrvc.getEntityType(response.data.layer.formSchemaKey).then(function(res){
						$scope.Data.form = JSON.parse(res.data.schema);
						$scope.Data.pondSchema= JSON.parse(res.data.schema);
						$scope.Data.vectorObject = response.data;
						$scope.leftSideType = "object";
						$scope.Func.onTabClick($scope.Data.tabList[1]);
						$scope.openLeftSide = true;
						$scope.featureLoading = false;
						$scope.Controller.func($scope.Data.vectorObject.uid);

						$timeout(function () {
							$scope.Controller.crud.resetMap();
							if(response.data.formInstance)
							{response.data.formInstance.Things_To_DoName = response.data.name;}

							$scope.Data.selectedFeature = response.data;
							$scope.Data.mapModel.point = response.data.point;
							$scope.Controller.crud.init();
						}, 5000);
					});
			    });
			}
		},
		onCloseInfoPanelClick: function(){
			$scope.Data.vectorObject = null;
			$scope.openLeftSide = false;
			//TODO reset feature style to default
		},
		
		onTabClick: function(tab){
			for (var int = 0; int < $scope.Data.tabList.length; int++) {
				$scope.Data.tabList[int].active = false;
			}
			tab.active = true;
		},
		
		onSearchClick: function(){
			$scope.Data.queryTmp = angular.copy($scope.Data.query);
			pondmapSrvc.searchLayer($scope.Data.query).then(function(response){
				$scope.Data.searchedLayerList = response.data;
			});
			pondmapSrvc.searchVectorObject($scope.Data.query).then(function(res){
				$scope.Data.searchedObjectList = res.data;
			})
		},
		onClearSearchClick: function(){
			$scope.Data.query = "";
			$scope.Data.searchedObjectList = [];
			$scope.Data.searchedLayerList = [];
			var layer = $scope.map.getLayer('search_layer');
			layer.getSource().clear();
		},
		onSearchedObjectClick: function(obj) {
			if (obj.layer.formSchemaKey == "event" && obj.layer.formSchemaKey == "tour_plans") {
				var modalInstance = $uibModal.open({
					size: 'lg',
					templateUrl: 'app/modules/pondmap/modal/event/eventModal.html',
					controller: 'eventModalCtrl',
					resolve: {
						eventObj: function () {
							return obj;
						}
					}
				});
				modalInstance.result.then(function (data) {
					$scope.Func.onClearSearchClick();
					$scope.Func.onCloseInfoPanelClick();
				});
			} else {
				$scope.Data.objTmp = angular.copy(obj);
				var layer = $scope.map.getLayer('search_layer');
				var coords = $scope.Func.addObject(obj, layer, {icon: 'red'});
				$scope.map.panToCoords(coords);
			}
		},
		
		onExportClick: function(){
			$scope.map.exportData(pondmsSrvc);
		},
		onDrawPolygonClick: function(){
			if(!$scope.Data.selectedLayer.type || $scope.Data.selectedLayer.type!='raster')
				return;

			$scope.map.addLayer(new ol.layer.Vector({
				name: 'temp',
				source: new ol.source.Vector()
			}));
			
			var feature = new ol.Feature({geometryType: 'Polygon'});
			feature.singleDraw($scope.map, 'temp').then(function(obj) {
				$scope.polygonFeature = obj.feature;
				$scope.polygonFeature.startEdit($scope.map);
				
				var feature = mapSrvc.createGeojson($scope.polygonFeature);
				var coords = feature.geometry.coordinates[0];
				for (var j=0;j<coords.length;j+=1) {
					var y = coords[j][0];
					var x = coords[j][1];
					coords[j][0] = x;
					coords[j][1] = y;
				}
				feature.geometry.coordinates = feature.geometry.coordinates[0];
				pondmapSrvc.getZonalStatistics($scope.Data.selectedLayer, feature.geometry).then(function(response){
					var modalInstance = $uibModal.open({
						size: 'lg',
						templateUrl: 'app/modules/pondmap/zonalModal.html',
						controller: 'zonalModalCtrl',
						resolve:{
							data: function(){
								return response.data;
							},
							layer: function(){
								return $scope.Data.selectedLayer
							}
						}
					})
					var layer = $scope.map.getOneLayer('temp');
					layer.getSource().clear();
					$scope.map.removeLayer(layer);
				})
			});
		},
		onDrawPointClick: function(){
			if(!$scope.Data.selectedLayer.type || $scope.Data.selectedLayer.type!='raster')
				return;

			$scope.map.addLayer(new ol.layer.Vector({
				name: 'temp',
				source: new ol.source.Vector()
			}));
			
			var feature = new ol.Feature({geometryType: 'Point'});
			feature.singleDraw($scope.map, 'temp').then(function(obj) {
				$scope.pointFeature = obj.feature;
				$scope.pointFeature.startEdit($scope.map);
				var feature = mapSrvc.createGeojson($scope.pointFeature);
				pondmapSrvc.identifyRaster($scope.Data.selectedLayer, feature.geometry).then(function(response){
					var modalInstance = $uibModal.open({
						size: 'sm',
						templateUrl: 'app/modules/pondmap/identifyModal.html',
						controller: 'identifyModalCtrl',
						resolve:{
							data: function(){
								var data = {};
								data.val = response.data;
								data.x = feature.geometry.coordinates[0];
								data.y = feature.geometry.coordinates[1];
								return data;
							},
							layer: function(){
								return $scope.Data.selectedLayer
							}
						}
					})
				})
			});
		},
		
		getFormSchema: function(key){
			pondmapSrvc.getEntityType(key).then(function(response){
				$scope.Data.form = JSON.parse(response.data.schema);
			})
		},
		
		getPondSchemaList: function(){
			pondmapSrvc.getPondSchemaList().then(function(response){
				response.data.originalElement.forEach(function(item){
					if(item.is_secret)
						$scope.Data.pondSecretSchemaList.push(JSON.parse(item.form_schema));
					else
						$scope.Data.pondSchemaList.push(JSON.parse(item.form_schema));
					
					if(item.form_key == 'GENERAL_FORM_SCHEMA_KEY__PUBLIC')
						$scope.Data.pondSchema = JSON.parse(item.form_schema);
				});
			})
		},
		getPondForm: function(pond){
			if(pond){
				pondmapSrvc.getForm(pond.uid, 'GENERAL_FORM_SCHEMA_KEY__PUBLIC').then(function(response){
					$scope.Data.pondForm = response.data;
				});
				
			}
		},
		onShowSchemaFormClick: function(){
			var modalInstance = $uibModal.open({
				size: 'lg',
				templateUrl: 'app/modules/pondmap/pondModal.html',
				controller: 'pondModalCtrl',
				resolve:{
					pondUid: function(){
						return $scope.Data.selectedLayer.pond.uid;
					},
					schemaList: function(){
						return $scope.Data.pondSchemaList;
					},
					secretSchemaList: function(){
						return $scope.Data.pondSecretSchemaList;
					}
				}
			});
			modalInstance.result.then(function(data){
				if(mode == 'add')
					$scope.Func.onSavelayerClick(data);
				else if(mode == 'edit')
					$scope.Func.onUpdatelayerClick(data);
			});
		},
		
		onTimeSeriesClick: function(){
			var modalInstance = $uibModal.open({
				size: 'lg',
				templateUrl: 'app/modules/pondmap/timeSeriesModal.html',
				controller: 'timeSeriesModalCtrl',
				resolve:{
					geoObject: function(){
						if ($scope.timeSeriesMode == 'vector')
							return $scope.Data.vectorObject;
						else if ($scope.timeSeriesMode == 'pond')
							return $scope.Data.selectedLayer.pond;
					}
				}
			});
			modalInstance.result.then(function(data){
				//TODO
			});
		},
		changeEditMode : function () {
			$scope.Data.mode = 'edit';
		},
		deleteModel : function () {
			layerSrvc.deleteFeatureListInstance($scope.Data.vectorObject.organization.uid,$scope.Data.vectorObject.uid).then(function(response){
				$scope.Func.onClearSearchClick();
				$scope.Func.onCloseInfoPanelClick();
			});
		},
		saveEditMode : function () {
			$scope.Data.mode = 'view';
			var data = {};
			data.type = $scope.Data.selectedFeature.type;
			data.formInstance = {};
			for(var i = 0 ; i<$scope.Data.form.viewGroups[0].members.length; i++){
				if($scope.Data.selectedFeature.formInstance[$scope.Data.form.viewGroups[0].members[i]]){
					data.formInstance[$scope.Data.form.viewGroups[0].members[i]] = $scope.Data.selectedFeature.formInstance[$scope.Data.form.viewGroups[0].members[i]];
				}
				else{
					data.formInstance[$scope.Data.form.viewGroups[0].members[i]] = null;
				}
			}
			if(data.formInstance.Things_To_DoName){
				data.name = data.formInstance.Things_To_DoName;
			}
			else if(data.formInstance.RestaurantName){
				data.name = data.formInstance.RestaurantName;
			}
			else if(data.formInstance.HotelName){
				data.name = data.formInstance.HotelName;
			}
			else {
				data.name = null;
			}
			var tempPoint = $scope.Controller.crud.getData("point");
			$scope.Data.mapModel.point= tempPoint.geometry;
			data.point = $scope.Data.mapModel.point;
			$scope.Controller.crud.init();
			data.layer = {};
			data.layer.uid =  $scope.Data.vectorObject.layer.uid;
			data.polygon = null;
			data.line = null;
			if(data.formInstance.Images){
				for(var i = 0 ; i<data.formInstance.Images.length; i++){
                    if (typeof data.formInstance.Images[i] === "string") {
                        data.formInstance.Images[i] = data.formInstance.Images[i];
                    } else {
                        data.formInstance.Images[i] = data.formInstance.Images[i].hash;

                    }
				}
			}
			layerSrvc.updateFeatureListInstance($scope.Data.vectorObject.organization.uid,$scope.Data.vectorObject.uid,data).then(function(response) {
				$scope.Data.mode = 'view';
				$scope.Func.onClearSearchClick();
				$scope.Data.query = angular.copy($scope.Data.queryTmp);
				$scope.Func.onSearchClick();
				$scope.Data.objTmp.point = data.point;
				$scope.Func.onSearchedObjectClick($scope.Data.objTmp);
			});
		},
		cancleEditMode : function () {
			$scope.Data.mode = 'view';
		}
	}
	
	$scope.Controller = {
		treeController:{
			visibilityAction: true,
			getRootList: pondmapSrvc.getGisMapList,
			getNodeInfo: pondmapSrvc.getLayer,
			onSelectNode: $scope.Func.onSelectLayer,
			onSelectRoot: $scope.Func.onSelectMap,
			onChangeLayerVisibility: $scope.Func.onChangeLayerVisibility,
			onChangeShowLabel: $scope.Func.onChangeShowLabel
		}, 
		
		IntroOptions: {
				steps:[
				{
				    element: '#btn-map-export',
				    intro: "با استفاده از گزینه میتوانید تصویر فعلی نقشه را دانلود کنید"
				},
				{
				    element: '#single-button', //TODO this is toff! because this id isn't defined in our code
				    intro: "با استفاده از گزینه میتوانید ترتیب لایه های نمایش داده شده را جا به جا کنید."
//				    position: 'right'
				},
				{
				    element: '.ol-zoom.ol-unselectable.ol-control',
				    intro: "با استفاده از این دکمه ها میتوانید زوم نقشه را کم و زیاد کنید"
				},
				{
				    element: '.circle',
				    intro: "با استفاده از دکمه ها میتوانید روی نقشه جا به جا شوید"
				},
//				{
//				    element: '#search-bar',
//				    intro: "در این بخش می توانید یک عارضه یا لایه را جستجو کنید",
//				},
				{
				    element: '#right-menu-toggle',
				    intro: "با استفاده از دکمه میتوانید پنل نمایش لایه ها را باز و بسته کنید",
					position: 'left',
				},
				].filter(function (obj) {
//				    if(obj.element === '#search-bar' || obj.element==='#right-menu-toggle'){
//				    	return $('#search-bar').hasClass("opened")?false:true;
//				    }
				    return true;
				  }),
				
//				showStepNumbers: false,
				nextLabel: 'بعدی',
				prevLabel: 'قبلی',
				skipLabel: 'کافیه',
				doneLabel: 'فهمیدم'
		},
		crud: {}
	}
	
	$scope.map.on('singleclick', function(evt) {
		this.forEachFeatureAtPixel(evt.pixel, $scope.Func.onVectorObjectClick);
	});
	$scope.Func.getPondSchemaList();
});
