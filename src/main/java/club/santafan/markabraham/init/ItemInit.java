package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import club.santafan.markabraham.util.LightsaberItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ItemInit {
    public static class MarkAbrahamTab extends CreativeModeTab {
        private MarkAbrahamTab(int index, String label) {
            super(index, label);
        }

        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(MARKABRAHAM_BLOCK.get());
        }
    }

    public static final MarkAbrahamTab MarkAbrahamTabInstance = new MarkAbrahamTab(MarkAbrahamTab.TABS.length, "markabraham");

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MarkAbraham.MODID);

    public static final RegistryObject<Item> MARKABRAHAM_BLOCK = ITEMS.register("markabraham_block", () -> new BlockItem(BlockInit.MARKABRAHAM_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> DARKSABER = ITEMS.register("darksaber", LightsaberItem::createPowerful);
    public static final RegistryObject<Item> THEYULELIGHTSABER = ITEMS.register("theyulelightsaber", LightsaberItem::createPowerful);
    public static final RegistryObject<Item> WHITELIGHTSABER = ITEMS.register("whitelightsaber", LightsaberItem::createNormal);
    public static final RegistryObject<Item> REDLIGHTSABER = ITEMS.register("redlightsaber", LightsaberItem::createNormal);
    public static final RegistryObject<Item> GREENLIGHTSABER = ITEMS.register("greenlightsaber", LightsaberItem::createNormal);
    public static final RegistryObject<Item> BLUELIGHTSABER = ITEMS.register("bluelightsaber", LightsaberItem::createNormal);

    public static final RegistryObject<Item> BALLSACK = ITEMS.register("ballsack", () -> new Item(new Item.Properties()
            .tab(MarkAbrahamTabInstance)
            .food(new FoodProperties.Builder()
                    .nutrition(16)
                    .saturationMod(8)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 4), 1f)
                    .meat()
                    .fast()
                    .alwaysEat()
                    .build())));

    public static final RegistryObject<Item> HARDTACK = ITEMS.register("hardtack", () -> new Item(new Item.Properties()
            .tab(MarkAbrahamTabInstance)
            .food(new FoodProperties.Builder()
                    .nutrition(0)
                    .saturationMod(4)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1f)
                    .alwaysEat()
                    .build())) {
        public @NotNull SoundEvent getEatingSound() {
            return SoundInit.HARDTACK.get();
        }
    });
}