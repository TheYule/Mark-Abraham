package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.core.Registry;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static club.santafan.markabraham.init.BlockInit.MARKABRAHAM_BLOCK;
import static club.santafan.markabraham.init.BlockInit.SHIT_BLOCK;
import static club.santafan.markabraham.init.PlacedFeaturesInit.SHIT_TREE_CHECKED;

public class ConfiguredFeaturesInit {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MarkAbraham.MODID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> SHIT_TREE = CONFIGURED_FEATURES.register("shit_tree", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(SHIT_BLOCK.get()), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(MARKABRAHAM_BLOCK.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SHIT_TREE_SPAWN = CONFIGURED_FEATURES.register("shit_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SHIT_TREE_CHECKED.getHolder().get(), .5f)), SHIT_TREE_CHECKED.getHolder().get())));
}