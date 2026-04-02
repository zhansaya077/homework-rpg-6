package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    private int armorValue;

    public ArmorHandler(int armorValue) {
        this.armorValue = armorValue;
    }

    @Override
    public void handle(int damage, ArenaFighter target) {
        int reduced = Math.max(0, damage - armorValue);
        passToNext(reduced, target);
    }
}
