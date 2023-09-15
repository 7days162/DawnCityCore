package kr.mdcdev.dawncitycore.util.minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public final class ItemCreator {
    private final Material material;
    private int amount = 1;
    private short dur = 0;
    private byte data = 0;
    private String name;
    private boolean hideFlag = false;
    private boolean hideDur = false;
    private final List<String> lore = new ArrayList<>();

    private ItemCreator(Material material) {
        this.material = material;
    }

    public static ItemCreator of(Material material) {
        return new ItemCreator(material);
    }

    public ItemCreator data(byte b) {
        this.data = b;
        return this;
    }

    public ItemCreator amount(int i) {
        this.amount = i;
        return this;
    }

    public ItemCreator name(String name) {
        this.name = name;
        return this;
    }

    public ItemCreator lore() {
        this.lore.add("");
        return this;
    }

    public ItemCreator lore(String... lore) {
        this.lore.addAll(Arrays.asList(lore));
        return this;
    }

    public ItemCreator lore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemCreator durability(short value) {
        this.dur = value;
        return this;
    }

    public ItemCreator hideFlag() {
        this.hideFlag = true;
        return this;
    }

    public ItemCreator hideDurability() {
        this.hideDur = true;
        return this;
    }


    public ItemStack create() {
        ItemStack item = new ItemStack(material, 1, (byte) 0, data);
        item.setAmount(amount);
        if(dur > 0) item.setDurability(dur);

        ItemMeta meta = item.getItemMeta();

        if(hideFlag) meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        if(hideDur) {
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        }
        if(name != null) meta.setDisplayName(name);
        if(lore.size() > 0) meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}