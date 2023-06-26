package club.santafan.markabraham.item;

import club.santafan.markabraham.util.IDamageHandlingArmor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CopperArmorItem extends ArmorItem implements IDamageHandlingArmor {
    public CopperArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 0, 1, false, false, false));
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public float onDamaged(LivingEntity entity, EquipmentSlot slot, DamageSource source, float amount) {
        Entity attacker = source.getEntity();

        if (attacker instanceof LivingEntity) attacker.setSecondsOnFire(2);

        return amount;
    }
}