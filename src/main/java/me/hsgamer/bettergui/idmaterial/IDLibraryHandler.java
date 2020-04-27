package me.hsgamer.bettergui.idmaterial;

import me.idlibrary.main.IDLibrary;
import org.bukkit.inventory.ItemStack;

public class IDLibraryHandler implements BaseHandler {

  @Override
  public void parse(String input, ItemStack itemStack) {
    itemStack.setType(IDLibrary.getMaterial(input));
  }

  @Override
  public boolean compare(String input, ItemStack itemStack) {
    return itemStack.getType().equals(IDLibrary.getMaterial(input));
  }
}
