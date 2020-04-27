package me.hsgamer.bettergui.idmaterial;

import org.bukkit.inventory.ItemStack;

public interface BaseHandler {
  void parse(String input, ItemStack itemStack);

  boolean compare(String input, ItemStack itemStack);
}
