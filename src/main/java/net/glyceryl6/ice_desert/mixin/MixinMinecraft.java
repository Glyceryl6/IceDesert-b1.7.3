package net.glyceryl6.ice_desert.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ThreadDownloadResources;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Redirect(method = "run", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;method_2111(J)V"))
    public void run(Minecraft instance, long l) {}

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/ThreadDownloadResources;start()V"), remap = false)
    public void init(ThreadDownloadResources resources) {}

    @Redirect(method = "forceResourceReload", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/ThreadDownloadResources;method_107()V"))
    public void forceResourceReload(ThreadDownloadResources resources) {}

}