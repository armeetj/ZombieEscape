package club.trashcanolives.ZombieEscape;

import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    private HikariDataSource hikariDataSource;

    @Override
    public void onEnable()
    {
        setup();
        registerListeners();
    }

    private void registerListeners()
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinEvent, this);

    }

    private void setup()
    {
        FileConfiguration config = getConfig();
        String address = config.getString("DataBase.address");
        String name = config.getString("DataBase.schema");
        String username = config.getString("DataBase.username");
        String password = config.getString("DataBase.password");

        hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(10);
    }
}
