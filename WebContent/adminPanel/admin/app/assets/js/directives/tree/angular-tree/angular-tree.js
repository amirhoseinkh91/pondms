angular.module("angular-tree", []).directive('ngTree', function() {
	return {
		restrict : 'EA',
		templateUrl : 'app/assets/js/directives/tree/angular-tree/angular-tree.html',
		scope : {
			/**
			 * @param onSelectNode
			 * @param getRootList
			 * @param getNodeInfo
			 * 
			 * @return selectedNode
			 * @return addChild
			 * @return updateNode
			 * @return removeNode
			 */
			api: "="
		},
		controller : function($scope) {
			
			$scope.context = TreeContext;
			
			$scope.Func = {
				onRootClick: function(root){
					$scope.api.selectedNode = root;
					$scope.api.onSelectRoot(root.properties);
				},
				onNodeClick: function(node){
					if(!node.properties.type)
						return $scope.Func.onRootClick(node);
					
					$scope.api.selectedNode = node;
					$scope.api.getNodeInfo(node.properties.uid).then(function(response) {
						var temp = node.properties.checked;
						node.properties = response.data.originalElement;
						node.properties.checked = temp;
						node.setChildren(response.data.originalElement[$scope.context.childrenKey]);
						$scope.api.onSelectNode(node.properties);
					});
				},
				
				onExpandClick: function(node){
					if(node.collapsedChildren && node.collapsedChildren.length == node.childCount)
						node.expand()
					else
						$scope.Func.onNodeClick(node);
				},
				
				/**
				 * @param parent, instance of Node
				 * @param node, properties of child node
				 */
				addChild: function(parent, node){
					parent.addChild(node);
				},
				
				/**
				 * @param node, instance of Node
				 * @param properties
				 */
				updateNode: function(node, properties){
					node.updateProperties(properties);
				},
				
				/**
				 * @param id, identifier of removing node
				 */
				removeNode: function(id){
					$scope.node.removeById(id);
				},
				
				onChangeCheckbox: function(node, checked){
					if(!checked)
						node.eye = false;
					$scope.api.getNodeInfo(node.properties.uid).then(function(response) {
						$scope.api.onChangeLayerVisibility(response.data.originalElement, checked)
					});
				},
				onEyeClick: function(node){
					if(node.properties.eye == undefined)node.properties.eye = false;
					node.properties.eye = !node.properties.eye;
					$scope.api.onChangeShowLabel(node.properties);
				}
					
			}
			
			var Run = function(){
				$scope.api.getRootList().then(function(response){
					var roots = [];
					response.data.originalElement.forEach(function(data){
						data.name = data.title;
						roots.push(data);
					})
					$scope.node = new Tree({roots: roots});
				});
				$scope.api.addChild = $scope.Func.addChild;
				$scope.api.updateNode = $scope.Func.updateNode;
				$scope.api.removeNode = $scope.Func.removeNode;
				$scope.api.selectedNode = {};
			}

			Run();
		},
		
		link : function(scope, element, attrs, ctrls) {}
	};
});