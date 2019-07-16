angular.module('homeModule').controller('changePasswordCtrl', function($scope, $state, homeSrvc, vtShowMessageSrvc) {

	$scope.Data = {}
	
	$scope.Func = {
		chackRepeatPassword: function(){
			if($scope.Data.repeatPassword == $scope.Data.sendData.newPassword)
				return true;
			$scope.PasswordForm.repeat.$invalid = true;
			$scope.Data.error = true
			$scope.Data.message = "تکرار رمز عبور نادرست است.";
			return false;
		},
		onChangePasswordClick: function(){
			$scope.Data.error = false;
			if($scope.PasswordForm.$valid && $scope.Func.chackRepeatPassword()){
				homeSrvc.changePassword($scope.Data.sendData).then(function(){
					$state.go('home');
				},function(response){
					$scope.Data.error = true
					$scope.Data.message = response.data.messages[0].text;
				});
			}else{
				$scope.Data.validationClicked = true;
			}
		}
	}
});