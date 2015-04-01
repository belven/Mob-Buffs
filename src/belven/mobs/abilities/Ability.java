package belven.mobs.abilities;

import belven.mobs.MobClass;

public abstract class Ability {
	public MobClass currentClass;
	protected String abilitiyName = "";
	public boolean onCooldown = false;
	public boolean shouldBreak = true;
	public int priority = 0;
	public int amplifier = 5;
	public int cooldown = 1;

	public Ability(MobClass cc, int Priority, int amplifier) {
		this.priority = Priority;
		this.amplifier = amplifier;
		currentClass = cc;
	}

	public abstract boolean PerformAbility();

	public int Amplifier() {
		return 0;
	}

	public String GetAbilityName() {
		return abilitiyName;
	}

}
