package app.model;

public class Grupa {
	private int id_gr;
	private String nazwa_gr;
	
	
	
	public Grupa() {
		}

	public Grupa(int id_gr, String nazwa_gr) {
		this.id_gr = id_gr;
		this.nazwa_gr = nazwa_gr;
	}

	public int getId_gr() {
		return id_gr;
	}

	public void setId_gr(int id_gr) {
		this.id_gr = id_gr;
	}

	public String getNazwa_gr() {
		return nazwa_gr;
	}

	public void setNazwa_gr(String nazwa_gr) {
		this.nazwa_gr = nazwa_gr;
	}
	
	
	
	

}
