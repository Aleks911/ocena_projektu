package app.controller;

public class OcenaProjekt {
	
	int id_k;
	int id_p;
	String temat;
	String opis;
	String deadline;
	String data_od;
	String ocena;
	
	public OcenaProjekt() {
	
	}
	
	
	public OcenaProjekt(int id_k, int id_p, String temat, String opis, String deadline, String data_od, String ocena) {
		this.id_k = id_k;
		this.id_p = id_p;
		this.temat = temat;
		this.opis = opis;
		this.deadline = deadline;
		this.data_od = data_od;
		this.ocena = ocena;
	}
	public int getId_k() {
		return id_k;
	}
	public void setId_k(int id_k) {
		this.id_k = id_k;
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
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
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
