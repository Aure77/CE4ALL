function buyTicket(ticket) {
	cordova.exec(buyTicketSuccess, buyTicketFailure, "NotificationPlugin", "buy-ticket", [ticket]);
}
function buyTicketSuccess(data) {
	var value = JSON.parse(localStorage.getItem("tickets")) || [];
	value.push(data.ticket);
	localStorage.setItem("tickets", JSON.stringify(value));
	location.href = "mesBillets.html";
}		
function buyTicketFailure(data) {
	alert("FAIL: " + data);
}