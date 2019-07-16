/**
 * @author Ali Yadegari
 * 
 * @param properties
 * @param childCountKey, key of child count field (must be integer) in properties
 * @param childrenKey, key of children field (must be array) in properties
 * 
 * if anyone of key be null, it reads from TreeContext
 * set id and title base on properties fields
 */
function Node(properties){
	
	this.properties = properties;
	this.title = properties[TreeContext.titleKey];
	this.id = properties[TreeContext.identifierKey];
	this.childCount = properties[TreeContext.childCountKey];
	this.setChildren(properties[TreeContext.childrenKey]);
}

/**
 * set children by overriding existing children
 * override childCount by length of children
 * 
 * @param children, an array of children properties
 */
Node.prototype.setChildren = function(children){
	this.children = [];
	if(children && Array.isArray(children)){
		this.childCount = 0;
		this.addChildren(children)
	}
}

/**
 * add an array of children to existing children
 * update childCount value
 *
 * @param children, an array of children properties
 */
Node.prototype.addChildren = function(children){
	var that = this;
	children.forEach(function(node){
		that.addChild(node);
	})
}

/**
 * add a child
 * update childCount
 * 
 * @param properties, new child properties
 */
Node.prototype.addChild = function(properties){
	this.children.push(new Node(properties));
	this.childCount = this.childCount + 1;
}

/**
 * remove each children that match with input property and all its children
 * 
 * @param propertyKey
 * @param propertyValue
 * @return number of removed children
 */
Node.prototype.removeChildren = function(propertyKey, propertyValue){
	var index = 0;
	var count = 0;
	this.children.forEach(function(node){
		if(node.properties[propertyKey] == propertyValue){
			this.children.splice(index);
			this.childCount = this.childCount - 1;
			count = count - node.getSubTreeChildCount();
		}
		index = index + 1;
	})
	return count;
}


/**
 * @return number of its childCount and children's childCount recursively
 */
Node.prototype.getSubTreeChildCount = function(){
	var count = this.childCount;
	this.children.forEach(function(node){
		count = count + node.getSubTreeChildCount();
	})
	return count;
}


Node.prototype.collapse = function(){
	this.collapsedChildren = this.children;
	this.children = [];
}

Node.prototype.expand = function(){
	this.children = this.collapsedChildren;
}

Node.prototype.updateProperties = function(properties){
	this.properties = properties;
	this.title = properties[TreeContext.titleKey];
	this.id = properties[TreeContext.identifierKey];
}

