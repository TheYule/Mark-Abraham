package club.santafan.markabraham.entity;

import club.santafan.markabraham.init.ItemInit;
import club.santafan.markabraham.init.SoundInit;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class ShitProjectileEntity extends AbstractArrow {
    public ShitProjectileEntity(EntityType<ShitProjectileEntity> entityType, Level world) {
        super(entityType, world);

        this.setSoundEvent(SoundInit.DIARRHEA.get());
    }

    public ShitProjectileEntity(EntityType<ShitProjectileEntity> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);

        this.setSoundEvent(SoundInit.DIARRHEA.get());
    }

    public ShitProjectileEntity(EntityType<ShitProjectileEntity> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);

        this.setSoundEvent(SoundInit.DIARRHEA.get());
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        return new ItemStack(ItemInit.SHIT.get());
    }

    protected void onHitEntity(@NotNull EntityHitResult ray) {
        super.onHitEntity(ray);
        this.level.explode(this, this.getX(), this.getY(), this.getZ(), 1f, false, Explosion.BlockInteraction.NONE);
    }

    @Override
    protected void tickDespawn() {
        if (this.inGroundTime > 40){
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), 1f, false, Explosion.BlockInteraction.NONE);
            this.discard();
        }
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}