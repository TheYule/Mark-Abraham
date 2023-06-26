package club.santafan.markabraham;

import club.santafan.markabraham.renderer.ShitProjectileRenderer;
import club.santafan.markabraham.util.Events;
import club.santafan.markabraham.world.MarkLandDimension;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static club.santafan.markabraham.init.BlockInit.BLOCKS;
import static club.santafan.markabraham.init.ConfiguredFeaturesInit.CONFIGURED_FEATURES;
import static club.santafan.markabraham.init.EntityInit.ENTITY_TYPES;
import static club.santafan.markabraham.init.EntityInit.SHIT_PROJECTILE_ENTITY;
import static club.santafan.markabraham.init.ItemInit.*;
import static club.santafan.markabraham.init.POIsInit.POIS;
import static club.santafan.markabraham.init.PlacedFeaturesInit.PLACED_FEATURES;
import static club.santafan.markabraham.init.SoundInit.SOUND_EVENTS;

@Mod(MarkAbraham.MODID)
public class MarkAbraham {
    public static final String MODID = "markabraham";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MarkAbraham() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);

        BLOCKS.register(bus);
        CONFIGURED_FEATURES.register(bus);
        ENTITY_TYPES.register(bus);
        ITEMS.register(bus);
        PLACED_FEATURES.register(bus);
        POIS.register(bus);
        SOUND_EVENTS.register(bus);

        MarkLandDimension.register();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(Events.class);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Mark Abraham mod has initiated.");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Mark Abraham mod server has initiated.");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(SHIT_PROJECTILE_ENTITY.get(), ShitProjectileRenderer::new);

            event.enqueueWork(() -> {
                ComposterBlock.COMPOSTABLES.put(SHIT_BLOCK.get(), 1f);
                ComposterBlock.COMPOSTABLES.put(SHIT_PLANT.get(), 1f);
                ComposterBlock.COMPOSTABLES.put(SHIT.get(), 1f);
                ComposterBlock.COMPOSTABLES.put(BALLSACK.get(), 1f);
                ComposterBlock.COMPOSTABLES.put(HARDTACK.get(), .3f);
            });

            LOGGER.info("Mark Abraham mod client has initiated.");
        }
    }
}