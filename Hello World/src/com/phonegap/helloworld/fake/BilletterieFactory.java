package com.phonegap.helloworld.fake;

import java.util.HashMap;
import java.util.Map;

public class BilletterieFactory {
	@SuppressWarnings("serial")
	public static Map<Integer, Billet> BILLETS = new HashMap<Integer, Billet>() {{
		put(1090, new Billet(1090, "Billet Parc astérix 1 jour 1 Parc", "Valable jusqu'au 13/05/2015", "Détonnant mélange de 35 attractions et de grands spectacles, le tout dans des décors truffés d'humour gaulois, Parc Astérix,	c'est la \"potion loisirs\" testée et approuvée depuis 1989 par des millions de visiteurs.", 45.0f, Billet.Type.BARRE_CODE, "ce-img-asterix"));
		put(2125, new Billet(2125, "Billet Disneyland Paris 1 jour 1 Parc", "Valable jusqu'au 18/08/2016", "Super parc d'attraction", 70.0f, Billet.Type.QR_CODE, "ce-img-disney"));
		put(1245, new Billet(1245, "Billet Musée du louvre", "Valable jusqu'au 23/07/2017", "Très beau musée", 100.0f, Billet.Type.BARRE_CODE, "ce-img-louvre"));
	}};
	
	public static Billet findTicket(Integer ticketId) {
		return BILLETS.get(ticketId);
	}
}
