package club.santafan.markabraham.util;

import club.santafan.markabraham.init.ItemInit;
import club.santafan.markabraham.init.SoundInit;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LightsaberItem extends SwordItem {
    public static LightsaberItem createNormal() {
        return new LightsaberItem(LightsaberTier.NORMAL, 0, 2f, new Item.Properties());
    }
    public static LightsaberItem createPowerful() {
        return new LightsaberItem(LightsaberTier.POWERFUL, 0, 4f, new Item.Properties());
    }

    public LightsaberItem(LightsaberTier tier, int damage, float attackSpeed, Properties properties) {
        super(tier, damage, attackSpeed, properties.tab(ItemInit.MarkAbrahamTabInstance));
    }

    public boolean hurtEnemy(@NotNull ItemStack item, @NotNull LivingEntity player, @NotNull LivingEntity entity) {
        Level world = player.getLevel();

        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundInit.LIGHTSABER.get(), SoundSource.PLAYERS, 1f, 1f);

        return super.hurtEnemy(item, player, entity);
    }
}