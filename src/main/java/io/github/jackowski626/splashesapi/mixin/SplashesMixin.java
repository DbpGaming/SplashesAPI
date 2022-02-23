package io.github.jackowski626.splashesapi.mixin;

import io.github.jackowski626.splashesapi.SplashesAPI;
import net.fabricmc.api.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(net.minecraft.client.resource.SplashTextResourceSupplier.class)
public class SplashesMixin {
    @Shadow
    private List<String> splashTexts;

    @Inject(method="apply", at=@At("TAIL"))
    private void inject(CallbackInfo info) {
        splashTexts.addAll(SplashesAPI.getAllSplashesToAdd());
        splashTexts.removeAll(SplashesAPI.getAllSplashesToRemove());
    }
}
