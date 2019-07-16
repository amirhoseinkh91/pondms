angular.module('pondFormModule').directive('pondForm', function() {
	return {
		restrict: 'EA',
		templateUrl: 'app/assets/js/directives/pondForm/pondFormTemplate.html',
		scope: {
			isEditMode: "=",
			orgUid: "=",
			pondUid: "=",
			schemaList: "="
			
		},
		controller: function($scope, pondFormSrvc, formManagementSrvc) {

			$scope.api = {};
			$scope.form = {};
			
				
			$scope.onSchemaClick = function(schema){
				$scope.selectedSchema = schema;
				$scope.loading = true;
				pondFormSrvc.getForm($scope.pondUid, schema.key).then(function(response){
					$scope.selectedForm = response.data.originalElement;
					$scope.loading = false;
				})
			}
			
			$scope.onSaveFormClick = function(){
				var form = formManagementSrvc.getDerichData($scope.selectedForm, $scope.selectedSchema);
				pondFormSrvc.saveForm($scope.orgUid, $scope.pondUid, $scope.selectedSchema.key, form).then(function(response){
					//TODO
				});
			}
			
			$scope.onCancelClick = function(){

			}
			
			if($scope.schemaList && $scope.schemaList[0])
				$scope.onSchemaClick($scope.schemaList[0]);
		}
}});