package com.phonegap.helloworld.fake;

import java.util.HashMap;
import java.util.Map;

public class BilletterieFactory {
	@SuppressWarnings("serial")
	public static Map<Integer, Billet> BILLETS = new HashMap<Integer, Billet>() {{
		put(1, new Billet(1, "Billet Parc ast�rix 1 jour 1 Parc", "Valable jusqu'au 13/05/2015", "D�tonnant m�lange de 35 attractions et de grands spectacles, le tout dans des d�cors truff�s d'humour gaulois, Parc Ast�rix,	c'est la \"potion loisirs\" test�e et approuv�e depuis 1989 par des millions de visiteurs.", 45.0f, Billet.Type.BARRE_CODE, "ce-img-asterix"));
		put(2, new Billet(2, "Billet Match XV de France", "Valable jusqu'au 10/01/2015", "Trois essais contre les Fidji pour sa premi�re s�lection, un autre juste apr�s face � l'Australie.", 140.0f, Billet.Type.QR_CODE, "ce-img-rugby"));
		put(3, new Billet(3, "Billet final football junior", "Valable jusqu'au 07/02/2015", "Venez assister � la final de la coupe du monde des moins de 16 ans.", 90.0f, Billet.Type.BARRE_CODE, "ce-img-foot"));
		put(4, new Billet(4, "Disneyland - Billet 1 jour 2 Parcs", "Valable jusqu'au 25/09/2015", "", 60.0f, Billet.Type.BARRE_CODE, "ce-img-disneyland"));
		put(5, new Billet(5, "Billet Mus�e du Louvre", "Valable jusqu'au 13/05/2015", "", 90.0f, Billet.Type.QR_CODE, "ce-img-louvre"));
		put(6, new Billet(6, "Billet Mus�e d'Orsay", "Valable jusqu'au 13/05/2015", "", 90.0f, Billet.Type.BARRE_CODE, "ce-img-orsay"));
	}};
	
	public static Billet findTicket(Integer ticketId) {
		return BILLETS.get(ticketId);
	}
}
