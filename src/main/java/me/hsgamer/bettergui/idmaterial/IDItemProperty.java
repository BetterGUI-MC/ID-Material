package me.hsgamer.bettergui.idmaterial;

import me.hsgamer.bettergui.object.Icon;
import me.hsgamer.bettergui.object.property.item.ItemProperty;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class IDItemProperty extends ItemProperty<Object, String> {

  public IDItemProperty(Icon icon) {
    super(icon);
  }

  @Override
  public String getParsed(Player player) {
    return parseFromString(String.valueOf(value), player);
  }

  @Override
  public ItemStack parse(Player player, ItemStack itemStack) {
    Main.getHandler().parse(getParsed(player), itemStack);
    return itemStack;
  }

  @Override
  public boolean compareWithItemStack(Player player, ItemStack itemStack) {
    return Main.getHandler().compare(getParsed(player), itemStack);
  }
}
