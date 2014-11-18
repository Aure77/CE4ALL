function buyTicket(ticketId) {
	cordova.exec(notifySuccess, notifyFailure, "NotificationPlugin", "buy-ticket", [ticketId]);
}
function buyTicket(ticketId, successCallback, errorCallback) {
	cordova.exec(successCallback, errorCallback, "NotificationPlugin", "buy-ticket", [ticketId]);
}
function notifySuccess(data){
	alert(data);
}		
function notifyFailure(data) {
	alert("FAIL: " + data);
}