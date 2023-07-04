package club.santafan.markabraham.item;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;

import static club.santafan.markabraham.init.ItemInit.MarkAbrahamTabInstance;

public class CopperHorseArmorItem extends HorseArmorItem {
    public CopperHorseArmorItem() {
        // p_41364_ Protection amount
        super(5, new ResourceLocation(MarkAbraham.MODID, "textures/entities/copper_horse_armor.png"), new Item.Properties()
                .tab(MarkAbrahamTabInstance)
                .stacksTo(1));
    }
}