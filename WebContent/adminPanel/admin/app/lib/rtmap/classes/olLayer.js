angular.module('rtmap').run(function(){
	ol.layer.Vector.prototype.clear = function(){
		this.getSource().clear();
	};
	
	ol.layer.Vector.prototype.addFeature = function(feature){
		this.getSource().addFeature(feature);
	};
	
	ol.layer.Vector.prototype.getFeatureById = function(id){
		return this.getSource().getFeatureById(id);
	};

});