package belven.mob.classes;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import belven.mobs.MobBuffManager;
import belven.mobs.abilities.Ability;
import belven.mobs.abilities.Slow;
import belven.mobs.abilities.StealLife;

public class Sapper extends MobClass {

	public Sapper(double health, LivingEntity classOwner, MobBuffManager instance) {
		super(health, classOwner, instance);
		SetAbilities();
		SortAbilities();
	}

	@Override
	public void SelfCast(Player currentPlayer) {

	}

	@Override
	public void SetAbilities() {
		Abilities.add(new StealLife(this, 10, 1));
		Abilities.add(new Slow(this, 1, 1));
	}

	@Override
	public void RightClickEntity(Entity currentEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SelfTakenDamage(EntityDamageByEntityEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SelfDamageOther(EntityDamageByEntityEvent event) {
		targetLE = (LivingEntity) event.getEntity();
		for (Ability a : Abilities) {
			if (!a.onCooldown) {
				if (!a.PerformAbility()) {
					continue;
				} else if (a.shouldBreak) {
					break;
				}
			}
		}
	}
}
