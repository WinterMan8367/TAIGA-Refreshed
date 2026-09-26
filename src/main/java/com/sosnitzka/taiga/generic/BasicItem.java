package com.sosnitzka.taiga.generic;

import org.apache.commons.lang3.StringUtils;

import com.sosnitzka.taiga.CreativeTab;

import net.minecraft.item.Item;

// TODO: rename to BasicOreDictItem or different
/**
 * A "wrapper" for Item that makes construction and manipulation easier
 */
public class BasicItem extends Item {
    private final String name;
    private final String oreDictPrefix;

    public BasicItem(String name, String oreDictPrefix) {
        setUnlocalizedName(name + "_" + oreDictPrefix);
        setRegistryName(name + "_" + oreDictPrefix);
        setCreativeTab(CreativeTab.tabTaigaItem);
        this.name = name;
        this.oreDictPrefix = oreDictPrefix;
    }

    public boolean isOreDict() {
        return oreDictPrefix != null;
    }

    public String getOreDictPrefix() {
        return oreDictPrefix;
    }

    public String getOreDict() {
        return oreDictPrefix + StringUtils.capitalize(name.toLowerCase());
    }
}
