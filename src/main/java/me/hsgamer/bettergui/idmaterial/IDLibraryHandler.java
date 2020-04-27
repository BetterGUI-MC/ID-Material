package me.hsgamer.bettergui.idmaterial;

import me.idlibrary.main.IDLibrary;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IDLibraryHandler implements BaseHandler {

  private Material getMaterial(String input) {
    Material material = IDLibrary.getMaterial(input);
    if (material != null) {
      material = Material.matchMaterial(input.replace(" ", "_").toUpperCase());
    }
    return material;
  }

  @Override
  public void parse(String input, ItemStack itemStack) {
    Material material = getMaterial(input);
    if (material != null) {
      itemStack.setType(material);
    }
  }

  @Override
  public boolean compare(String input, ItemStack itemStack) {
    Material material = getMaterial(input);
    return material != null && itemStack.getType().equals(material);
  }
}
