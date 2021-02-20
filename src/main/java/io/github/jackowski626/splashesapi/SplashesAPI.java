package io.github.jackowski626.splashesapi;

import net.fabricmc.api.ModInitializer;

import java.util.ArrayList;
import java.util.List;

public class SplashesAPI implements ModInitializer {
    private static List<String> splashesToAdd = new ArrayList<>();
    private static List<String> splashesToRemove = new ArrayList<>();
    private static boolean removeAll = false;

    @Override
    public void onInitialize() {
        System.out.println("hello");
    }

    public void addSplash(String splash) {
        splashesToAdd.add(splash);
    }

    public void removeSplash(String splash) {
        splashesToRemove.add(splash);
    }

    public static List<String> getAllSplashesToAdd() {
        return splashesToAdd;
    }

    public static List<String> getAllSplashesToRemove() {
        return splashesToRemove;
    }

    public static void clearSplashes() {
        removeAll = true;
    }

    public static boolean isRemoveAll() {
        return removeAll;
    }

    public static void resetRemoveStatus() {
        removeAll = false;
    }
}
