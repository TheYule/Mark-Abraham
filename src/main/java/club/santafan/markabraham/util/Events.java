package club.santafan.markabraham.util;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Events {
    @SubscribeEvent
    public static void armorAttackHandler(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();

        for (ItemStack armor : event.getEntity().getArmorSlots()) if (armor.getItem() instanceof IDamageHandlingArmor) event.setAmount(((IDamageHandlingArmor) armor.getItem()).onDamaged(entity, armor.getEquipmentSlot(), event.getSource(), event.getAmount()));
    }
}