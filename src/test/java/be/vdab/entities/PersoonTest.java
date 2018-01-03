package be.vdab.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PersoonTest {

	@Test
	public void equalsOpTweeDezelfdePersonenMoetTrueZijn() {
		String [] voornamen = new String [] {"Jan","Piet"};
		assertEquals(new Persoon(voornamen),new Persoon(voornamen));
	}
	
	@Test
	public void equalsOpTweeVerschillendePersonenMoetFalseZijn() {
		String [] voornamen = new String [] {"Jan","Piet"};
		String [] voornamen2 = new String [] {"Jean","Piet"};
		assertNotEquals(new Persoon(voornamen),new Persoon(voornamen2));
	}
	
	@Test
	public void hashCodeOpTweeDezelfdePersonenMoetGelijkZijn() {
		String [] voornamen = new String [] {"Jan","Piet"};
		assertEquals(new Persoon(voornamen).hashCode(), 
				new Persoon(voornamen).hashCode());
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonMoetMinstens1VoornaamHebben() {
		String [] voornamen = new String [] {};
		new Persoon(voornamen);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonKanGeenTweeKeerDezelfdeVoornaamHebben() {
		String [] voornamen = new String [] {"Jan","Jan"};
		new Persoon(voornamen);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenVoornaamMagGeenLegeStringZijn() {
		String [] voornamen = new String [] {""};
		new Persoon(voornamen);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenVoornaamMoetMinstens1NietBlancoTekenBevatten() {
		String [] voornamen = new String [] {" "};
		new Persoon(voornamen);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void elkeVoornaamMoetMinstens1NietBlancoTekenBevatten() {
		String [] voornamen = new String [] {"Jan", " "};
		new Persoon(voornamen);
	}
	
	@Test(expected = NullPointerException.class)
	public void nullAlsVoornamenIsVerkeerd () {
		new Persoon(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void nullAlsVoornaamIsVerkeerd() {
		String [] voornamen = new String [] {null};
		new Persoon(voornamen);
	}
	
	@Test
	public void toStringOpPersoonMet1VoornaamMoetEnkelDieVoornaamTeruggeven() {
		String [] voornamen = new String [] {"Jan"};
		Persoon persoon = new Persoon(voornamen);
		assertEquals("Jan", persoon.toString());
	}
	
	@Test
	public void toStringOpPersoonMetMeerdereVoornamenMoetDieVoornamenTerugGevenGescheidenDoorEenSpatie() {
		String [] voornamen = new String [] {"Jan", "Piet", "Tjores"};
		Persoon persoon = new Persoon(voornamen);
		assertEquals("Jan Piet Tjores", persoon.toString());
	}
	
	@Test
	public void toStringOpPersoonMetMeerdereVoornamenMoetAlDieVoornamenTerugGevenGescheidenDoorEenSpatie() {
		String [] voornamen = new String [] {"Jan", "Piet", "Tjores"};
		Persoon persoon = new Persoon(voornamen);
		assertNotEquals("Jan Piet", persoon.toString());
	}
	
	@Test
	public void toStringOpPersoonMetMeerdereVoornamenMoetEnkelDieVoornamenTerugGevenGescheidenDoorEenSpatie() {
		String [] voornamen = new String [] {"Jan", "Piet", "Tjores"};
		Persoon persoon = new Persoon(voornamen);
		assertNotEquals("Jan Piet Tjores Korneel", persoon.toString());
	}
	
	@Test
	public void toStringOpPersoonMetMeerdereVoornamenMoetDieVoornamenTerugGevenInJuisteVolgorde() {
		String [] voornamen = new String [] {"Jan", "Piet", "Tjores"};
		Persoon persoon = new Persoon(voornamen);
		assertNotEquals("Jan Tjores Piet", persoon.toString());
	}
}
