package abstraction_interface.assigment_problems;

// Demonstration of GameCharacter abstract hierarchy, Attackable overloading, and Defendable polymorphic resolution.
public class A4_ArenaBattleDemo {
    public static void main(String[] args) {
        Warrior w = new Warrior("Kael");
        System.out.println(w.attack());
        System.out.println(w.attack("Iron Sword"));
        System.out.println(w.defend());
        System.out.println(w.getSpecialMove());

        Trap t = new Trap("Spike Pit");
        System.out.println(t.defend());

        // Polymorphic defense resolution across Defendable array
        Defendable[] combatants = {w, t};
        BattleArena.resolveDefense(combatants);
    }
}
