
public class ApplicationCheckpoint {
	public static void main(String[] args) {
		initGame();
	}
	
	public static void initGame() {
		Champion lux = new Champion("Lux", 550, 60, 0,330);
		GameControl game = new GameControl();
		
		System.out.println("Felicidades, has elegido a tu campeón");
		System.out.println(lux);
		
		System.out.println("\nHas recibido un upgrade");
		game.levelUp(lux, 400, 120, 0, 50);
		game.saveCheckpoint(lux);
		System.out.println(lux);
		
		lux = provokeError(lux, game);
		
		System.out.println(lux);
		
		
	}
	
	public static Champion  provokeError(Champion champion, GameControl game) {
		System.out.println("\nHas recibido un upgrade");
		try {
			game.levelUpWithError(champion);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			champion = game.loadCheckpoint();
		}
		
		return champion;
	}
	
	
	
	
	
}
