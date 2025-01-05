package Ajudantes;

public abstract class ModeloBanco implements CRUD {
	private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
