package ee.sda.hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@GeneratedValue
	@Column(name="PORTFOLIO_ID")
	private Long portfolioId;

	@Column(name="NAME")
	private String name;

	@OneToMany(mappedBy="portfolio")
	private List<Investment> investements = new ArrayList<Investment>();

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Investment> getInvestements() {
		return investements;
	}

	public void setInvestements(List<Investment> investements) {
		this.investements = investements;
	}

}
