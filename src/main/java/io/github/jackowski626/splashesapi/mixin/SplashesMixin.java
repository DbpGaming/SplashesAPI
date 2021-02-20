package io.github.jackowski626.splashesapi.mixin;

import io.github.jackowski626.splashesapi.SplashesAPI;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.jetbrains.annotations.ApiStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(net.minecraft.client.resource.SplashTextResourceSupplier.class)
public class SplashesMixin {
    @Shadow
    private List<String> splashTexts;

    @Inject(method="apply", at=@At("TAIL"))
    private void inject(CallbackInfo info) {
        List<String> newSplashes = SplashesAPI.getAllSplashesToAdd();
        if (!SplashesAPI.isRemoveAll()) {
            for (String s : splashTexts) {
                if (!SplashesAPI.getAllSplashesToRemove().contains(s)) {
                    newSplashes.add(s);
                }
            }
        }
        splashTexts.clear();
        splashTexts.addAll(newSplashes);
        SplashesAPI.resetRemoveStatus();
    }
}
