package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class POIsInit {
    public static final DeferredRegister<PoiType> POIS = DeferredRegister.create(ForgeRegistries.POI_TYPES, MarkAbraham.MODID);

    public static final RegistryObject<PoiType> MARK_LAND_PORTAL = POIS.register("mark_land_portal", () -> new PoiType(ImmutableSet.copyOf(BlockInit.MARK_LAND_PORTAL.get().getStateDefinition().getPossibleStates()), 0, 1));
}