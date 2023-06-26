package club.santafan.markabraham.world;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class MarkLandDimension {
    public static final ResourceKey<Level> MARK_LAND_DIMENSION_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MarkAbraham.MODID, "mark_land"));
    public static final ResourceKey<DimensionType> MARK_LAND_DIMENSION_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, MARK_LAND_DIMENSION_KEY.registry());

    public static void register() {
        MarkAbraham.LOGGER.info("Mark Land dimension registered.");
    }
}