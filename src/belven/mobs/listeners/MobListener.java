package belven.mobs.listeners;

import java.util.Random;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import belven.mobs.MobBuffManager;
import belven.resources.EntityFunctions;

public class MobListener implements Listener {
	private final MobBuffManager plugin;

	Random randomGenerator = new Random();

	public MobListener(MobBuffManager instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
		LivingEntity damager = EntityFunctions.GetDamager(event);

		if (!(event.getEntity() instanceof LivingEntity)) {
			return;
		}

		LivingEntity damageEntity = (LivingEntity) event.getEntity();
		Damageable damagedEntity = damageEntity;

		if (damager == null) {
			return;
		}

		double maxPercent = getDamageToDo(damager, damageEntity);
		double maxDamage = maxPercent * damagedEntity.getMaxHealth();

		event.setDamage(maxDamage);

		if (EntityFunctions.IsAMob(damagedEntity.getType())) {
			damageEntity.setNoDamageTicks(5);
		} else {
			damageEntity.setNoDamageTicks(20);
		}
		plugin.getServer().getLogger().info(String.valueOf(event.getDamage()));
	}

	public double getDamageToDo(LivingEntity damager, LivingEntity damageEntity) {
		double baseDamage = 0.05;
		double bonusDamage = getWeaponBonus(damager.getEquipment().getItemInHand());
		double armourReduction = getArmourReduction(damageEntity.getEquipment().getArmorContents());
		double potionDamageBonus = getPotionDamageBonus(damager);
		double potionArmourBonus = getPotionArmourBonus(damageEntity);

		double finalDamage = baseDamage + bonusDamage + potionDamageBonus - armourReduction - potionArmourBonus;

		return finalDamage > 0 ? finalDamage : 0.05;
	}

	private double getPotionArmourBonus(LivingEntity le) {
		int amp = 0;

		if (le.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
			amp = getPotionStrength(le, PotionEffectType.DAMAGE_RESISTANCE);
			return amp != 0 ? amp * 20 / 100.0 : 0;
		}
		return amp;
	}

	private double getPotionDamageBonus(LivingEntity le) {
		int amp = 0;

		if (le.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
			amp = getPotionStrength(le, PotionEffectType.INCREASE_DAMAGE);
			return amp != 0 ? amp * 2 / 100.0 : 0;
		}
		return amp;
	}

	public int getPotionStrength(LivingEntity damageEntity, PotionEffectType pet) {
		for (PotionEffect pe : damageEntity.getActivePotionEffects()) {
			if (pe.getType() == pet) {
				return pe.getAmplifier();
			}
		}

		return 0;
	}

	private double getArmourReduction(ItemStack[] armorContents) {
		double totalValue = 0;

		for (ItemStack is : armorContents) {
			if (is != null) {
				totalValue += getArmourGadeValue(is);
			}
		}

		return totalValue;
	}

	public double getArmourGadeValue(ItemStack is) {
		String grade = is.getType().toString();
		if (grade.contains("LEATHER")) {
			return 0.0225 + getEnchantmentBonus(is);
		} else if (grade.contains("IRON")) {
			return 0.0375 + getEnchantmentBonus(is);
		} else if (grade.contains("GOLD")) {
			return 0.0200 + getEnchantmentBonus(is);
		} else if (grade.contains("DIAMOND")) {
			return 0.0300 + getEnchantmentBonus(is);
		}

		return 0;
	}

	private double getWeaponBonus(ItemStack itemInHand) {
		if (itemInHand != null) {
			switch (itemInHand.getType()) {
			case WOOD_SWORD:
				return 0.075 + getEnchantmentBonus(itemInHand);
			case STONE_SWORD:
				return 0.100 + getEnchantmentBonus(itemInHand);
			case GOLD_SWORD:
				return 0.125 + getEnchantmentBonus(itemInHand);
			case IRON_SWORD:
				return 0.150 + getEnchantmentBonus(itemInHand);
			case DIAMOND_SWORD:
				return 0.200 + getEnchantmentBonus(itemInHand);
			case BOW:
				return 0.150 + getEnchantmentBonus(itemInHand);
			default:
				return 0.03;
			}
		}

		return 0.03;
	}

	private double getEnchantmentBonus(ItemStack is) {
		if (is.containsEnchantment(Enchantment.ARROW_DAMAGE)) {
			return is.getEnchantmentLevel(Enchantment.ARROW_DAMAGE) / 100.0;
		} else if (is.containsEnchantment(Enchantment.DAMAGE_ALL)) {
			return is.getEnchantmentLevel(Enchantment.DAMAGE_ALL) / 100.0;
		} else if (is.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
			return is.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) / 100.0;
		}
		return 0;
	}

	// private PotionEffectType getPositiveEffect(LivingEntity le) {
	// List<PotionEffectType> tempEffects = functions.positiveEffectsForMobs();
	// int ran = randomGenerator.nextInt(tempEffects.size());
	// return tempEffects.get(ran);
	// }
	//
	// private PotionEffectType getNegativeEffect(LivingEntity le) {
	// List<PotionEffectType> tempEffects = functions.negativeEffectsForMobs();
	// int ran = randomGenerator.nextInt(tempEffects.size());
	// return tempEffects.get(ran);
	// }

	public MobBuffManager getPlugin() {
		return plugin;
	}

}
