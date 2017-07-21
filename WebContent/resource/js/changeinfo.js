/**
 * 
 */


function changeinfo( v) {

	var cs = document.getElementById(v).getElementsByTagName("input") 
	for(var i=0;i<cs.length;i++){
		cs[i].disabled;
	}

	}
