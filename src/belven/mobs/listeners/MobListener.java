package belven.mobs.listeners;

import java.util.List;
import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import resources.EntityFunctions;
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
			int posDuration = functions
					.getPotionEffectMaxDuration(positiveEffect);

			PotionEffectType negativeEffect = getNegativeEffect(le);
			int negAmplifier = functions.getPotionEffectMaxAmp(positiveEffect);
			int negDuration = functions
					.getPotionEffectMaxDuration(positiveEffect);

			PotionEffect positive = new PotionEffect(positiveEffect,
					posDuration, posAmplifier);

			new PotionEffect(negativeEffect, negDuration, negAmplifier);

			le.addPotionEffect(positive, true);
			// le.addPotionEffect(negative, true);
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