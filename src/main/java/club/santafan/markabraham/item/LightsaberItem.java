package club.santafan.markabraham.item;

import club.santafan.markabraham.init.ItemInit;
import club.santafan.markabraham.init.SoundInit;
import club.santafan.markabraham.util.LightsaberTier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import org.jetbrains.annotations.NotNull;

public class LightsaberItem extends SwordItem {
    public static LightsaberItem createNormal() {
        return new LightsaberItem(LightsaberTier.NORMAL, 0, 2f, new Item.Properties());
    }
    public static LightsaberItem createDarksaber() {
        return new LightsaberItem(LightsaberTier.DARKSABER, 0, 4f, new Item.Properties());
    }

    public static LightsaberItem createTheYule() {
        return new LightsaberItem(LightsaberTier.DARKSABER, 5, 8f, new Item.Properties());
    }

    public LightsaberItem(LightsaberTier tier, int damage, float attackSpeed, Properties properties) {
        super(tier, damage, attackSpeed, properties.tab(ItemInit.MarkAbrahamTabInstance));
    }

    public boolean hurtEnemy(@NotNull ItemStack item, @NotNull LivingEntity entity, @NotNull LivingEntity player) {
        player.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(), SoundInit.LIGHTSABER.get(), SoundSource.PLAYERS, 1f, 1f);
        entity.setSecondsOnFire(5);

        return super.hurtEnemy(item, entity, player);
    }
}