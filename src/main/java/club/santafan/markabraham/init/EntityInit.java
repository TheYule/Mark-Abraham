package club.santafan.markabraham.init;

import club.santafan.markabraham.MarkAbraham;
import club.santafan.markabraham.entity.ShitProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MarkAbraham.MODID);

    public static final RegistryObject<EntityType<ShitProjectileEntity>> SHIT_PROJECTILE_ENTITY = ENTITY_TYPES.register("shit_projectile", () -> EntityType.Builder.of((EntityType.EntityFactory<ShitProjectileEntity>) ShitProjectileEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("shit_projectile"));
}