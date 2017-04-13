var head = document.getElementsByTagName("body")[0];
var bootPATH = "";
(function() {
	var scripts = head.getElementsByTagName("script");
	//alert('test'+script.toString);
	for (var i = 0; i < scripts.length; i++) {
		var script = scripts[i];
		var regex = /boot\.js(\?v=.*)?/ig;
		result = regex.exec(script.src);
		if (result) {
			bootPATH = script.src.substring(0,script.src.lastIndexOf("scripts/boot.js")-1);
			if (result[1]) {
				version = result[1];
			}
			break;
		}
	}
})();