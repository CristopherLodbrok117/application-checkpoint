import java.io.Serializable;

public class Champion implements Serializable{

	private static final long serialVersionUID = 12L;
	
	private String name;
	private int hp;
	private double abilityPower;
	private double attackDamage;
	private double speed;
	
	public Champion(String name, int hp, double ap, double ad, double speed) {
		this.name = name;
		this.hp = hp;
		this.abilityPower = ap;
		this.attackDamage = ad;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public double getAbilityPower() {
		return abilityPower;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public double getSpeed() {
		return speed;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setAbilityPower(double abilityPower) {
		this.abilityPower = abilityPower;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void increaseHP(int hp) {
		this.hp += hp;
	}
	
	public void increaseAP(double ap) {
		this.abilityPower += ap;
	}
	
	public void increaseAD(double ad) {
		this.abilityPower += ad;
	}
	
	public void increaseSpeed(double speed) {
		this.speed += speed;
	}
	
	public String toString() {
		StringBuffer info = new StringBuffer("\n - Champion stats - ");
		
		info.append("\nName: " + name);
		info.append("\nHP: " + hp);
		info.append("\nAbility power: " + abilityPower);
		info.append("\nAttack damage: " + attackDamage);
		info.append("\nSpeed: " + speed);
		info.append("\n----------------------");
		
		return info.toString();
	}
	
}
