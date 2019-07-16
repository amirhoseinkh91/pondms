angular.module('formModule').controller('formCtrl', function($scope, formSrvc) {

	$scope.Data = {
		mode: 'view',
		searchMode: 'none',
		formList: [],
		selectedform: {},
		originalform: {},
		validationClicked: false
	}
	
	$scope.Func = {
		onAddformClick: function(){
			$scope.Data.mode = 'add';
			$scope.Controller.crud.gotoAddMode();
			$scope.Controller.crud.setMode('add');
			$scope.Data.selectedform = {};
		},
		onSelectform: function(form){
			formSrvc.getform(form.key).then(function(response){
				$scope.Data.selectedform = response.data.originalElement;
				$scope.Data.originalform = angular.copy($scope.Data.selectedform);
				$scope.Data.mode='view';
				$scope.Controller.crud.setMode('view');
			});
		},
		onEditformClick: function(){
			$scope.Data.mode = 'edit';
			$scope.Controller.crud.gotoEditMode();
			$scope.Controller.crud.setMode('edit');
		},
		onSaveformClick: function(){
			var sendData = angular.copy($scope.Controller.crud.getFilledModel());
			formSrvc.saveform(sendData).then(function(response){
				$scope.Controller.formListController.refreshList()
				$scope.Func.resetForm();
			});
		},
		onUpdateformClick: function(){
			var sendData = angular.copy($scope.Controller.crud.getFilledModel());
			formSrvc.updateform(sendData).then(function(response){
				$scope.Controller.formListController.refreshList()
				$scope.Func.resetForm();
			});
		},
		onDeleteformClick: function(){
			formSrvc.deleteform($scope.Data.selectedform.uid).then(function(response){
				$scope.Func.resetForm();
				$scope.Func.reset();
				$scope.Controller.formListController.refreshList();
			});
		},
		onCancelClick: function(){
			$scope.Data.selectedform = angular.copy($scope.Data.originalform);
			$scope.Controller.crud.setMode('view');
			$scope.Func.resetForm();
		},
		
		onChangeSearchModeClick: function(mode){
			$scope.Data.searchMode = mode;
		},
		onSearchClick: function(advancedMode){
			$scope.Func.onChangeSearchModeClick('quick');
			$scope.Controller.formListController.searchQuery = $scope.Controller.formSearchController.searchQuery;
			$scope.Controller.formListController.searchableFieldInfo = $scope.Controller.formSearchController.searchableFieldInfo;			
			$scope.Controller.formListController.refreshList(true);
		},
		onExitSearchModeClick: function(){
			$scope.Func.onChangeSearchModeClick('none');
			$scope.Controller.formSearchController.searchQuery = {};
			$scope.Controller.formListController.exitSearchMode();
		},
		
		reset: function(){
			$scope.Data.selectedform = {};
		},
		resetForm: function() {
			$scope.Data.mode = 'view';
			$scope.Data.validationClicked = false;
		}
	}
	
	$scope.Controller = {
		formListController: {
			headers: [
				{key:'key'},
				{key:'name'}
			],
			getList: formSrvc.getFullformList,
			onListItemSelect: $scope.Func.onSelectform,
			searchFunction: formSrvc.searchform,
		},
		formSearchController: {
			advanced: false,
			searchableFieldInfo: [
				{key:"key", type:"string"},
				{key:"name", type:"string"},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		},
		crud: {}
	}
	
	var Run = function(){
	}
	
	Run();
});