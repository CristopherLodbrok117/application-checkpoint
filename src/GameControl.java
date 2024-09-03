import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameControl {
	
	final String CHECKPOINT_FILE_NAME = "save.ser"; 
	
	final static int UNEXPECTED_NERF = -1;
	
	public GameControl() {	}
	
	public void levelUp(Champion champion, int hp, double ap, double ad, double speed) {
		champion.increaseHP(hp);
		champion.increaseAP(ap);
		champion.increaseAD(ad);
		champion.increaseSpeed(speed);
		
		
		
	}
	
	public void levelUpWithError(Champion champion) throws Exception {
		levelUp(champion
				, champion.getHp() * UNEXPECTED_NERF
				, champion.getAbilityPower() * UNEXPECTED_NERF
				, champion.getAttackDamage() * UNEXPECTED_NERF
				, champion.getSpeed() * UNEXPECTED_NERF);
		
		throw new ChampionException(champion);
	}
	
	public void saveCheckpoint(Champion champion) {
		

        try {
        	FileOutputStream file = new FileOutputStream(CHECKPOINT_FILE_NAME);
            ObjectOutputStream out = new ObjectOutputStream(file);
			
            out.writeObject(champion);
			
			out.close();
	        file.close();
	        
	        printSimulation("Guardando cambios", 3);
	        System.out.println("\nPartida guardada\n");
	        sleep(1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        

        
	}
	
	public Champion loadCheckpoint() {
		try {
            // Reading the object from a file
			printSimulation("Cargando ultimo checkpoint", 3);
            FileInputStream file = new FileInputStream(CHECKPOINT_FILE_NAME);
            ObjectInputStream in = new ObjectInputStream(file);

            Champion restoredChampion = (Champion) in.readObject();

            in.close();
            file.close();

            System.out.println("\nPartida cargada");
            return restoredChampion;


        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		return null;
	}
	
	public static void printSimulation(String msg, int times) {
		System.out.print("\n" + msg);
		sleep(200);
		for(int i = 0; i < times; i++) {
			
			System.out.print(".");
			sleep(1000);
		}
	}
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
