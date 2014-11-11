package belven.mobs.listeners;

import java.util.List;
import java.util.Random;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import resources.EntityFunctions;
import resources.Functions;
import belven.mobs.MobBuffManager;
import belven.mobs.resources.functions;

public class MobListener implements Listener {
	private final MobBuffManager plugin;

	Random randomGenerator = new Random();

	public MobListener(MobBuffManager instance) {
		plugin = instance;
	}

	@EventHandler
	public void onCreatureSpawnEvent(CreatureSpawnEvent event) {

		if (EntityFunctions.IsAMob(event.getEntityType())) {
			LivingEntity le = event.getEntity();

			PotionEffectType positiveEffect = getPositiveEffect(le);
			int posAmplifier = functions.getPotionEffectMaxAmp(positiveEffect);
			int posDuration = functions.getPotionEffectMaxDuration(positiveEffect);

			PotionEffectType negativeEffect = getNegativeEffect(le);
			int negAmplifier = functions.getPotionEffectMaxAmp(positiveEffect);
			int negDuration = functions.getPotionEffectMaxDuration(positiveEffect);

			PotionEffect positive = new PotionEffect(positiveEffect, posDuration, posAmplifier);

			new PotionEffect(negativeEffect, negDuration, negAmplifier);

			le.addPotionEffect(positive, true);
			// le.addPotionEffect(negative, true);
		}
	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		LivingEntity damager = EntityFunctions.GetDamager(event);
		LivingEntity damageEntity = (LivingEntity) event.getEntity();
		Damageable damagedEntity = damageEntity;

		double maxPercent = getDamageToDo(damager, damageEntity);
		double maxDamage = maxPercent * damagedEntity.getMaxHealth();

		event.setDamage(maxDamage);
		if (EntityFunctions.IsAMob(damagedEntity.getType())) {
			damageEntity.setNoDamageTicks(5);
		} else {
			damageEntity.setNoDamageTicks(Functions.SecondsToTicks(1));
		}

		damager.getEquipment().getItemInHand()
				.setDurability((short) (damager.getEquipment().getItemInHand().getDurability() - 10));
	}

	public double getDamageToDo(LivingEntity damager, LivingEntity damageEntity) {
		double baseDamage = 0.08;
		double bonusDamage = getWeaponBonus(damager.getEquipment().getItemInHand());
		double armourReduction = getArmourReduction(damager.getEquipment().getArmorContents());

		return baseDamage + bonusDamage - armourReduction;
	}

	private double getArmourReduction(ItemStack[] armorContents) {
		double totalValue = 0;

		for (ItemStack is : armorContents) {
			totalValue += getArmourGadeValue(is);
		}

		return totalValue;
	}

	public double getArmourGadeValue(ItemStack is) {
		String grade = is.getType().toString();
		if (grade.contains("LEATHER")) {
			return 0.075;
		} else if (grade.contains("IRON")) {
			return 0.01;
		} else if (grade.contains("GOLD")) {
			return 0.075;
		} else if (grade.contains("DIAMOND")) {
			return 0.02;
		}

		return 0.005;
	}

	private double getWeaponBonus(ItemStack itemInHand) {
		switch (itemInHand.getType()) {
		case WOOD_SWORD:
			return 0.10;
		case STONE_SWORD:
			return 0.15;
		case GOLD_SWORD:
			return 0.15;
		case IRON_SWORD:
			return 0.20;
		case DIAMOND_SWORD:
			return 0.025;
		default:
			return 0.1;
		}
	}

	private PotionEffectType getPositiveEffect(LivingEntity le) {
		List<PotionEffectType> tempEffects = functions.positiveEffectsForMobs();
		int ran = randomGenerator.nextInt(tempEffects.size());
		return tempEffects.get(ran);
	}

	private PotionEffectType getNegativeEffect(LivingEntity le) {
		List<PotionEffectType> tempEffects = functions.negativeEffectsForMobs();
		int ran = randomGenerator.nextInt(tempEffects.size());
		return tempEffects.get(ran);
	}

	public MobBuffManager getPlugin() {
		return plugin;
	}

}