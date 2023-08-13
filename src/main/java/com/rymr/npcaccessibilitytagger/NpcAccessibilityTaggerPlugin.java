package com.rymr.npcaccessibilitytagger;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

/*
 * Copyright (c) 2023, R-Y-M-R
 * Copyright (c) 2021, Xrio
 * Copyright (c) 2018, James Swindle <wilingua@gmail.com>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * Credit to Xrio, James Swindle, and Adam for code I referenced / used in this plugin.
 */
@PluginDescriptor(
        name = "NPC Accessibility Tagger",
        description = "Tags NPCs with text for easier visual identification, aimed at helping people with accessibility issues",
        tags = {"npcs", "accessibility", "tagger", "overlay", "tags"}
)
@Slf4j
public class NpcAccessibilityTaggerPlugin extends Plugin {

    @Inject
    private NpcAccessibilityTaggerConfig config;

    @Inject
    private NpcAccessibilityTaggerOverlay overlay;

    @Inject
    private OverlayManager overlayManager;

    @Override
    protected void startUp() throws Exception {
        log.info("Started plugin");
        updateAddition();
    }

    @Override
    protected void shutDown() throws Exception {
        log.info("Shutdown plugin");
        updateRemoval();
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged) {
        if (!configChanged.getGroup().equals(NpcAccessibilityTaggerConfig.GROUP)) {
            return;
        }
        update();
    }

    private void update() {
        updateRemoval();
        updateAddition();
    }

    private void updateRemoval() {
        NpcAccessibilityTaggerParser.getInstance().getEntries().clear();
        overlayManager.remove(overlay);
    }

    private void updateAddition() {
        NpcAccessibilityTaggerParser.getInstance().parse(config);
        overlayManager.add(overlay);
    }

    @Provides
    NpcAccessibilityTaggerConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(NpcAccessibilityTaggerConfig.class);
    }
}