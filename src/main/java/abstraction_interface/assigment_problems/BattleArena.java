package abstraction_interface.assigment_problems;

// Combat coordinator resolving defenses polymorphically across Defendable entities.
public class BattleArena {
    public static void resolveDefense(Defendable[] combatants) {
        if (combatants == null) return;
        for (Defendable c : combatants) {
            if (c != null) {
                System.out.println(c.defend());
            }
        }
    }
}
