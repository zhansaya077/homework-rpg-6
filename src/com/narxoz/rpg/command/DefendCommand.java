package com.narxoz.rpg.command;
public class DefendCommand implements ActionCommand {
    private ArenaFighter fighter;
    private double boost;

    public DefendCommand(ArenaFighter fighter, double boost) {
        this.fighter = fighter;
        this.boost = boost;
    }

    @Override
    public void execute() {
        fighter.modifyDodgeChance(boost);
    }

    @Override
    public void undo() {
        fighter.modifyDodgeChance(-boost);
    }

    @Override
    public String getDescription() {
        return "Defend";
    }
}
