package app.model;

public class addProjekt {
	
	private int temat, opis, deadline;

	public addProjekt(int temat, int opis, int deadline) {
		super();
		this.temat = temat;
		this.opis = opis;
		this.deadline = deadline;
	}

	public addProjekt() {
		super();
	}

	public int getTemat() {
		return temat;
	}

	public void setTemat(int temat) {
		this.temat = temat;
	}

	public int getOpis() {
		return opis;
	}

	public void setOpis(int opis) {
		this.opis = opis;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return "addProjekt [temat=" + temat + ", opis=" + opis + ", deadline=" + deadline + "]";
	}
	
	
	

}
