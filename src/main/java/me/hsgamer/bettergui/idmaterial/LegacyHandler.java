package me.hsgamer.bettergui.idmaterial;

import java.math.BigDecimal;
import java.util.Optional;
import me.hsgamer.bettergui.util.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class LegacyHandler implements BaseHandler {

  @SuppressWarnings("deprecated")
  private MaterialData getMaterialData(String input) {
    Material material;
    byte data = 0;

    String[] split = input.split(":", 2);
    if (split.length > 1) {
      Optional<BigDecimal> optional = Validate.getNumber(split[1]);
      if (optional.isPresent()) {
        data = optional.get().byteValue();
      }
    }

    String rawMat = split[0];
    rawMat = rawMat.replace(" ", "_").toUpperCase();
    Optional<BigDecimal> optional = Validate.getNumber(rawMat);
    if (optional.isPresent()) {
      material = Material.getMaterial(optional.get().intValue());
    } else {
      material = Material.matchMaterial(rawMat);
    }

    if (material == null) {
      return null;
    }

    return new MaterialData(material, data);
  }

  @Override
  public void parse(String input, ItemStack itemStack) {
    MaterialData materialData = getMaterialData(input);
    if (materialData != null) {
      itemStack.setData(materialData);
    }
  }

  @Override
  public boolean compare(String input, ItemStack itemStack) {
    MaterialData materialData = getMaterialData(input);
    return materialData != null && materialData.equals(itemStack.getData());
  }
}
