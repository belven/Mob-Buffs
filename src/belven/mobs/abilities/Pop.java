package belven.mobs.abilities;

import org.bukkit.Location;

import belven.mobs.MobClass;
import belven.resources.Functions;

public class Pop extends Ability {

	public Pop(MobClass cc, int Priority, int amplifier) {
		super(cc, Priority, amplifier);
		cooldown = 2;
	}

	@Override
	public boolean PerformAbility() {
		if (currentClass.targetLE != null) {
			Location l = currentClass.targetLE.getLocation();
			l = Functions.offsetLocation(l, 0, 1, 0);
			currentClass.targetLE.teleport(l);
			currentClass.setAbilityOnCoolDown(this);
			return true;
		}
		return false;
	}
}
