![TAIGA IMAGE](https://media.forgecdn.net/attachments/65/923/2016-07-26_00.png)

Tinkers Alloying Addon (TAIGA)
===============

TAIGA is an addon for Tinkers Construct. It adds new minable ores, new alloys and a bunch of new tinker traits for them.

Included:
 * 16 new meltable Ores with 4 new hardness levels (5,6,7,8)
 * 16 alloys in combination with new molten ores and molten items
 * actual 27 new Traits with random, funny, positive or negative effects
 * two new types of burnable items (e.g. lignite) and a bunch of other alloy-essential items
 * additional Gold and Iron (slagged), for the use in a lot of other mods. Iron is always too rare...
 * some new additional Blocks. Most of them just with an optical use - atm

 
Download
===============
* [Original mod on CurseForge](https://www.curseforge.com/minecraft/mc-mods/taiga-tinkers-alloying-addon)
* [This fork](https://github.com/WinterMan8367/TAIGA-Replant/releases)

Dependencies
===============
Necessary:
* Tinkers Construct for 1.12.2 + associated version of Mantle
* Minecraft Forge 1.12.2, version 14.23.5.2816 or higher


What's going on?
===
What does the mod add?
* There are 16 kinds of new ores, seperated in 4 categories each: Arcane, solide, ethere and ratio metals.
* You are just able to combine some of them as neigbours in a "circle": Arcane <> Solide <> Ethere <> Ratio <> Arcane - you gonna check JEI for Recipes!
* The hardness of the new tool depends on their parents. Not every alloy is hard enough, to mine the next alloy-level.
* At the moment I am up for ideas for better category-like traits!

How to start?
* Just start how you would usually start with Tinkers Construct. Go out, farm and mine until you find cobalt for high tier tools.
* From that point, you are able to mine harder materials and combine them to new alloys.

Hardness of each new ore in case you gonna ask...
* Low Level: Tiberium, Bismuth
* Cobalt (4): Prometheum, Eternite, Violium
* Titanite (5): Titanite, Rubium, Mythril, Mindorite
* Meteorite (6): Meteorite, Arcanite, Palladium, Karmesine
* Vibranium (7): Vibranium, Ignitite
* Adamantite (8): Adamantite
* It is up to you to find out which alloy you need to get to highest tier.

Balancing, more traits, more alloys, more ores:
* At the moment I have no idea how well balanced my mod is.
* I hope you give me a lot of good feedback, so I can balance it better!!!
* PLEASE send me requests for new traits, ores and alloy-ides. Especially ideas for a better system of my 4 categories!

Where to request or report issues:
* Github, CurseForge or via mail


More? Join our community on mumble (ofsg.eu) for questions or to have a nice chat with us!
 
#### License

This project is licensed under the conditions of the GNU GPL 3.0.

For developers
===============

This project uses the following technologies:
* Gradle 4.10.2
    * ForgeGradle 2.3 - fork by anatawa12
* JDK 8u212+

Steps required to launch the mod:
1. Run the `./gradlew` command in the project's root directory.
2. After that, prepare the project for launch using the `./gradlew setupDecompWorkspace` command. Also, run this command whenever you modify `build.gradle`.
3. After preparation, you can launch the game using the `./gradlew runClient` command.
4. After making changes to the code, you can run the build using the `./gradlew build` command.

__Notice__: It is best to make changes in PowerShell on Windows or in a bash terminal on Linux.