package club.santafan.markabraham.block;

import club.santafan.markabraham.world.MarkLandTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import static club.santafan.markabraham.init.SoundInit.FART;
import static club.santafan.markabraham.world.MarkLandDimension.MARK_LAND_DIMENSION_KEY;

public class MarkLandPortalBlock extends Block {

    public MarkLandPortalBlock() {
        super(Properties.of(Material.PORTAL)
                .noCollission()
                .lightLevel((state) -> 15));
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Entity entity) {
        if (entity.canChangeDimensions()) { // !entity.isPassenger() && !entity.isVehicle()
            if (entity.isOnPortalCooldown()) entity.setPortalCooldown();
            else {
                if (!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) entity.portalEntrancePos = pos.immutable();
                Level entityWorld = entity.level;
                MinecraftServer minecraftserver = entityWorld.getServer();
                ResourceKey<Level> destination = entity.level.dimension() == MARK_LAND_DIMENSION_KEY ? Level.OVERWORLD : MARK_LAND_DIMENSION_KEY;
                if (minecraftserver != null) {
                    ServerLevel destinationWorld = minecraftserver.getLevel(destination);
                    if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
                        entity.level.getProfiler().push("mark_land_portal");
                        entity.setPortalCooldown();
                        entity.changeDimension(destinationWorld, new MarkLandTeleporter(destinationWorld));
                        entity.level.getProfiler().pop();
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, RandomSource random) {
        if (random.nextInt(100) == 0) {
            level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, FART.get(), SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double x = (double) pos.getX() + random.nextDouble();
            double y = (double) pos.getY() + random.nextDouble();
            double z = (double) pos.getZ() + random.nextDouble();
            double xSpeed = ((double) random.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = ((double) random.nextFloat() - 0.5D) * 0.5D;
            double zSpeed = ((double) random.nextFloat() - 0.5D) * 0.5D;
            int j = random.nextInt(2) * 2 - 1;
            x = (double) pos.getX() + 0.5D + 0.25D * (double) j;
            xSpeed = random.nextFloat() * 2.0F * (float) j;
            z = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
            zSpeed = random.nextFloat() * 2.0F * (float) j;

            level.addParticle(ParticleTypes.ASH, x, y, z, xSpeed, ySpeed, zSpeed);
        }

    }
}