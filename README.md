# RuneLite NPC Accessibility Tagger Plugin

This plugin allows users to tag NPCs with colored text to improve accessibility, particularly for individuals who are colorblind. With this plugin, you can customize the text and color associated with specific NPCs.

## Installation

To install this plugin, simply search for "NPC Accessibility Tagger" in the plugin hub and click "Install".

## Creating a Config

### Creating a Default Color Entry

To create a default color entry, use the following format in your config:

```
npc_id:text
```

For example, you could create a few entries for Zulrah's different forms using the default color like so:

```
2042:Range,
2043:Mage,
2044:Melee
```

Because this config doesn't contain any hex color codes, the plugin will use your default configured color for these NPCs.

### Creating a NPC Specific Color Entry

To create a specific color entry, use the following format in your config:

```
npc_id:text:hex_color_code
``` 

For example, you could create a few entries for Zulrah's different forms using specific colors like so:

```
2042:Range:#59cf26,
2043:Mage:#266ccf,
2044:Melee:#cf2626
```

### Mixing and Matching

You can mix and match both types of entry in your config. 

### Multiple Entries

Each entry in the configuration file must be comma deliminated. Plainly, after each entry add a comma. 

For formatting, ideally you can have 1 entry per line.

## Getting NPC IDs

You can use the [NPC ID plugin by Xrio](https://github.com/XrioBtw/npc-id) in the plugin hub, use Runelite Dev Mode, or gather NPC ids from the wiki.

### Getting NPC IDs from wiki

Create and login to a [osrs wiki](https://oldschool.runescape.wiki/) account. Go to [Preferences -> Gadgets](https://oldschool.runescape.wiki/w/Special:Preferences#mw-prefsection-gadgets). Check "Display advanced data in infoboxes, such as item IDs." and save your preferences. Now, when you view an NPC page, you will see the NPC's ID in the infobox.

## Author

This plugin was created by R-Y-M-R.

## Support, Help, Bugs, Suggestions

[Create a detailed issue on github](https://github.com/R-Y-M-R/NpcAccessibilityTaggerPlugin/issues/new/choose), or ask someone kindly in the [runelite discord](https://runelite.net/discord).