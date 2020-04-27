package me.hsgamer.bettergui.idmaterial;

import me.hsgamer.bettergui.builder.PropertyBuilder;
import me.hsgamer.bettergui.lib.xseries.XMaterial;
import me.hsgamer.bettergui.object.addon.Addon;
import org.bukkit.Bukkit;

public final class Main extends Addon {

  private static BaseHandler handler;

  public static BaseHandler getHandler() {
    return handler;
  }

  @Override
  public boolean onLoad() {
    if (XMaterial.isNewVersion()) {
      if (Bukkit.getPluginManager().getPlugin("ID-Library") != null) {
        handler = new IDLibraryHandler();
      } else {
        getPlugin().getLogger()
            .warning("You are using a new Minecraft version (1.13+) without ID-Library");
        getPlugin().getLogger().warning("Since 1.13+, numeric ID has been removed");
        getPlugin().getLogger().warning("This addon is useless. Disabled");
        return false;
      }
    } else {
      handler = new LegacyHandler();
    }
    return true;
  }

  @Override
  public void onEnable() {
    PropertyBuilder.registerItemProperty("id", IDItemProperty.class);
  }
}
