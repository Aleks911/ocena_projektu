package app.model;

public class Kursanci {
	
	private int id_k;
	private String imie, nazwisko, id_g, email, telefon, gh_link;
	public Kursanci(int id_k, String imie, String nazwisko, String id_g, String email, String telefon, String gh_link) {
		this.id_k = id_k;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.id_g = id_g;
		this.email = email;
		this.telefon = telefon;
		this.gh_link = gh_link;
	}
	public Kursanci() {
	}
	public int getId_k() {
		return id_k;
	}
	public void setId_k(int id_k) {
		this.id_k = id_k;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getId_g() {
		return id_g;
	}
	public void setId_g(String id_g) {
		this.id_g = id_g;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getGh_link() {
		return gh_link;
	}
	public void setGh_link(String gh_link) {
		this.gh_link = gh_link;
	}
	@Override
	public String toString() {
		return "Kursanci [id_k=" + id_k + ", imie=" + imie + ", nazwisko=" + nazwisko + ", id_g=" + id_g + ", email="
				+ email + ", telefon=" + telefon + ", gh_link=" + gh_link + "]";
	}
	
	
	

}

