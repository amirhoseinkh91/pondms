function Tree(options) {
	
	this.children = [];
	this.initialFromRoots(options.roots);
	//TODO using two types of initial
};

/**
 * @param roots, array of root properties
 */
Tree.prototype.initialFromRoots = function(roots){
	var that = this;
	roots.forEach(function(root){
		that.children.push(new Node(root));
	})
}

Tree.prototype.initialFromNodes = function(nodes){
	//TODO
}

Tree.prototype.removeById = function(id){
	//TODO
}