import java.io.Serializable;

public abstract class Carte implements Serializable{
	private static final long serialVersionUID = 1L;

	public abstract String getNom();

	public abstract void effet(Bot r);

}

