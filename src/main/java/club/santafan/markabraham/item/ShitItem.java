package club.santafan.markabraham.item;

import club.santafan.markabraham.block.MarkLandPortalBlock;
import club.santafan.markabraham.entity.ShitProjectileEntity;
import club.santafan.markabraham.init.SoundInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static club.santafan.markabraham.init.BlockInit.MARK_LAND_PORTAL;
import static club.santafan.markabraham.init.EntityInit.SHIT_PROJECTILE_ENTITY;
import static club.santafan.markabraham.init.ItemInit.MarkAbrahamTabInstance;
import static club.santafan.markabraham.world.MarkLandDimension.MARK_LAND_DIMENSION_KEY;

public class ShitItem extends ArrowItem {
    public ShitItem() {
        super(new Item.Properties()
                .tab(MarkAbrahamTabInstance)
                .food(new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(2)
                        .alwaysEat()
                        .build()));
    }

    public @NotNull SoundEvent getEatingSound() {
        return SoundInit.FART.get();
    }

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 800;
    }

    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level world, @NotNull ItemStack ammoStack, @NotNull LivingEntity shooter) {
        return new ShitProjectileEntity(SHIT_PROJECTILE_ENTITY.get(), shooter, world);
    }
}