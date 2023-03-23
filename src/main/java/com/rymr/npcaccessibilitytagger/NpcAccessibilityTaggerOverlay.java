package com.rymr.npcaccessibilitytagger;

import com.google.inject.Inject;

import java.awt.*;
import java.util.Optional;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

/*
 * Copyright (c) 2023, R-Y-M-R
 * Copyright (c) 2021, Xrio
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
public class NpcAccessibilityTaggerOverlay extends Overlay {
    private final Client client;
    private final NpcAccessibilityTaggerConfig config;

    @Inject
    NpcAccessibilityTaggerOverlay(Client client, NpcAccessibilityTaggerConfig config) {
        this.client = client;
        this.config = config;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if (config.appendWordToNPC()) {
            for (NPC npc : client.getCachedNPCs()) {
                if (npc == null) {
                    continue;
                }
                Optional<StandardEntry> matchingEntry = NpcAccessibilityTaggerParser.getInstance().getEntries().stream().filter(entry -> entry.getId() == npc.getId()).findAny();
                matchingEntry.ifPresent(standardEntry -> renderNpcOverlay(graphics, npc, standardEntry));
            }
        }
        return null;
    }

    private void renderNpcOverlay(Graphics2D graphics, NPC npc, StandardEntry entry) {
        final Point textLocation = npc.getCanvasTextLocation(graphics, entry.getText(), npc.getLogicalHeight() + config.heightAboveNPC());

        graphics.setFont(config.fontStyle().getFont().deriveFont((float) config.fontSize()));

        if (textLocation != null) {

            if (config.enableCustomTextColor() && entry instanceof ExtendedEntry) {
                OverlayUtil.renderTextLocation(graphics, textLocation, entry.getText(), ((ExtendedEntry) entry).getColor());
            } else {
                OverlayUtil.renderTextLocation(graphics, textLocation, entry.getText(), config.defaultFontColor());
            }
        }
    }
}

