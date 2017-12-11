package app.model;

public class Projekt {
	
	private int id_p;
	private String temat, opis, deadline;
	

	public Projekt() {
		super();
	}

	public Projekt(int id_p, String temat, String opis, String deadline) {
		super();
		this.id_p = id_p;
		this.temat = temat;
		this.opis = opis;
		this.deadline = deadline;
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

	@Override
	public String toString() {
		return "Projekt [id_p=" + id_p + ", temat=" + temat + ", opis=" + opis + ", deadline=" + deadline + "]";
	}
	  
	
}
