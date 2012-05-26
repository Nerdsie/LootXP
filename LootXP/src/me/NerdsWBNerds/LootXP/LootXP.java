package me.NerdsWBNerds.LootXP;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LootXP extends JavaPlugin implements Listener{
	public static Server server;
	public static Logger log;
	
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
		
		server = this.getServer();
		log = this.getLogger();
	}
	
	public void onDisable(){
		
	}
	
	@EventHandler
	public void entityDeath(EntityDeathEvent e){
		if(e.getEntity().getKiller() != null){
			Player player = e.getEntity().getKiller();
			
			if(player.getItemInHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_MOBS)){
				int level = player.getItemInHand().getEnchantments().get(Enchantment.LOOT_BONUS_MOBS);
				double times = level * (new Random().nextInt(10));
				
				e.setDroppedExp((int) (e.getDroppedExp() * times));
			}
		}
	}
}
