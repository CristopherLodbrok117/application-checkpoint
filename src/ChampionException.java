
public class ChampionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ChampionException(Champion champion) {
		super("Ocurrio un problema durante el level up de tu campeón\n" + champion);
	}

}
