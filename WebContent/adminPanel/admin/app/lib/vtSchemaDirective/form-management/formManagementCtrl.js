angular.module('vtFormManagement').controller('formManagementCtrl', function($scope, $rootScope, $state, $uibModal, toaster, entitySrvc, baseSelectSrvc, hotkeys, $location, $timeout) {
	$rootScope.pageTitle = 'طراحی فرم';
	$scope.Data = {
		mode : "none",
		apis : {},
		showIconText : false,
		formItem : {
			title : '',
			properties : {},
			viewGroups : []
		},
		dragItem : {
			picName : '',
			type : '',
			widget : '',
		},
		newProperty : {
			title : '',
			label : ''
		},
		addProp : false,
	}

	$scope.Func = {
		onShowIconTextClick : function() {
			$scope.Data.showIconText = true;
			setTimeout(function() {
				$('.sidebar-component').removeClass('overflow-hidden')
			}, 8000);

		},
		onShowIconClick : function() {
			$scope.Data.showIconText = false
		},
		/*
		 * ********************* Component (Right) *************************
		 */
		onInitSchemaField : function(index) {
			$scope.Data.apis[index] = angular.copy($scope.schemaFormViewModalApi);
			$scope.Data.apis[index].selectedViewGroupIndex = index;
		},
		getFormComponents : function() {
			// TODO: call a service that read components list form
			// external file or server.
			$scope.Data.components = [ {
				picName : 'flaticon-fm-write',
				type : 'string',
				widget : 'textBox',
				persianName : "متن یک خطی"
			},

			{
				picName : 'flaticon-fm-sheet',
				type : 'string',
				widget : 'textarea',
				persianName : "متن چند خطی"
			},

			// {
			// picName : 'flaticon-fm-interface',
			// type : 'entity',
			// widget : 'popupSelector',
			// persianName : "انتخابگر موجودیت"
			// },

			{
				picName : 'flaticon-fm-numbers',
				type : 'integer',
				widget : '',
				persianName : "عدد"
			},
			{
				picName : 'flaticon-fm-numbers',
				type : 'double',
				widget : '',
				persianName : "عدد اعشاری"
			},
			{
				picName : 'flaticon-fm-black',
				type : 'file',
				widget : '',
				persianName : "انتخابگر فایل"

			},

			{
				picName : 'flaticon-fm-sheet',
				type : 'string',
				widget : 'bigText',
				persianName : "متن بزرگ"
			},

			{
				picName : 'flaticon-fm-favorite',
				type : 'attachment',
				widget : 'attachFile',
				persianName : "ضمیمه",
				multiple : true
			}, {
				picName : 'flaticon-fm-interface',
				type : 'enum',
				persianName : "لیست کشویی",
				widget : ''
			},

			{
				picName : 'flaticon-fm-null',
				type : 'date',
				persianName : "تاریخ",
				widget : 'jalali'
			}, {
				picName : 'flaticon-fm-arrow',
				type : 'entitySelector',
				persianName : "انتخابگر موجودیت",
				widget : 'popupSelector'
			}, {
				picName : 'flaticon-fm-chain',
				type : 'relation',
				persianName : "ارتباط",
				widget : ''
			}, {
				picName : 'flaticon-fm-business',
				type : 'html',
				persianName : "محتوای استاتیک",
				widget : ''
			}, {
				picName : 'flaticon-fm-business',
				type : 'placeUid',
				persianName : "شناسه مکان ها",
				widget : 'placeSearch',
				multiple : true
			}, {
				picName : 'flaticon-fm-business',
				type : 'placesPlan',
				persianName : "برنامه های مرتبط با محل",
				widget : '',
				multiple : true
			}, {
				picName : 'flaticon-fm-business',
				type : 'point',
				persianName : "مبدأ - مقصد",
				widget : ''
			}, {
				picName : 'flaticon-fm-business',
				type : 'location',
				persianName : "نقشه",
				widget : ''
			}]
		},
		onRemoveViewGroupClick : function(viewGroup) {
			angular.forEach(viewGroup.members, function(_member) {
				delete $scope.Data.formItem.properties[_member];
			});

			$scope.Data.formItem.viewGroups = _.reject($scope.Data.formItem.viewGroups, function(_viewGroup) {
				return _viewGroup.key == viewGroup.key;
			});
			// viewGroup.splice(index, 1);
		},
		getRequiredList : function() {
			entitySrvc.getEntityTypeList(1, -1).then(function(response) {
				$scope.Data.entityTypeList = response.data;
			});
			baseSelectSrvc.getBaseSelectorList().then(function(response) {
				$scope.Data.baseSelectorList = response.data;
			});
		},
		onStartDragFunction : function(event, position, dragItem) {
			$scope.Data.dragItem = dragItem;
			$scope.DragNewProp = true;

			if ($scope.Data.formItem.properties['addProp']) {
				for (var j = 0; j < $scope.Data.formItem.viewGroups.length; j++) {
					if ($scope.Data.formItem.viewGroups[j].members.indexOf('addProp') != -1) {
						$scope.Func.deleteProp('addProp', $scope.tabActiveIndex);
						break;
					}
				}
			}
		},
		onStopDragFunction : function(event, position, dragItem) {
			// $scope.Func.resetDragItem();
		},

		/* ********************* Form (Left) ************************* */
		getForm : function() {
			$scope.Func.changeTab(0);
			entitySrvc.getEntityTypeChild($state.params.entityTypeKey, true).then(function(response) {
				$scope.Data.newEntityType = response.data;
				delete $scope.Data.newEntityType.originalElement;
				$scope.Data.formItem = response.data.jsonSchema;
				if ($scope.Data.formItem.properties == undefined)
					$scope.Data.formItem = response.data.originalElement;
				// $scope.Func.clearNewProp();
			});
		},
		helpForDrag : function() {
			var modalInstance = $uibModal.open({
				templateUrl : 'management/advancedEntityType/partials/help.html',
				controller : 'helpCtrl',
				size : 'sm'
			});
			modalInstance.result.then(function() {
			}, function() {
			});
		},
		onAddGroupClick : function() {
			var modalInstance = $uibModal.open({
				templateUrl : 'app/lib/vtSchemaDirective/form-management/addViewGroup.html',
				controller : 'addViewGroupCtrl',
				size : 'sm',
				resolve : {
					viewGroup : function() {
						return {
							id : '',
							name : '',
							secretLevel : ''
						};
					},
					viewGroupList : function() {
						return $scope.Data.formItem.viewGroups
					}
				}
			});
			modalInstance.result.then(function(viewGroup) {
				if (!$scope.Data.formItem.viewGroups)
					$scope.Data.formItem.viewGroups = [];
				$scope.Data.formItem.viewGroups.push({
					key : viewGroup.key,
					name : viewGroup.name,
					secretLevel : viewGroup.secretLevel.id,
					members : []
				});
				// $scope.Func.clearNewProp();
				$scope.Func.changeTab($scope.Data.formItem.viewGroups.length - 1);
			}, function() {
			});
		},
		onEditGroupClick : function(viewGroup) {

			$scope.Data.mode = "EDIT-VIEWGROUP";
			$scope.selectedViewGroup = viewGroup;
			// $scope.editingViewGroup = {
			// key : viewGroup.key,
			// name : viewGroup.name,
			// secretLevel : viewGroup.secretLevel
			// }

			$timeout(function() {
				$scope.api.editViewGroup.regenerate();

			}, 1);

			// var modalInstance = $uibModal.open({
			// templateUrl :
			// 'app/modules/management/entityType/addViewGroup.html',
			// controller : 'addViewGroupCtrl',
			// size : 'sm',
			// resolve : {
			// viewGroup : function() {
			// return {
			// id : viewGroup.id,
			// name : viewGroup.name,
			// secretLevel : viewGroup.secretLevel
			// };
			// }
			// }
			// });

			// modalInstance.result.then(function(editedViewGroup) {
			// viewGroup.id = editedViewGroup.id;
			// viewGroup.name = editedViewGroup.name;
			// viewGroup.secretLevel = editedViewGroup.secretLevel.id;
			// }, function() {
			// });
		},
		changeTab : function(index) {
			$scope.tabActiveIndex = index;
			if ($scope.schemaFormViewModalApi)
				$scope.schemaFormViewModalApi.selectedViewGroupIndex = index;
			// $scope.Func.clearNewProp();
		},

		onSelectEntityType : function(entityType) {
			$scope.Data.dragItem.type = entityType.entityKey;
		},
		onSelectEnumType : function(enumType) {
			$scope.enumType = enumType;
		},
		onAddProperty : function(index) {
			var title = 'addProp';
			var prop = {
				type : 'property',
				widget : 'add'
			};
			$scope.Data.formItem.properties[title] = prop;
			$scope.Data.formItem.viewGroups[index].members.splice($scope.insertPropIndex, 0, title);

		},
		deleteProp : function(prop, index) {
			delete $scope.Data.formItem.properties[prop];
			$scope.Data.formItem.viewGroups[index].members.splice($scope.Data.formItem.viewGroups[index].members.indexOf(prop), 1);
		},
		editProperty : function(prop) {
			var temp = $scope.Data.formItem.properties[prop];
			temp['title'] = prop;
			$scope.editingProp = temp;

			$timeout(function() {
				$scope.api.editProp.regenerate();
			}, 1);

			// var modalInstance = $uibModal.open({
			// templateUrl :
			// 'app/modules/management/advancedEntityType/editPropTemplate.html',
			// controller : 'editPropCtrl',
			// size : 'md',
			// resolve : {
			// property : function() {
			// var temp = $scope.Data.formItem.properties[prop];
			// temp['title'] = prop;
			// return temp;
			// },
			// entityTypeList : function() {
			// return $scope.Data.entityTypeList;
			// },
			// baseSelectorList : function() {
			// return $scope.Data.baseSelectorList;
			// }
			// }
			// });

			// modalInstance.result.then(function(newProperty) {
			//
			// }, function() {
			// });
		},
		clearNewProp : function() {
			$scope.Data.newProperty.title = '';
			$scope.Data.newProperty.label = '';
		},

		/*
		 * ********************* Functionality (Up) *************************
		 */
		onSaveFormClick : function() {

			if (_.isEmpty($scope.Data.formItem["extents"])) {
				angular.forEach($scope.Data.formItem.properties, function(prop, propKey) {
					if (prop.required) {

						if (_.isArray($scope.Data.formItem["extents"].list)) {
							$scope.Data.formItem["extents"].list.push(propKey);
						} else {
							$scope.Data.formItem["extents"].list = [ propKey ]
						}
						if (_.isArray($scope.Data.formItem["extents"].enriched)) {
							$scope.Data.formItem["extents"].enriched.push(propKey);
						} else {
							$scope.Data.formItem["extents"].enriched = [ propKey ]

						}

					}

				});

				if (!$scope.Data.formItem["extents"].list || _.isEmpty($scope.Data.formItem["extents"].list)) {
					$scope.Data.formItem["extents"].list = _.keys($scope.Data.formItem.properties);
					$scope.Data.formItem["extents"].enriched = _.keys($scope.Data.formItem.properties);
				}
			}

			// $scope.Data.formItem["extents"] =
			// $scope.Data.formItem["extents"] || {};

			delete $scope.Data.newEntityType.jsonSchema
			$scope.Data.newEntityType.schema = JSON.stringify($scope.Data.formItem);
			entitySrvc.updateEntityType($scope.Data.newEntityType).then(function() {

				toaster.pop("success", "با موفقیت ذخیره شد");

				entitySrvc.removeEntityTypeFromCache($scope.Data.newEntityType.entityKey);
				// $state.go("home.management.advancedEntityType", {});
			});
		},
		onReturnClick : function() {
			// $state.go("home.management.advancedEntityType", {});
		},

		/*
		 * ********************* Error Checking (Down) *************************
		 */
		checkPropInput : function() {
			$scope.hasError = false;
			$scope.hasError_pTitle = false;
			$scope.hasError_pName = false;
			if ($scope.Data.newProperty.title == "") {
				$scope.hasError = true;
				$scope.hasError_pTitle = true;
			}
			if ($scope.Data.newProperty.label == "") {
				$scope.hasError = true;
				$scope.hasError_pName = true;
			}
			return !$scope.hasError;
		},

		checkUrlValidation : function(string) {
			if (string.indexOf('!') > -1 || string.indexOf('*') > -1 || string.indexOf('\'') > -1 || string.indexOf('(') > -1 || string.indexOf(')') > -1 || string.indexOf(';') > -1 || string.indexOf(',') > -1 || string.indexOf('@') > -1 || string.indexOf('&') > -1 || string.indexOf('=') > -1 || string.indexOf('+') > -1 || string.indexOf('$') > -1 || string.indexOf('/') > -1 || string.indexOf('?') > -1 || string.indexOf('%') > -1 || string.indexOf('#') > -1 || string.indexOf('[') > -1 || string.indexOf(']') > -1) {
				return false;
			}
			return true;
		},
		correctUrlValidation : function(str) {
			return str.replace(/ /g, "_").replace(/!/g, "").replace(/\*/g, "").replace(/\\/g, "").replace(/\(/g, "").replace(/\)/g, "").replace(/;/g, "").replace(/,/g, "").replace(/&/g, "").replace(/=/g, "").replace(/\+/g, "").replace(/\$/g, "").replace(/\//g, "").replace(/\?/g, "").replace(/%/g, "").replace(/#/g, "").replace(/\[/g, "").replace(/\]/g, "").replace(/@/g, "");
		},

	}

	$scope.droppable = {
		onDrop : "droppable.onDropFunction()",
		onDropFunction : function(event, position) {

			// calculate position in properties list
			$scope.insertPropIndex = 1;
			// var elements = document.getElementsByClassName("sortableSchema");
			// var tabs =
			// document.getElementsByClassName("bhoechie-tab-content");
			// for (var index = 0; index < elements.length; index++) {
			// var topPositopn = elements[index].getBoundingClientRect().top -
			// tabs[0].getBoundingClientRect().top;
			// if (position.position.top < topPositopn) {
			// $scope.insertPropIndex = index;
			// break;
			// }
			// }

			if ($scope.DragNewProp) {
				$scope.Func.clearNewProp();
				$scope.Func.onAddProperty(angular.element(event.target).scope().$index);
				$scope.DragNewProp = false;
				$scope.Func.getFormComponents();
			}
		},
	}

	$scope.Func.getForm();
	$scope.Func.getFormComponents();
	$scope.Func.getRequiredList();
	$scope.schemaFormViewModalApi = {
		isSortable : true,
		selectedViewGroupIndex : $scope.tabActiveIndex,
		onInit : function() {
		},
		onEditPropClick : function(prop) {
			$scope.Data.mode = "EDIT-PROP";
			$scope.Func.editProperty(prop);
		},
		onDeletePropertyClick : function(prop) {
			$scope.Func.deleteProp(prop, $scope.tabActiveIndex);
		},
		onAddPropertyClick : function(prop) {
			var tempTitle = prop.title;
			$scope.Func.deleteProp('addProp', $scope.tabActiveIndex);
			delete prop.title;
			$scope.Data.formItem.properties[tempTitle] = prop;
			$scope.Data.formItem.viewGroups[$scope.tabActiveIndex].members.splice($scope.insertPropIndex, 0, tempTitle);
		},
		getDragItem : function() {
			return $scope.Data.dragItem;
		},
		checkDuplicateProp : function(prop) {
			if ($scope.Data.formItem.properties[prop.title])
				return true;
			return false;
		}
	}

	$scope.api = {
		editProp : {
			onSaveClick : function(newProperty) {
				var tempTitle = newProperty.title;
				// delete newProperty.title;
				delete $scope.Data.formItem.properties[tempTitle];
				var tmpViewGroups = angular.copy($scope.Data.formItem.viewGroups);
				delete $scope.Data.formItem.viewGroups;

				$timeout(function() {
					$scope.Data.formItem.properties[tempTitle] = newProperty;
					$scope.Data.formItem.viewGroups = angular.copy(tmpViewGroups);
				}, 1)

			},
			onCancelClick : function() {
				$scope.Data.mode = "none";
			}
		},
		editViewGroup : {
			onSaveClick : function(editedViewGroup) {
				$scope.selectedViewGroup.key = editedViewGroup.key;
				$scope.selectedViewGroup.name = editedViewGroup.name;
				$scope.selectedViewGroup.secretLevel = editedViewGroup.secretLevel.id;
			},
			onCancelClick : function() {
				$scope.Data.mode = "none";
			}
		}

	}

});