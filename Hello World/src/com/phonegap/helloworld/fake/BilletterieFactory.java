package com.phonegap.helloworld.fake;

import java.util.HashMap;
import java.util.Map;

public class BilletterieFactory {
	@SuppressWarnings("serial")
	public static Map<Integer, Billet> BILLETS = new HashMap<Integer, Billet>() {{
		put(1, new Billet(1, "Billet Parc astérix 1 jour 1 Parc", "Valable jusqu'au 13/05/2015", "Détonnant mélange de 35 attractions et de grands spectacles, le tout dans des décors truffés d'humour gaulois, Parc Astérix,	c'est la \"potion loisirs\" testée et approuvée depuis 1989 par des millions de visiteurs.", 45.0f, Billet.Type.BARRE_CODE, "ce-img-asterix"));
		put(2, new Billet(2, "Billet Match XV de France", "Valable jusqu'au 10/01/2015", "Trois essais contre les Fidji pour sa première sélection, un autre juste après face à l'Australie.", 140.0f, Billet.Type.QR_CODE, "ce-img-rugby"));
		put(3, new Billet(3, "Billet final football junior", "Valable jusqu'au 07/02/2015", "Venez assister à la final de la coupe du monde des moins de 16 ans.", 90.0f, Billet.Type.BARRE_CODE, "ce-img-foot"));
		put(4, new Billet(4, "Disneyland - Billet 1 jour 2 Parcs", "Valable jusqu'au 25/09/2015", "", 60.0f, Billet.Type.BARRE_CODE, "ce-img-disneyland"));
		put(5, new Billet(5, "Billet Musée du Louvre", "Valable jusqu'au 13/05/2015", "", 90.0f, Billet.Type.QR_CODE, "ce-img-louvre"));
		put(6, new Billet(6, "Billet Musée d'Orsay", "Valable jusqu'au 13/05/2015", "", 90.0f, Billet.Type.BARRE_CODE, "ce-img-orsay"));
	}};
	
	public static Billet findTicket(Integer ticketId) {
		return BILLETS.get(ticketId);
	}
}
