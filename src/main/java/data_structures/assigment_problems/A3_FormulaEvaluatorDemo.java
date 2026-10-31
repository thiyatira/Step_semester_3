package data_structures.assigment_problems;

// Demo runner for the quiz scoring formula evaluator.
public class A3_FormulaEvaluatorDemo {
    public static void main(String[] args) {
        FormulaEvaluator evaluator = new FormulaEvaluator();

        String[] formulas = {
            "2 * (3 + 4) - 10 / 5",
            "(8 - 2) * (1 + 2) / 4",
            "100 - 20 - 5",
            "2 + 3 * 4",
            "((7))"
        };
        for (String formula : formulas) {
            System.out.println(formula + " = " + evaluator.evaluate(formula));
        }

        try {
            evaluator.evaluate("5 / (3 - 3)");
        } catch (ArithmeticException e) {
            System.out.println("5 / (3 - 3) -> " + e.getMessage());
        }
    }
}
