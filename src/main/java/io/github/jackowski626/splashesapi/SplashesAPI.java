package io.github.jackowski626.splashesapi;

import java.util.*;

public class SplashesAPI {
    private static List<String> splashesToAdd = new ArrayList<>();
    private static List<String> splashesToRemove = new ArrayList<>();

    public static void addSplash(String splash) {
        splashesToAdd.add(splash);
    }

    public static void removeSplash(String splash) {
        splashesToRemove.add(splash);
    }

    public static List<String> getAllSplashesToAdd() {
        return splashesToAdd;
    }

    public static List<String> getAllSplashesToRemove() {
        return splashesToRemove;
    }
}
