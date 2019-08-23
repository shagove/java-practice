package ee.sda.hibernate.entities.ids;

import java.io.Serializable;


@SuppressWarnings("serial")
public class CurrencyId implements Serializable{

	private String name;

	private String countryName;

	public CurrencyId(){

	}

	public CurrencyId(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
	}

	public final String getName() {
		return name;
	}

	public final String getCountryName() {
		return countryName;
	}

}
