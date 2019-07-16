angular.module('userModule').controller('userCtrl', function($scope, $state, userSrvc, userroleSrvc) {

	$scope.Data = {
		orgUid: $state.params.orgUid,
		mode: 'view',
		searchMode: 'none',
		userList: [],
		selecteduser: {
		},
		originaluser: {},
		validationClicked: false,
		userrolelist: []
	}
	
	$scope.Func = {
		onAdduserClick: function(){
			$scope.Data.mode = 'add';
			$scope.Data.selecteduser = {roles: $scope.Data.userroleList};
		},
		onSelectuser: function(user){
			userSrvc.getuser($scope.Data.orgUid, user.uid).then(function(response){
				$scope.Data.selecteduser = response.data.originalElement;
				$scope.Data.originaluser = angular.copy($scope.Data.selecteduser);
				$scope.Data.mode='view';
			});
		},
		onEdituserClick: function(){
			$scope.Data.mode = 'edit';
		},
		onSaveuserClick: function(){
			if($scope.userForm.$valid){
				userSrvc.saveuser($scope.Data.orgUid, $scope.Data.selecteduser).then(function(response){
					$scope.Controller.userListController.refreshList()
					$scope.Func.resetForm();
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		},
		onUpdateuserClick: function(){
			if($scope.userForm.$valid){
				userSrvc.updateuser($scope.Data.orgUid, $scope.Data.selecteduser).then(function(response){
					$scope.Controller.userListController.refreshList()
					$scope.Func.resetForm();
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		},
		onDeleteuserClick: function(){
			userSrvc.deleteuser($scope.Data.orgUid, $scope.Data.selecteduser.uid).then(function(response){
				$scope.Func.resetForm();
				$scope.Func.reset();
				$scope.Controller.userListController.refreshList();
			});
		},
		onCancelClick: function(){
			$scope.Data.selecteduser = angular.copy($scope.Data.originaluser);
			$scope.Func.resetForm();
		},
		
		onChangeSearchModeClick: function(mode){
			$scope.Data.searchMode = mode;
		},
		onSearchClick: function(advancedMode){
			if(advancedMode){
				$scope.Func.onChangeSearchModeClick('advanced');
				$scope.Controller.userListController.searchQuery = $scope.Controller.userAdvancedSearchController.searchQuery;
				$scope.Controller.userListController.searchableFieldInfo = $scope.Controller.userAdvancedSearchController.searchableFieldInfo;
			}else{
				$scope.Func.onChangeSearchModeClick('quick');
				$scope.Controller.userListController.searchQuery = $scope.Controller.userSearchController.searchQuery;
				$scope.Controller.userListController.searchableFieldInfo = $scope.Controller.userSearchController.searchableFieldInfo;			
			}
			$scope.Controller.userListController.refreshList(true);
		},
		onExitSearchModeClick: function(){
			$scope.Func.onChangeSearchModeClick('none');
			$scope.Controller.userAdvancedSearchController.searchQuery = {};
			$scope.Controller.userSearchController.searchQuery = {};
			$scope.Controller.userListController.exitSearchMode();
		},
		
		getuserroleList: function(){
			userroleSrvc.getExtenduserroleList().then(function(response){
				$scope.Data.userroleList = response.data.originalElement;
				_.map($scope.Data.userroleList, function(userrole) {
					userrole.active = false;
					return userrole;
				});
			});
		},
		
		reset: function(){
			$scope.Data.selecteduser = {};
		},
		resetForm: function() {
			$scope.Data.mode = 'view';
			$scope.Data.validationClicked = false;
		}
	}
	
	$scope.Controller = {
		userListController: {
			headers: [
				{key:'username'},		
				{key:'firstName'},		
				{key:'lastName'},
				{key:'enabled'}
			],
			getList: function(start, len){
				return userSrvc.getFulluserList($scope.Data.orgUid, start, len);
			},
			onListItemSelect: $scope.Func.onSelectuser,
			searchFunction: function(query, start, len){
				return userSrvc.searchuser($scope.Data.orgUid, query, start, len);
			}
		},
		userSearchController: {
			advanced: false,
			searchableFieldInfo: [
				{key:"username", type:"string", label:"نام کاربری"},
				{key:"firstName", type:"string", label:"نام"},
				{key:"lastName", type:"string", label:"نام خانوادگی"},
				{key:"enabled", type:"bool", label:"فعال"},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		},
		userAdvancedSearchController: {
			advanced: true,
			searchableFieldInfo: [
				{key:"username", type:"string", label:"نام کاربری"},
				{key:"firstName", type:"string", label:"نام"},
				{key:"lastName", type:"string", label:"نام خانوادگی"},
				{key:"enabled", type:"bool", label:"فعال بودن"},
			],
			onSearchClick: $scope.Func.onSearchClick,
			onExitSearchModeClick: $scope.Func.onExitSearchModeClick
		}
	}
	
	var Run = function(){
		$scope.Func.getuserroleList();
	}
	
	Run();
});