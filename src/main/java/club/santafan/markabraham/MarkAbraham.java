package club.santafan.markabraham;

import club.santafan.markabraham.init.SoundInit;
import com.mojang.logging.LogUtils;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static club.santafan.markabraham.init.BlockInit.BLOCKS;
import static club.santafan.markabraham.init.ItemInit.ITEMS;
import static club.santafan.markabraham.init.SoundInit.SOUND_EVENTS;

@Mod(MarkAbraham.MODID)
public class MarkAbraham {
    public static final String MODID = "markabraham";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MarkAbraham() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        BLOCKS.register(bus);
        ITEMS.register(bus);
        SOUND_EVENTS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Mark Abraham has initiated.");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Mark Abraham server has initiated.");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("Mark Abraham client has initiated.");
        }
    }
}