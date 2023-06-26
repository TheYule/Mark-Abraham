package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MarkAbraham.MODID);

    public static final RegistryObject<SoundEvent> LIGHTSABER = registerSoundEvent("lightsaber");
    public static final RegistryObject<SoundEvent> HARDTACK = registerSoundEvent("hardtack");
    public static final RegistryObject<SoundEvent> FART = registerSoundEvent("fart");
    public static final RegistryObject<SoundEvent> DIARRHEA = registerSoundEvent("diarrhea");

    public static final RegistryObject<SoundEvent> MARKABRAHAM_BLOCK_BREAK = reregisterVanillaSoundEvent("markabraham_block_break", SoundEvents.MUD_BREAK);
    public static final RegistryObject<SoundEvent> MARKABRAHAM_BLOCK_STEP = reregisterVanillaSoundEvent("markabraham_block_step", SoundEvents.MUD_STEP);
    public static final RegistryObject<SoundEvent> MARKABRAHAM_BLOCK_HIT = reregisterVanillaSoundEvent("markabraham_block_hit", SoundEvents.MUD_HIT);
    public static final RegistryObject<SoundEvent> MARKABRAHAM_BLOCK_FALL = reregisterVanillaSoundEvent("markabraham_block_fall", SoundEvents.MUD_FALL);
    public static final RegistryObject<SoundEvent> SHIT_BLOCK_BREAK = reregisterVanillaSoundEvent("shit_block_break", SoundEvents.HONEY_BLOCK_BREAK);
    public static final RegistryObject<SoundEvent> SHIT_BLOCK_STEP = reregisterVanillaSoundEvent("shit_block_step", SoundEvents.HONEY_BLOCK_STEP);
    public static final RegistryObject<SoundEvent> SHIT_BLOCK_HIT = reregisterVanillaSoundEvent("shit_block_hit", SoundEvents.HONEY_BLOCK_HIT);
    public static final RegistryObject<SoundEvent> SHIT_BLOCK_FALL = reregisterVanillaSoundEvent("shit_block_fall", SoundEvents.HONEY_BLOCK_FALL);

    public static final ForgeSoundType MARKABRAHAM_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f, MARKABRAHAM_BLOCK_BREAK, MARKABRAHAM_BLOCK_STEP, FART, MARKABRAHAM_BLOCK_HIT, MARKABRAHAM_BLOCK_FALL);
    public static final ForgeSoundType SHIT_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f, SHIT_BLOCK_BREAK, SHIT_BLOCK_STEP, DIARRHEA, SHIT_BLOCK_HIT, SHIT_BLOCK_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MarkAbraham.MODID, name)));
    }

    private static RegistryObject<SoundEvent> reregisterVanillaSoundEvent(String name, SoundEvent soundEvent) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(soundEvent.getLocation()));
    }
}