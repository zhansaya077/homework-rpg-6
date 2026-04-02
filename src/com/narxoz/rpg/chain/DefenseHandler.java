package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public abstract class DefenseHandler {
    protected DefenseHandler next;

    public DefenseHandler setNext(DefenseHandler next) {
        this.next = next;
        return next;
    }

    protected void passToNext(int damage, ArenaFighter target) {
        if (next != null) {
            next.handle(damage, target);
        }
    }

    public abstract void handle(int damage, ArenaFighter target);
}
