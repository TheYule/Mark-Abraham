package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import club.santafan.markabraham.block.MarkLandPortalBlock;
import club.santafan.markabraham.item.CopperArmorItem;
import club.santafan.markabraham.item.CopperHorseArmorItem;
import club.santafan.markabraham.item.LightsaberItem;
import club.santafan.markabraham.item.ShitItem;
import club.santafan.markabraham.util.CopperArmorMaterial;
import club.santafan.markabraham.util.CopperToolTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import static club.santafan.markabraham.init.BlockInit.MARK_LAND_PORTAL;
import static club.santafan.markabraham.world.MarkLandDimension.MARK_LAND_DIMENSION_KEY;

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

    public static final MarkAbrahamTab MarkAbrahamTabInstance = new MarkAbrahamTab(CreativeModeTab.TABS.length, "markabraham");

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MarkAbraham.MODID);

    public static final RegistryObject<Item> MARKABRAHAM_BLOCK = ITEMS.register("markabraham_block", () -> new BlockItem(BlockInit.MARKABRAHAM_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COMPRESSED_MARKABRAHAM_BLOCK = ITEMS.register("compressed_markabraham_block", () -> new BlockItem(BlockInit.COMPRESSED_MARKABRAHAM_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> DOUBLE_COMPRESSED_MARKABRAHAM_BLOCK = ITEMS.register("double_compressed_markabraham_block", () -> new BlockItem(BlockInit.DOUBLE_COMPRESSED_MARKABRAHAM_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> MARK_LAND_PORTAL = ITEMS.register("mark_land_portal", () -> new BlockItem(BlockInit.MARK_LAND_PORTAL.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> JOEBALEM_BLOCK = ITEMS.register("joebalem_block", () -> new BlockItem(BlockInit.JOEBALEM_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> BITCH_BLOCK = ITEMS.register("bitch_block", () -> new BlockItem(BlockInit.BITCH_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> TYWERDEBOUS_BLOCK = ITEMS.register("tywerdebous_block", () -> new BlockItem(BlockInit.TYWERDEBOUS_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> SHIT_BLOCK = ITEMS.register("shit_block", () -> new BlockItem(BlockInit.SHIT_BLOCK.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)
            .food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(8)
                    .alwaysEat()
                    .build())) {
        public @NotNull SoundEvent getEatingSound() {
            return SoundInit.DIARRHEA.get();
        }
    });

    public static final RegistryObject<Item> SHIT_PLANT = ITEMS.register("shit_plant", () -> new BlockItem(BlockInit.SHIT_PLANT.get(), new Item.Properties()
            .tab(MarkAbrahamTabInstance)
            .food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(8)
                    .alwaysEat()
                    .build())) {
        public @NotNull SoundEvent getEatingSound() {
            return SoundInit.DIARRHEA.get();
        }
    });

    public static final RegistryObject<Item> DARKSABER = ITEMS.register("darksaber", LightsaberItem::createDarksaber);
    public static final RegistryObject<Item> THEYULELIGHTSABER = ITEMS.register("theyulelightsaber", LightsaberItem::createTheYule);
    public static final RegistryObject<Item> WHITELIGHTSABER = ITEMS.register("whitelightsaber", LightsaberItem::createNormal);
    public static final RegistryObject<Item> REDLIGHTSABER = ITEMS.register("redlightsaber", LightsaberItem::createNormal);
    public static final RegistryObject<Item> GREENLIGHTSABER = ITEMS.register("greenlightsaber", LightsaberItem::createNormal);
    public static final RegistryObject<Item> BLUELIGHTSABER = ITEMS.register("bluelightsaber", LightsaberItem::createNormal);

    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new CopperArmorItem(CopperArmorMaterial.NORMAL, EquipmentSlot.HEAD, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new CopperArmorItem(CopperArmorMaterial.NORMAL, EquipmentSlot.CHEST, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new CopperArmorItem(CopperArmorMaterial.NORMAL, EquipmentSlot.LEGS, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new CopperArmorItem(CopperArmorMaterial.NORMAL, EquipmentSlot.FEET, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(CopperToolTier.NORMAL, 2, -3f, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(CopperToolTier.NORMAL, 5f, -3.5f, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CopperToolTier.NORMAL, 1, -3.5f, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(CopperToolTier.NORMAL, 1f, -3.5f, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(CopperToolTier.NORMAL, -2, -1.5f, new Item.Properties()
            .tab(MarkAbrahamTabInstance)));
    public static final RegistryObject<Item> COPPER_HORSE_ARMOR = ITEMS.register("copper_horse_armor", CopperHorseArmorItem::new);

    public static final RegistryObject<Item> SHIT = ITEMS.register("shit", ShitItem::new);

    public static final RegistryObject<Item> BALLSACK = ITEMS.register("ballsack", () -> new Item(new Item.Properties()
            .tab(MarkAbrahamTabInstance)
            .food(new FoodProperties.Builder()
                    .nutrition(16)
                    .saturationMod(16)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 4), 1f)
                    .meat()
                    .fast()
                    .alwaysEat()
                    .build())));

    public static final RegistryObject<Item> HARDTACK = ITEMS.register("hardtack", () -> new Item(new Item.Properties()
            .tab(MarkAbrahamTabInstance)
            .food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(4)
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 150, 0), 1f)
                    .alwaysEat()
                    .build())) {
        public @NotNull SoundEvent getEatingSound() {
            return SoundInit.HARDTACK.get();
        }
    });
}