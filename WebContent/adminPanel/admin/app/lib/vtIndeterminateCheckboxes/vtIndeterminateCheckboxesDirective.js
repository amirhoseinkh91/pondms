angular.module('vtIndeterminateCheckboxes', []).directive('vtIndeterminateCheckboxes', function($timeout) {
	return {
		restrict : 'EA',
		require:'ngModel',
		templateUrl : 'app/lib/vtIndeterminateCheckboxes/vtIndeterminateCheckboxes.html',
		scope : {
			oneCheckbox : "=?",
			title : '@',
			mode : '='
		},
		link: function ($scope, $element, $attrs,ctrl) {
			
			$scope.$watch(function(){return $scope.mode},function(){
				return $scope.mode
			});
			$scope.$watch(function(){return ctrl.$modelValue}, function() {
				var isBlack=false;
				
				$scope.informationList = ctrl.$modelValue;
				
				$timeout(function(){
					
					$('.indeterminate-checkboxes .indeterminate-checkboxes-tr').each(function(index) {
						  
						  if($("td input[type='checkbox']").eq(index).prop("checked")!=$("td input[type='checkbox']").eq(0).prop("checked")){
							  
							  isBlack=true;
						  }
						  
					    });
					
					if(isBlack){
						  $('.indeterminate-checkboxes .indeterminate-checkboxes-thead-th').find('input[type="checkbox"]').prop({
							    indeterminate: true,
							    checked: $( ".checkbox-0" ).prop('checked')
							  });
						 
					  }else if(!isBlack){
						  $('.indeterminate-checkboxes .indeterminate-checkboxes-thead-th').find('input[type="checkbox"]').prop({
							    indeterminate: false,
							    checked: $( ".checkbox-1" ).prop('checked')
							  });
						 
					  }
					
					$scope.indeterminateValue=$('.checkbox-0').prop('indeterminate');
					$scope.checkedValue=$('.checkbox-0').prop('checked');
				},100)
					   
				  
				
				
				
				
				
			   })
			 updateModelFromElement = function() {
		            // If modified
				
				
					 ctrl.$setViewValue($scope.informationList);
				 

		            		
		            
		        };
			
			
			if($scope.oneCheckbox || $scope.oneCheckbox=="true"){
				$timeout(function(){
					var $check = $("input[type=checkbox].indeterminate-one-checkboxes"),
					  el;

					$check
					  .data('checked', 0)
					  .click(function(e) {

					    el = $(this);

					    switch (el.data('checked')) {

					      // unchecked, going indeterminate
					      case 0:
					        el.data('checked', 1);
					        el.prop('indeterminate', true);
					        ctrl.$setViewValue(undefined);
					        break;

					        // indeterminate, going checked
					      case 1:
					        el.data('checked', 2);
					        el.prop('indeterminate', false);
					        el.prop('checked', true);
					        ctrl.$setViewValue(true);
					        break;

					        // checked, going unchecked
					      default:
					        el.data('checked', 0);
					        el.prop('indeterminate', false);
					        el.prop('checked', false);
					        ctrl.$setViewValue(false);

					    }

					  });
				},1)
				
			}else{
				
				$( ".checkbox-0" ).change(function(){
					$('.indeterminate-checkboxes').find('input[type="checkbox"]').prop({
					    indeterminate: false,
					    checked: $( ".checkbox-0" ).prop('checked')
					  });
				  $timeout(function(){
					  for (var i = 0; i < $scope.informationList.features.length; i++) {
						  $scope.informationList.features[i].active = $( ".checkbox-0" ).prop('checked');
					}  
				  },1)
				});
				
				
				
				
				$scope.onCheckBoxChange = function(e) {
					
					  var checked = $(e).prop("checked"),
					  	all = true,
					  	isBlack = false,
					    container = $(e).parent();
					  $('.indeterminate-checkboxes .indeterminate-checkboxes-tr').each(function(index) {
						  
						  if($("td input[type='checkbox']").eq(index).prop("checked")!=$("td input[type='checkbox']").eq(0).prop("checked")){
							  //is black rect
							  isBlack=true;
						  }
						  
					    });
					  
					  
					  
					  if(container.hasClass('indeterminate-checkboxes-thead-th')){
						  
						  $('.indeterminate-checkboxes').find('input[type="checkbox"]').prop({
							    indeterminate: false,
							    checked: checked
							  });
						  $timeout(function(){
							  for (var i = 0; i < $scope.informationList.features.length; i++) {
								  $scope.informationList.features[i].active = checked;
							}  
						  },1)
						  
						  
						  
						  
						  
					  }else if(container.hasClass('') && isBlack){
						  $('.indeterminate-checkboxes .indeterminate-checkboxes-thead-th').find('input[type="checkbox"]').prop({
							    indeterminate: true,
							    checked: checked
							  });
					  }else if(container.hasClass('') && !isBlack){
						  $('.indeterminate-checkboxes .indeterminate-checkboxes-thead-th').find('input[type="checkbox"]').prop({
							    indeterminate: false,
							    checked: checked
							  });
					  }
					  	
					  updateModelFromElement();		
					  
					  	
					     

					  

					 
					};
						
			}
			
		},
		controller : function($scope, $element, $attrs) {
			
		}
	}
});