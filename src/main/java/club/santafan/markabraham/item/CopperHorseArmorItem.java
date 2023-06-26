package club.santafan.markabraham.item;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class CopperHorseArmorItem extends HorseArmorItem {
    public CopperHorseArmorItem(Properties properties) {
        super(5, new ResourceLocation(MarkAbraham.MODID, "textures/entities/copper_horse_armor.png"), properties
                .stacksTo(1));
    }
}