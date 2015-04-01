package belven.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import belven.mobs.abilities.Ability;
import belven.mobs.abilities.Pop;

public class Warrior extends MobClass {

	public Warrior(double health, LivingEntity classOwner, MobBuffManager instance) {
		super(health, classOwner, instance);
		SetAbilities();
	}

	@Override
	public void SelfCast(Player currentPlayer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void SetAbilities() {
		Abilities.add(new Pop(this, 1, 1));

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
