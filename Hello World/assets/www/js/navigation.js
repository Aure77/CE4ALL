function navigate(menuId, url) {
	cordova.exec(notifySuccess, notifyFailure, "NotificationPlugin", "navigate", [menuId, url]);
}
function navigate(menuId, url, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, "NotificationPlugin", "navigate", [menuId, url]);
}
function notifySuccess(data){
	console.log(data);
}		
function notifyFailure(data) {
	alert("FAIL: " + data);
}