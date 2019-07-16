angular.module('rtmap').run(function(olMapDefaults, MAP_CONFIG){
	//TODO use options
	ol.RTMap = function(options){
		//initiate layers
		var layers = [
			new ol.layer.Group({
                'name': 'base_map_group',
                'label': 'نقشه پایه',
                layers: [
                    new ol.layer.Tile({
                    	name: 'internal_map',
                    	label: 'نقشه داخلی',
                    	type: 'base',
                        visible: true,
                    	source: new ol.source.XYZ({
                    		url: MAP_CONFIG.mapServerAddress,
                    		crossOrigin:"Anonymous"
                    	})
                    }),
                    new ol.layer.Tile({
                        name: 'OSM',
                        label: 'OSM',
                        type: 'base',
                        visible: false,
                        source: new ol.source.OSM()
                    })
                ]
            })
		];

		if(options.layers){
			for (var int = 0; int < options.layers.length; int++) {
				layers.push(options.layers[int]);				
			}
		}
		
		//initiate controls
		var controls = ol.control.defaults({
            attribution: true,
            rotate: false,
            zoom: true
        });
		controls.push(new ol.control.ScaleLine());
		controls.push(new ol.control.MousePosition({
        	coordinateFormat: ol.coordinate.createStringXY(4),
        	projection: 'EPSG:4326',
        	className: 'custom-mouse-position'
        }));
		
		//initiate view
		var view = new ol.View({
            projection: ol.proj.get('EPSG:3857'),
            center: ol.proj.fromLonLat(options.center?options.center:MAP_CONFIG.center),
            maxZoom: options.maxZoom?options.maxZoom:MAP_CONFIG.maxZoom,
            minZoom: options.minZoom?options.minZoom:MAP_CONFIG.minZoom,
            zoom: options.zoom?options.zoom:MAP_CONFIG.zoom
        });

		//call
		ol.Map.call(this, {
			target: options.target,
			layers: layers,
			view: view,
	        controls: controls,
	        interactions: ol.interaction.defaults({mouseWheelZoom: true}),
	        renderer: 'canvas'
		});
	}

	ol.inherits(ol.RTMap, ol.Map);

	ol.RTMap.prototype.getOneLayer = function(layerName){
		var resultLayer = null;
		var find = function(layer){
			if(layer.get('name') == layerName)
				resultLayer = layer;
		}
		this.getLayers().forEach(function(layer){
			if (layer instanceof ol.layer.Group) {
				layer.getLayers().forEach(find);
			}
			find(layer);
		})
		return resultLayer;
	};
	
	ol.RTMap.prototype.getLayer = function(name){
		var targetLayer;
		this.getLayers().forEach(function (lyr) {
			if (name == lyr.get('name')) {
				targetLayer = lyr;
			}            
		});
		return targetLayer;
	};
	
	ol.RTMap.prototype.exportData = function(srvc){
		this.once('postcompose', function(event) {
			var canvas = event.context.canvas;
			srvc.downloadByLink(canvas.toDataURL('image/png'), 'map.png');
		});
		this.renderSync();
	};
	
	ol.RTMap.prototype.getFeatureById = function(id) {
		var layers = this.getLayers().getArray();
		var resultFeature;
		for (var int = 0; int < layers.length; int++) {
			if(layers[int] instanceof ol.layer.Group){
				//TODO
			}else{
				var feature = layers[int].getSource().getFeatureById(id);
				if(feature){
					return feature
				}
			}
		}
	};
	
	ol.RTMap.prototype.panToCoords = function(coords){
		var pan = ol.animation.pan({
		    duration: 500,
		    source: this.getView().getCenter()
		});
		this.beforeRender(pan);
		this.getView().setCenter(new ol.geom.Point(coords).transform('EPSG:4326', 'EPSG:3857').getCoordinates());
	}
	
	ol.RTMap.prototype.changeConfig = function(config){
		this.getView().setZoom(config.defaultZoom);
		this.panToCoords(config.center.coordinates);
	}
	
});