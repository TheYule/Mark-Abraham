package club.santafan.markabraham.world;

import club.santafan.markabraham.block.MarkLandPortalBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

import static club.santafan.markabraham.init.BlockInit.MARK_LAND_PORTAL;

public class MarkLandTeleporter implements ITeleporter {
    private final ServerLevel level;

    public MarkLandTeleporter(ServerLevel level) {
        this.level = level;
    }

    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        int minY = destWorld.getMinBuildHeight();
        int maxY = minY + destWorld.getLogicalHeight();
        boolean foundPortal = false;
        int portalY = minY;

        for (int i = maxY; i >= minY; i--) {
            Block block = destWorld.getBlockState(new BlockPos(x, i, z)).getBlock();
            if (block == Blocks.AIR) portalY = i;
            else if (block == MARK_LAND_PORTAL.get()) {
                foundPortal = true;
                portalY = i;
                break;
            }
        }

        if (!foundPortal) destWorld.setBlockAndUpdate(new BlockPos(x, portalY, z), MARK_LAND_PORTAL.get().defaultBlockState());

        return new PortalInfo(new Vec3(x, portalY, z), Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }
}