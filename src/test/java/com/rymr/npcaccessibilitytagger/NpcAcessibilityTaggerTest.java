package com.rymr.npcaccessibilitytagger;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class NpcAcessibilityTaggerTest {
    public static void main(String[] args) throws Exception
    {
        ExternalPluginManager.loadBuiltin(NpcAccessibilityTaggerPlugin.class);
        RuneLite.main(args);
    }
}