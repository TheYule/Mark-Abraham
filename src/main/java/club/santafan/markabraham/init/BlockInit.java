package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import club.santafan.markabraham.world.ShitTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MarkAbraham.MODID);

    public static final RegistryObject<Block> MARKABRAHAM_BLOCK = BLOCKS.register("markabraham_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD)
            .lightLevel((state) -> 15)
            .sound(SoundInit.MARKABRAHAM_BLOCK_SOUNDS)));
    public static final RegistryObject<Block> JOEBALEM_BLOCK = BLOCKS.register("joebalem_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD)
            .lightLevel((state) -> 15)));
    public static final RegistryObject<Block> BITCH_BLOCK = BLOCKS.register("bitch_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD)
            .lightLevel((state) -> 15)));
    public static final RegistryObject<Block> TYWERDEBOUS_BLOCK = BLOCKS.register("tywerdebous_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD)
            .lightLevel((state) -> 15)));
    public static final RegistryObject<Block> SHIT_BLOCK = BLOCKS.register("shit_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK)
            .instabreak()
            .sound(SoundInit.SHIT_BLOCK_SOUNDS)));

    public static final RegistryObject<Block> SHIT_PLANT = BLOCKS.register("shit_plant", () -> new SaplingBlock(new ShitTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
            .sound(SoundInit.SHIT_BLOCK_SOUNDS)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return false;
        }
    });
}