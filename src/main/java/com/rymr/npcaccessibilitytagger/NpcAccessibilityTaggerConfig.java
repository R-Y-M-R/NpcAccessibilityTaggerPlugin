package com.rymr.npcaccessibilitytagger;

import java.awt.Color;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

/*
 * Copyright (c) 2023, R-Y-M-R
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
@ConfigGroup(NpcAccessibilityTaggerConfig.GROUP)
public interface NpcAccessibilityTaggerConfig extends Config {
    String GROUP = "npcaccessibilitytagger";

    @ConfigSection(
            name = "Text Style",
            description = "The text style of NPC tagging",
            position = 0
    )
    String textStyleSection = "textStyleSection";

    @ConfigSection(
            name = "Accessibility settings",
            description = "Accessibility settings for NPC tagging",
            position = 1
    )
    String configSettingsSection = "configSettingsSection";

    @ConfigSection(
            name = "Color Swatch",
            description = "Useful for testing colors but not changing anything.",
            position = 2
    )
    String colorSwatchSection = "colorSwatchSection";

    @ConfigItem(
            position = 5,
            keyName = "defaultFontColor",
            name = "Default Font Color",
            description = "The default font color is used when a specific color isn't specified for a specific NPC.",
            section = textStyleSection
    )
    default Color defaultFontColor() {
        return Color.WHITE;
    }


    @ConfigItem(
            position = 0,
            keyName = "appendWordToNPC",
            name = "Append word to NPC",
            description = "Configures whether or not NPC should have a word on it",
            section = textStyleSection
    )
    default boolean appendWordToNPC() {
        return true;
    }

    @ConfigItem(
            position = 1,
            keyName = "heightAboveNPC",
            name = "Height above NPC",
            description = "Configures the height above NPC",
            section = textStyleSection
    )
    default int heightAboveNPC() {
        return 40; // @todo update with legit value
    }

    @ConfigItem(
            position = 4,
            keyName = "enableCustomTextColor",
            name = "Enable custom text coloring",
            description = "Configures whether or not the custom text color should be used",
            section = textStyleSection
    )
    default boolean enableCustomTextColor() {
        return true;
    }

    @ConfigItem(
            position = 2,
            keyName = "fontStyle",
            name = "Font Style",
            description = "Select which font you wish to use",
            section = textStyleSection
    )
    default FontOption fontStyle()
    {
        return FontOption.RUNESCAPE;
    }

    @ConfigItem(
            position = 3,
            keyName = "fontSize",
            name = "Font Size",
            description = "Select which font size you wish to use",
            section = textStyleSection
    )
    default double fontSize() {
        return 15.0f;
    }

    @ConfigItem(
            position = 0,
            keyName = "endUserConfig",
            name = "Config settings",
            description = "Config settings",
            section = configSettingsSection
    )
    default String endUserConfig() {
        if (enableCustomTextColor()) {
            return "3101:Hans:#B40404";
        } else {
            return "3101:Hans";
        }
    }

    @ConfigItem(
            position = 0,
            keyName = "colorSwatch",
            name = "Color swatch",
            description = "Color swatch for custom NPC tagging",
            section = colorSwatchSection
    )
    default Color colorSwatch() {
        return Color.WHITE;
    }
}