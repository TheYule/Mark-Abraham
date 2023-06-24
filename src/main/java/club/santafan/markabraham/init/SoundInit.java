package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MarkAbraham.MODID);

    public static final RegistryObject<SoundEvent> LIGHTSABER = registerSoundEvent("lightsaber");
    public static final RegistryObject<SoundEvent> HARDTACK = registerSoundEvent("hardtack");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MarkAbraham.MODID, name)));
    }
}