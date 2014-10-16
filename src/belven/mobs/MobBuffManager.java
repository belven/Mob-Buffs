package belven.mobs;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import belven.mobs.listeners.MobListener;

public class MobBuffManager extends JavaPlugin {

	private final MobListener mobListener = new MobListener(this);

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

}
