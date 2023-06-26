package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static club.santafan.markabraham.init.BlockInit.SHIT_PLANT;
import static club.santafan.markabraham.init.ConfiguredFeaturesInit.SHIT_TREE;
import static club.santafan.markabraham.init.ConfiguredFeaturesInit.SHIT_TREE_SPAWN;

public class PlacedFeaturesInit {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MarkAbraham.MODID);

    public static final RegistryObject<PlacedFeature> SHIT_TREE_CHECKED = PLACED_FEATURES.register("shit_tree_checked", () -> new PlacedFeature(SHIT_TREE.getHolder().get(), List.of(PlacementUtils.filteredByBlockSurvival(SHIT_PLANT.get()))));
    public static final RegistryObject<PlacedFeature> SHIT_TREE_PLACED = PLACED_FEATURES.register("shit_tree_placed", () -> new PlacedFeature(SHIT_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, .1f, 1)))); // #, % chance for extra, # extra
}