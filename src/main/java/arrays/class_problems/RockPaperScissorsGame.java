package arrays.class_problems;

import java.util.Random;

/**
 * Week 1 Practice - Problem 1: Rock-Paper-Scissors Game
 * Simulates a mini arcade match between player and computer.
 */
public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Random random = new Random(42); // fixed seed for reproducible demonstration
        int totalRounds = 5;
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            String pMove = playerMoves[i];
            String cMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(pMove, cMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %-2d | %-12s | %-14s | %-14s%n", (i + 1), pMove, cMove, result);
        }

        double winPct = ((double) wins / totalRounds) * 100.0;
        System.out.println("\nFinal Summary (after " + totalRounds + " rounds):");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPct);
    }
}
