package be.vdab.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Persoon {
	private final Set<String> voornamen = new LinkedHashSet<>();
	
	public Persoon(String [] voornamen) {
		if(voornamen.length == 0) {
			throw new IllegalArgumentException();
		}
		for (String voornaam: voornamen) {
			if(voornaam.trim().isEmpty() || !this.voornamen.add(voornaam)) {
				throw new IllegalArgumentException();
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		voornamen.stream().forEach(voornaam -> builder.append(voornaam + " "));
		return builder.toString().trim();
	}

	public Set<String> getVoornamen() {
		return voornamen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voornamen == null) ? 0 : voornamen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Persoon)) {
			return false;
		}
		Persoon other = (Persoon) obj;
		if (voornamen == null) {
			if (other.voornamen != null) {
				return false;
			}
		} else if (!voornamen.equals(other.voornamen)) {
			return false;
		}
		return true;
	}	
}
