package belven.mobs;

import java.util.HashMap;

import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import belven.mobs.listeners.MobListener;

public class MobBuffManager extends JavaPlugin {

	private final MobListener mobListener = new MobListener(this);
	private HashMap<LivingEntity, MobClass> currentMobClasses = new HashMap<>();

	public void setCurrentMobClasses(HashMap<LivingEntity, MobClass> currentMobClasses) {
		this.currentMobClasses = currentMobClasses;
	}

	public void AddMobClass(LivingEntity le, MobClass mc) {
		currentMobClasses.put(le, mc);
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(mobListener, this);
	}

	@Override
	public void onDisable() {
		getLogger().info("Goodbye world!");
		this.saveConfig();
	}

	public MobClass GetClass(LivingEntity currentMob) {
		return currentMobClasses.get(currentMob);
	}

}
