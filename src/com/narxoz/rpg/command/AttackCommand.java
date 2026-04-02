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
        damageDealt = Math.min(attacker.getAttackPower(), opponent.getHealth());
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
