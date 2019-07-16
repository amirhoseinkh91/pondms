angular.module('vtGrid', []).directive("vtGrid", function ($http) {
	//www.accessify.com/tools-and-wizards/developer-tools/html-javascript-convertor/
	return {
		restrict: 'AE',
		template:
		"<div class=\"form-group\">" +
		"	<p class=\"help-block\" ng-show=\"Controller.pagination.totalItems!=-1 && controlFn.listItems.length==0\">موردی یافت نشد.<\/p>" +
		"	<table class=\"table table-striped table-hover col-sm-12\" ng-show=\"controlFn.listItems.length>0\">" +
		"		<thead>" +
		"			<tr>" +
		"				<th class=\"listDirectiveTh\" " +
		"					style=\"color: #666666\"" +
		"					ng-repeat=\"field in Data.visibleFields\" " +
		"					ang-click=\"changeOrder(field)\" " +
		"					ng-style=\"{'width':field.width,'text-align':field.textAlign}\">" +
		"						<i ng-if=\"$last\" class=\"fa fa-refresh fa-lg pull-left\" ng-click=\"controlFn.refreshList()\" style=\"cursor:pointer;padding-top:3px;\"><\/i>" +
		"						<div class=\"col-sm-1 ng-hide\" ng-show=\"controlFn.searchQuery.orders && controlFn.searchQuery.orders.length\">" +
		"							<span class=\"caret\" style=\"transform: rotate(180deg);\" ng-show=\"field.asc\"></span>" +
		"							<span class=\"caret\" ng-hide=\"field.asc\"></span>" +
		"						</div>" +
		"						<div aclass=\"col-sm-9\">{{field.label}}</div>" +
		"				<\/th>" +
		"			<\/tr>" +
		"		<\/thead>" +
		"		<tbody>" +
		"			<tr ng-repeat=\"item in controlFn.listItems\" " +
		"					ng-class=\"{'selected':item.isSelected,'{{controlFn.rowNgClass.name}}':controlFn.rowNgClass.expFn(item)}\"" +
		"     				style=\"cursor: pointer; cursor: hand; color: #666666\">" +
		"				<td ng-repeat=\"field in Data.visibleFields\" " +
		"					ng-switch on=\"field.type\" " +
		"					ng-click=\"Func.onListItemClick(item, field)\"" +
		"					class=\"listDirectiveTd\">" +
		"					<span ng-switch-when=\"string\"  ng-bind='item.{{field.key}} |EnToFaNumber|splitString:40' ><\/span>" +
		"					<span ng-switch-when=\"checkbox\"><input type=\"checkbox\" ng-model=\"Data.checked[item.uid]\" ng-change=\"Func.changeSelectedItems(item)\" ><\/span>" +
		"					<span ng-switch-when=\"checkbox2\"><input type=\"checkbox\" ng-model=\"item.selected\" ng-click=\"field.action(item,$event,item.selected)\" ><\/span>" +
		"					<span ng-switch-when=\"int\" ng-bind='item.{{field.key}}|EnToFaNumber'><\/span>" +
		"					<span ng-switch-when=\"date\" ng-bind='item.{{field.key}}|persianDate:field.format|EnToFaNumber'><\/span>" +
		"					<span ng-switch-when=\"timestamp\" ng-bind='item.{{field.key}}|persianDate:field.format|EnToFaNumber'><\/span>" +
		"					<span ng-switch-when=\"long\" ng-bind='item.{{field.key}}|persianDate:field.format|EnToFaNumber'>{{item[field.key]|persianDate:field.format|EnToFaNumber}}<\/span>" +

		"					<span ng-switch-when=\"bool\">" +
		"						<span ng-show=\"item[field.key]\"  class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"><\/span>" +
		"						<span ng-hide=\"item[field.key]\" class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"><\/span>" +
		"					<\/span>" +
		"					<span ng-switch-when=\"boolean\">" +
		"						<span ng-show=\"item[field.key]\" class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"><\/span>" +
		"						<span ng-hide=\"item[field.key]\" class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"><\/span>" +
		"					<\/span>" +
		"					<span ng-switch-when=\"enum\">{{item[field.key]|appEnum:field.filter}}<\/span>" +
		"					<span ng-switch-when=\"action\">" +
		"     					<button class=\"btn btn-default\" type=\"button\"" +
		"     							ng-click=\"field.action(item,$event)\"" +
		"     							ng-class=\"{'{{field.icon}}':field.icon}\"" +
		"     							style=\"cursor: pointer;\">{{field.actionName}}<\/button>" +
		"     				<\/span>" +
		"					<span ng-switch-when=\"actionList\">" +
		"     					<button class=\"btn btn-default\" type=\"button\"" +
		"								ng-repeat=\"btn in field.actionList\"" +
		"     							ng-click=\"btn.action(item,$event)\"" +
		"     							ng-class=\"{'{{btn.icon}}':btn.icon}\"" +
		"     							style=\"cursor: pointer;\"><\/button>" +
		"     				<\/span>" +
		"     				<span ng-switch-when=\"actionLongList\">" +
		"     					<div class=\"dropdown\" ng-switch-when=\"action\">" +
		"							<button class=\"btn btn-default dropdown-toggle\" type=\"button\" id=\"dropdownMenu1\" aria-expanded=\"true\">" +
		"								عملیات " +
		"								<span class=\"caret\"><\/span>" +
		"							<\/button>" +
		"							<ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\">" +
		"								<li role=\"presentation\" ng-repeat=\"action in field.actionList\">" +
		"	     							<a role=\"menuitem\" tabindex=\"-1\" ng-click=\"action.action(item,$event)\">{{action.name}}<\/a>" +
		"								<\/li>" +
		"							<\/ul>" +
		"						<\/div>" +
		"     				<\/span>" +
		"					<span ng-switch-default ng-bind='item.{{field.key}} |EnToFaNumber|splitString:40'><\/span> " +
		"     			<\/td>" +
		"			<\/tr>" +
		"		<\/tbody>" +
		"	<\/table>" +
		"<\/div>" +
		"<ul uib-pagination" +
		"	ng-show=\"!Controller.pagination.inOnePage()\"" +
		"	total-items=\"Controller.pagination.totalItems\"" +
		"	ng-model=\"Controller.pagination.currentPage\"" +
		"	max-size=\"Controller.pagination.maxSize\"" +
		"	items-per-page=\"Controller.pagination.perPage\"" +
		"	ng-change=\"Controller.pagination.pageChanged()\"" +
		"	class=\"pagination-sm\" boundary-links=\"true\"" +
		"	first-text=\"ابتدا\" last-text=\"انتها\" next-text=\"بعدی\" previous-text=\"قبلی\">" +
		"<\/ul>",
		scope: {
			controlFn: '=',
		},
		controller: function ($scope, $element, $attrs, $injector, $q, vtSearchSrvc) {

			$scope.Data = {
				selectedItem: null,
				visibleFields: [],
				checked: {}
			}

			$scope.Func = {
				/* ******************************** Main Functions ******************************** */
				getItemsPerCondition: function () {
					var start = (parseInt($scope.Controller.pagination.currentPage) - 1) * $scope.Controller.pagination.perPage;
					var len = $scope.Controller.pagination.perPage;
					if ($scope.searchMode) {
						var query = vtSearchSrvc.createSearchQuery($scope.controlFn.searchQuery, $scope.controlFn.searchableFieldInfo);
						return $scope.Func.search(query, start, len);
					} else {
						return $scope.Func.getItems(start, len);
					}
				},
				search: function (query, start, len) {
					$scope.searchMode = true;
					var defer = $q.defer();
					if ($scope.controlFn.searchFunction) {
						$scope.controlFn.searchFunction(query, start, len).then(function (response) {
							$scope.Func.processListResponse(response, defer);
						});
					}
					return defer.promise;
				},
				getItems: function (start, len) {
					var defer = $q.defer();
					if ($scope.controlFn.getList) {
						$scope.controlFn.getList(start, len).then(function (response) {
							$scope.Func.processListResponse(response, defer);
						});
					}
					return defer.promise;
				},
				processListResponse: function (response, defer) {
					$scope.Controller.pagination.totalItems = response.data.totalCount;
					$scope.controlFn.listItems = response.data;
					$scope.controlFn.fieldsInfo = response.data.fields;
					$scope.Data.visibleFields = [];
					//Backup Original Data
					_.each($scope.controlFn.listItems, function (item) {
						item.original = angular.copy(item);
					});
					//Create Header of Table
					_.each($scope.controlFn.headers, function (header) {
						if (header.key, $scope.controlFn.listItems.fields) {
							var fieldOfKey = _.find($scope.controlFn.listItems.fields, function (field) {
								return field.key == header.key;
							});
							if (!fieldOfKey) {
								var keys = header.key.split(".")
								fieldOfKey = $scope.Func.findKeyOnFields(keys, $scope.controlFn.fieldsInfo);
							}
							if ((fieldOfKey.type == 'date' || fieldOfKey.type == 'timestamp') && header.format == undefined) {
								header.format = 'dd-MMMM-yyyy';
							}
							$scope.Data.visibleFields.push(angular.extend(fieldOfKey, header));
						} else {
							$scope.Data.visibleFields.push(header);
						}
					});
					//Support Nested Objects
					_.each($scope.controlFn.listItems, function (item) {
						if (!$scope.Func.isFirstFetchingList() && item.uid === $scope.Data.selectedItem.uid) {
							$scope.Func.selectItem(item);
						}
						_.each($scope.Data.visibleFields, function (field) {
							var path = ("item" + "." + field.key).split(".");
							var notNull = path[0];
							for (var i = 1; i < path.length; i++) {
								if (eval(notNull) == null) {
									notNull = null;
									break;
								}
								notNull += "." + path[i];
							}
							if (notNull != null) {
								item[field.key] = eval("item" + "." + field.key);
							}
						});
					});
					defer.resolve($scope.controlFn.listItems);
				},
				changeOrder: function (field) {
					field.asc = !field.asc;
					//TODO push to $scope.query.order
					$scope.controlFn.searchQuery.orders = [{
						field: field.key,
						dir: (field.asc ? "asc" : "des"),
					}];
					$scope.Func.getItemsPerCondition(true);
				},

				/* ******************************** ******************************** */
				onListItemClick: function (item, field) {
					if (field.type != "action" && field.type != "checkbox")
						$scope.Func.selectItem(item);
				},
				selectItem: function (item) {
					if ($scope.Data.selectedItem) {
						$scope.Data.selectedItem.isSelected = false;
					}
					$scope.Data.selectedItem = item;
					$scope.Data.selectedItem.isSelected = true;
					$scope.controlFn.onListItemSelect(item.original);
				},
				changeSelectedItems: function (item) {
					if ($scope.Data.checked[item.uid]) {
						$scope.controlFn.selectedItems.push(item.original);
					} else {
						//Remove from Selected List
						for (var int = 0; int < $scope.controlFn.selectedItems.length; int++) {
							if ($scope.controlFn.selectedItems[int].uid == item.uid) {
								$scope.controlFn.selectedItems.splice(int, 1);
								break;
							}
						}
					}
					if ($scope.controlFn.onChangeSelectedList)
						$scope.controlFn.onChangeSelectedList();
				},
				resetSelectedItems: function () {
					$scope.Data.checked = {};
					$scope.controlFn.selectedItems = [];
                },

				/* ******************************** Auxiliary Functions ******************************** */
				isFirstFetchingList: function () {
					if (!$scope.Data.selectedItem) {
						return true;
					}
					return false;
				},
				findKeyOnFields: function (keys, fields) {
					var key = keys.shift();
					var _field = _.find(fields, function (field) {
						return (field.key == key || key == 'action');
					});
					if (keys.length && _field.fields && _field.fields.length) {
						return $scope.Func.findKeyOnFields(keys, _field.fields)
					} else {
						return _field;
					}
				}
			}

			$scope.Controller = {
				pagination: {
					totalItems: -1,
					currentPage: 1,
					perPage: ($scope.controlFn.pageSize ? $scope.controlFn.pageSize : 10),
					maxSize: 5,
					inOnePage: function () {
						if ($scope.Controller.pagination.totalItems <= $scope.Controller.pagination.perPage)
							return true;
						return false;
					},
					pageChanged: function () {
						$scope.Func.getItemsPerCondition();
					}
				}
			}


			/* ******************************** API ******************************** */
			$scope.controlFn.searchQuery = {};
			$scope.controlFn.listItems = [];
			$scope.controlFn.selectedItems = [];
			$scope.controlFn.fieldsInfo = [];
			$scope.controlFn.resetSelectedItems = $scope.Func.resetSelectedItems;
			$scope.controlFn.refreshList = function (searchMode) {
				$scope.searchMode = (searchMode == undefined) ? $scope.searchMode : searchMode;
				return $scope.Func.getItemsPerCondition();
			}
			$scope.controlFn.exitSearchMode = function () {
				$scope.searchMode = false;
				$scope.Func.getItemsPerCondition();
			}
			$scope.controlFn.getFirstPage = function () {
				$scope.Controller.pagination.currentPage = 1;
				$scope.Func.getItemsPerCondition();
			}

			/* ******************************** RUN ******************************** */
			$scope.Func.getItemsPerCondition();


		},
		link: function (scope, element, attrs, ctrls) {

		}
	};
});