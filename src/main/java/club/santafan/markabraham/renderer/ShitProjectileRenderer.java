package club.santafan.markabraham.renderer;

import club.santafan.markabraham.MarkAbraham;
import club.santafan.markabraham.entity.ShitProjectileEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ShitProjectileRenderer extends ArrowRenderer<ShitProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MarkAbraham.MODID, "textures/entities/shit_projectile.png");

    public ShitProjectileRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull ShitProjectileEntity arrow) {
        return TEXTURE;
    }
}