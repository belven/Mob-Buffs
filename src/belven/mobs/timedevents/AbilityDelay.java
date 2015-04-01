package belven.mobs.timedevents;

import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import belven.mobs.MobBuffManager;

public class AbilityDelay extends BukkitRunnable {
	private LivingEntity currentMob;
	private MobBuffManager plugin;

	public AbilityDelay(LivingEntity CurrentPlayer, MobBuffManager Plugin) {
		currentMob = CurrentPlayer;
		plugin = Plugin;
		plugin.GetClass(currentMob).CanCast = false;
	}

	@Override
	public void run() {
		plugin.GetClass(currentMob).CanCast = true;
		this.cancel();
	}
}