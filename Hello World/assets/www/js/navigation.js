function navigate(menuId, url) {
	cordova.exec(notifySuccess, notifyFailure, "NavigationPlugin", "navigate", [menuId, url]);
}
function navigate(menuId, url, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, "NavigationPlugin", "navigate", [menuId, url]);
}
function notifySuccess(data){
	console.log(data);
}		
function notifyFailure(data) {
	alert("FAIL: " + data);
}