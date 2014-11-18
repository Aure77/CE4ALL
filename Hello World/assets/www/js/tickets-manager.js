function buyTicket(ticketId) {
	cordova.exec(buyTicketSuccess, buyTicketFailure, "NotificationPlugin", "buy-ticket", [ticketId]);
}
function buyTicketSuccess(data){
	alert(data);
}		
function buyTicketFailure(data) {
	alert("FAIL: " + data);
}