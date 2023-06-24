package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MarkAbraham.MODID);

    public static final RegistryObject<Block> MARKABRAHAM_BLOCK = BLOCKS.register("markabraham_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD)
            .lightLevel((state) -> 15)));
}