package club.santafan.markabraham.item;

import club.santafan.markabraham.entity.ShitProjectileEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static club.santafan.markabraham.init.EntityInit.SHIT_PROJECTILE_ENTITY;

public class ShitItem extends ArrowItem {
    public ShitItem(Properties properties) {
        super(properties);
    }

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 800;
    }

    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level world, @NotNull ItemStack ammoStack, @NotNull LivingEntity shooter) {
        return new ShitProjectileEntity(SHIT_PROJECTILE_ENTITY.get(), shooter, world);
    }
}