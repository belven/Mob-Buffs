package belven.mobs.abilities;

import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import belven.mob.classes.MobClass;
import belven.resources.EntityFunctions;

public class Cleave extends Ability {

	public Cleave(MobClass cc, int Priority, int amplifier) {
		super(cc, Priority, amplifier);
		cooldown = 10;
		shouldBreak = true;
	}

	@Override
	public boolean PerformAbility() {
		List<LivingEntity> entities = EntityFunctions.getNearbyEntities(currentClass.classOwner.getLocation(), 2);

		for (LivingEntity le : entities) {
			if (le.getType() == EntityType.PLAYER) {
				EntityFunctions.Heal(le, -amplifier);
			}
		}
		currentClass.setAbilityOnCoolDown(this);
		return true;
	}
}
