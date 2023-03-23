# RuneLite NPC Accessibility Tagger Plugin

This plugin allows users to tag NPCs with colored text to improve accessibility, particularly for individuals who are colorblind. With this plugin, you can customize the text and color associated with specific NPCs.

## Installation

To install this plugin, simply search for "NPC Accessibility Tagger" in the plugin hub and click "Install".

## Usage

To use this plugin, you must first create a configuration file in the following format:

```
npc_id:text:hex_color_code
```

Each entry in the configuration file should be separated by commas. For example, to tag NPC 123 with the text "Shopkeeper" in green, you would add the following entry to your configuration file:

```
123:Shopkeeper:#00FF00
```

Modify the plugin settings and paste your configuration file into the "Config settings" space. The plugin will automatically read your configuration file and apply your NPC tags in the game world.

## Getting NPC IDs

You can use the [NPC ID plugin by Xrio](https://github.com/XrioBtw/npc-id) in the plugin hub, use runelite dev mode, or gather NPC ids from the wiki.

### Getting NPC IDs from wiki

Create and login to a [osrs wiki](oldschool.runescape.wiki) account. Go to [Preferences -> Gadgets](https://oldschool.runescape.wiki/w/Special:Preferences#mw-prefsection-gadgets). Check "Display advanced data in infoboxes, such as item IDs." and save your preferences. Now, when you view an NPC page, you will see the NPC's ID in the infobox.

## Author

This plugin was created by R-Y-M-R.
