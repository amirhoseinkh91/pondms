angular.module('schemaForm').factory('entitySelectorSrvc', [ 'Restangular', '$q','$uibModal', function(Restangular, $q,$uibModal) {
	return {
		openEntityInfoModal:function(entityModel,entityTypeKey){
			var modalInstance = $uibModal.open({
				templateUrl : 'app/lib/vtSchemaDirective/components/entitySelector/partials/entityViewModalTemplate.html',
				controller : 'viewEntityModalCtrl',
				windowClass : 'modal-XLarge',
				backdrop : 'static',
				resolve : {
					entity : function() {
						return entityModel;
					},
					entityTypeKey : function() {
						return entityTypeKey;
					}
				}
			});
			return modalInstance.result;
		}
		
	};
} ]);