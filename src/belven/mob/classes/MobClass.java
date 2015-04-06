package belven.mob.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import belven.mobs.MobBuffManager;
import belven.mobs.abilities.Ability;
import belven.mobs.timedevents.AbilityCooldown;
import belven.resources.EntityFunctions;
import belven.resources.Functions;

public abstract class MobClass {
	public ArrayList<Ability> Abilities = new ArrayList<Ability>();
	public LivingEntity classOwner = null;
	public MobBuffManager plugin;
	protected String className = "";
	public LivingEntity targetLE;
	public boolean CanCast = true;

	public MobClass(double health, LivingEntity classOwner, MobBuffManager instance) {
		plugin = instance;
		this.classOwner = classOwner;

		Damageable dcurrentPlayer = classOwner;
		dcurrentPlayer.setMaxHealth(health * 2);
		dcurrentPlayer.setHealth(dcurrentPlayer.getMaxHealth());
	}

	public LivingEntity getTarget(int radius, Player p) {
		return EntityFunctions.findTargetEntity(p, radius);
	}

	public Player getTargetPlayer(int radius, Player p) {
		return EntityFunctions.findTargetPlayer(p, radius);

	}

	public final String getClassName() {
		return className;
	}

	public void SortAbilities() {
		SortAbilities(Abilities);
	}

	public void SortAbilities(List<Ability> tempAbilities) {
		Collections.sort(tempAbilities, new Comparator<Ability>() {
			@Override
			public int compare(Ability a1, Ability a2) {
				return Math.min(1, Math.max(-1, a1.priority - a2.priority));
			}
		});
	}

	public abstract void SelfCast(Player currentPlayer);

	public abstract void SetAbilities();

	public abstract void RightClickEntity(Entity currentEntity);

	public abstract void SelfTakenDamage(EntityDamageByEntityEvent event);

	public abstract void SelfDamageOther(EntityDamageByEntityEvent event);

	public void ToggleSneakEvent(PlayerToggleSneakEvent event) {
	}

	public void UltAbilityUsed(Ability currentAbility) {
		setAbilityOnCoolDown(currentAbility);
	}

	public void setAbilityOnCoolDown(Ability currentAbility, boolean sendMessage) {
		new AbilityCooldown(currentAbility, sendMessage).runTaskLater(plugin,
				Functions.SecondsToTicks(currentAbility.cooldown));
		currentAbility.onCooldown = true;
	}

	public void setAbilityOnCoolDown(Ability currentAbility) {
		setAbilityOnCoolDown(currentAbility, false);
	}

	public void AbilityUsed(Ability ability) {

	}

}
