package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.*;

public class AttackCommand implements ActionCommand {
    private ArenaFighter attacker;
    private ArenaOpponent opponent;
    private int damageDealt;

    public AttackCommand(ArenaFighter attacker, ArenaOpponent opponent) {
        this.attacker = attacker;
        this.opponent = opponent;
    }

    @Override
    public void execute() {
        damageDealt = Math.min(attacker.getAttackPower(), opponent.getHp());
        opponent.takeDamage(damageDealt);
    }

    @Override
    public void undo() {
        opponent.heal(damageDealt);
    }

    @Override
    public String getDescription() {
        return "Attack";
    }
}
