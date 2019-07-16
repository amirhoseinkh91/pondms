angular.module('rtmap').run(function($q){
	ol.Popup = function(opt_options) {
		var options = opt_options || {};
		this.map = opt_options.map;
		this.panMapIfOutOfView = options.panMapIfOutOfView || true;
		this.ani = options.ani || ol.animation.pan;
		this.ani_opts = options.ani_opts || {'duration': 250};
		
		this.container = document.createElement('div');
		this.container.className = 'ol-popup';
		
		this.closer = document.createElement('a');
		this.closer.className = 'ol-popup-closer';
		this.closer.href = '#';
		this.container.appendChild(this.closer);
		
		var that = this;
		this.closer.addEventListener('click', function(evt) {
			that.container.style.display = 'none';
			that.open = false;
			that.closer.blur();
			evt.preventDefault();
		}, false);
		
		this.content = document.createElement('div');
		this.content.className = 'ol-popup-content';
		this.container.appendChild(this.content);
		this.open = false;

		ol.Overlay.call(this, {
			element: this.container,
			stopEvent: true,
		});
	};

	ol.inherits(ol.Popup, ol.Overlay);
	
	ol.Popup.prototype.show = function(coord, html, pan) {
		this.hide();
		if(html){
			this.open = true;
			this.setPosition(coord);
			this.content.innerHTML = html;
			this.container.style.display = 'block';
			if (this.panMapIfOutOfView && pan) {
				this.panIntoView_(coord);
			}
			this.content.scrollTop = 0;
			return this;
		}
	};
	
	ol.Popup.prototype.hide = function() {
		this.container.style.display = 'none';
		this.open = false;
		return this;
	};
	
	ol.Popup.prototype.isOpen = function() {
		return this.open;
	};
	
	ol.Popup.prototype.changePosition = function(coord) {
		this.setPosition(coord);
	};
	
	ol.Popup.prototype.changePositionByPoint = function(point){
		this.changePosition(point.coordinates);
	}
	
	ol.Popup.prototype.panIntoView_ = function(coord) {
		
		var popSize = {
				width: this.getElement().clientWidth + 20,
				height: this.getElement().clientHeight + 20
		},
		mapSize = this.map.getSize();
		
		var tailHeight = 20,
		tailOffsetLeft = 60,
		tailOffsetRight = popSize.width - tailOffsetLeft,
		popOffset = this.getOffset(),
		popPx = this.map.getPixelFromCoordinate(coord);
		
		var fromLeft = (popPx[0] - tailOffsetLeft),
		fromRight = mapSize[0] - (popPx[0] + tailOffsetRight);
		
		var fromTop = popPx[1] - popSize.height + popOffset[1],
		fromBottom = mapSize[1] - (popPx[1] + tailHeight) - popOffset[1];
		
		var center = this.map.getView().getCenter(),
		curPx = this.map.getPixelFromCoordinate(center),
		newPx = curPx.slice();
		
		if (fromRight < 0) {
			newPx[0] -= fromRight;
		} else if (fromLeft < 0) {
			newPx[0] += fromLeft;
		}
		
		if (fromTop < 0) {
			newPx[1] += fromTop;
		} else if (fromBottom < 0) {
			newPx[1] -= fromBottom;
		}
		
		if (this.ani && this.ani_opts) {
			this.ani_opts.source = center;
			this.map.beforeRender(this.ani(this.ani_opts));
		}
		
		if (newPx[0] !== curPx[0] || newPx[1] !== curPx[1]) {
			this.map.getView().setCenter(this.map.getCoordinateFromPixel(newPx));
		}
		return this.map.getView().getCenter();
	};
});