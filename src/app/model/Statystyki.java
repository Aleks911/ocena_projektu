package app.model;

public class Statystyki {
	
	private int id_k;
	private String imie, nazwisko;
	private int id_p;
	private String temat;
	private String deadline;
	private int id_gr;
	private String data_od;
	private String ocena;
	
	
	public Statystyki() {
		}
	
	
	public Statystyki(int id_k, String imie, String nazwisko, int id_p, String temat, String deadline, int id_gr,
			String data_od, String ocena) {
		this.id_k = id_k;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.id_p = id_p;
		this.temat = temat;
		this.deadline = deadline;
		this.id_gr = id_gr;
		this.data_od = data_od;
		this.ocena = ocena;
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
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public String getTemat() {
		return temat;
	}
	public void setTemat(String temat) {
		this.temat = temat;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public int getId_gr() {
		return id_gr;
	}
	public void setId_gr(int id_gr) {
		this.id_gr = id_gr;
	}
	public String getData_od() {
		return data_od;
	}
	public void setData_od(String data_od) {
		this.data_od = data_od;
	}
	public String getOcena() {
		return ocena;
	}
	public void setOcena(String ocena) {
		this.ocena = ocena;
	}


}
