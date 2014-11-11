package belven.mobs.resources;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.potion.PotionEffectType;

import resources.Functions;

public class functions {
	final static int SECOND = 1;
	final static int MINUTE = SECOND * 60;
	final static int HOUR = MINUTE * 60;
	final static int DAY = HOUR * 24;

	public static List<PotionEffectType> negativeEffects() {
		List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
		tempEffects.add(PotionEffectType.BLINDNESS);
		tempEffects.add(PotionEffectType.CONFUSION);
		tempEffects.add(PotionEffectType.HARM);
		tempEffects.add(PotionEffectType.HUNGER);
		tempEffects.add(PotionEffectType.POISON);
		tempEffects.add(PotionEffectType.SLOW);
		tempEffects.add(PotionEffectType.SLOW_DIGGING);
		tempEffects.add(PotionEffectType.WEAKNESS);
		tempEffects.add(PotionEffectType.WITHER);
		return tempEffects;
	}

	public static List<PotionEffectType> undeadImmuneEffects() {
		List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
		tempEffects.add(PotionEffectType.REGENERATION);
		tempEffects.add(PotionEffectType.POISON);
		return tempEffects;
	}

	public static int getPotionEffectMaxAmp(PotionEffectType pet) {
		if (pet == PotionEffectType.ABSORPTION) {
			return 2;
		} else if (pet == PotionEffectType.DAMAGE_RESISTANCE) {
			return 2;
		} else if (pet == PotionEffectType.FIRE_RESISTANCE) {
			return 3;
		} else if (pet == PotionEffectType.HEALTH_BOOST) {
			return 10;
		} else if (pet == PotionEffectType.INCREASE_DAMAGE) {
			return 2;
		} else if (pet == PotionEffectType.REGENERATION) {
			return 3;
		} else if (pet == PotionEffectType.INVISIBILITY) {
			return 1;
		} else if (pet == PotionEffectType.SPEED) {
			return 1;
		} else if (pet == PotionEffectType.POISON) {
			return 6;
		} else if (pet == PotionEffectType.SLOW) {
			return 1;
		} else if (pet == PotionEffectType.WEAKNESS) {
			return 2;
		} else if (pet == PotionEffectType.WITHER) {
			return 2;
		}

		return 1;
	}

	public static int getPotionEffectMaxDuration(PotionEffectType pet) {

		int dur = DAY;

		// if (pet == PotionEffectType.ABSORPTION) {
		// dur = 60;
		// } else if (pet == PotionEffectType.DAMAGE_RESISTANCE) {
		// dur = 60;
		// } else if (pet == PotionEffectType.INCREASE_DAMAGE) {
		// dur = 30;
		// } else if (pet == PotionEffectType.FIRE_RESISTANCE) {
		// dur = 300;
		// } else if (pet == PotionEffectType.HEALTH_BOOST) {
		// dur = 300;
		// } else if (pet == PotionEffectType.REGENERATION) {
		// dur = 30;
		// } else
		if (pet == PotionEffectType.INVISIBILITY) {
			dur = MINUTE;
		}
		// } else if (pet == PotionEffectType.SPEED) {
		// dur = 60;
		// } else if (pet == PotionEffectType.POISON) {
		// dur = 60;
		// } else if (pet == PotionEffectType.SLOW) {
		// dur = 60;
		// } else if (pet == PotionEffectType.WEAKNESS) {
		// dur = 60;
		// } else if (pet == PotionEffectType.WITHER) {
		// dur = 20;
		// }

		return Functions.SecondsToTicks(dur);
	}

	public static PotionEffectType undeadReveseEffects(PotionEffectType pet) {
		if (pet == PotionEffectType.HEAL) {
			return PotionEffectType.HARM;
		}

		return pet;
	}

	public static List<PotionEffectType> negativeEffectsForMobs() {
		List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
		tempEffects.add(PotionEffectType.POISON);
		tempEffects.add(PotionEffectType.SLOW);
		// tempEffects.add(PotionEffectType.HARM);
		tempEffects.add(PotionEffectType.WEAKNESS);
		// tempEffects.add(PotionEffectType.WITHER);
		return tempEffects;
	}

	public static List<PotionEffectType> positiveEffectsForMobs() {
		List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
		tempEffects.add(PotionEffectType.ABSORPTION);
		tempEffects.add(PotionEffectType.DAMAGE_RESISTANCE);
		// tempEffects.add(PotionEffectType.FIRE_RESISTANCE);
		tempEffects.add(PotionEffectType.INCREASE_DAMAGE);
		// tempEffects.add(PotionEffectType.HEALTH_BOOST);
		// tempEffects.add(PotionEffectType.REGENERATION);
		// tempEffects.add(PotionEffectType.HEAL);
		// tempEffects.add(PotionEffectType.INVISIBILITY);
		tempEffects.add(PotionEffectType.SPEED);
		return tempEffects;
	}

	public static List<PotionEffectType> positiveEffects() {
		List<PotionEffectType> tempEffects = new ArrayList<PotionEffectType>();
		tempEffects.add(PotionEffectType.ABSORPTION);
		tempEffects.add(PotionEffectType.DAMAGE_RESISTANCE);
		tempEffects.add(PotionEffectType.FAST_DIGGING);
		tempEffects.add(PotionEffectType.FIRE_RESISTANCE);
		tempEffects.add(PotionEffectType.HEAL);
		tempEffects.add(PotionEffectType.HEALTH_BOOST);
		tempEffects.add(PotionEffectType.INVISIBILITY);
		tempEffects.add(PotionEffectType.JUMP);
		tempEffects.add(PotionEffectType.NIGHT_VISION);
		tempEffects.add(PotionEffectType.REGENERATION);
		tempEffects.add(PotionEffectType.SPEED);
		tempEffects.add(PotionEffectType.WATER_BREATHING);
		return tempEffects;
	}

}
