package misc;

import java.util.ArrayList;
import java.util.Collections;

/*
 The city of Hackerland organized a chess tournament for its citizens.
There are n participants numbered 1 to n where the ith participant has potential denoted by potential[i]. The potential of each player is distinct.
Initially, all players stand in a queue in order from the 1st to the nth player In each game, the first 2 participants of the queue compete and the participant with a higher potential wins the game. After each game, the winner remains at the beginning of the queue and plays with the next person from the queue and the losing player goes to the end of the queue.
The game continues until a player wins k consecutive games.
Given the potential of the participants and the deciding factor k, find the potential of the winning player.
Example
Consider n = 4 participants
have potential = [3, 2, 1, 4], and k = 2.

 */



public class ChessTournament {
    public static int getPotentialOfWinner(ArrayList<Integer> potential, int k) {
        int currentWinnerIndex = 0;
        int winStreak = 0;

        for (int i = 1; i < potential.size(); i++) {
            if (potential.get(currentWinnerIndex) > potential.get(i)) {
                winStreak++;
                if (winStreak == k) return potential.get(currentWinnerIndex);
            } else {
                currentWinnerIndex = i;
                winStreak = 1; // reset win streak for the new winner
            }
        }

        // If the loop ends without returning, the first player wins by default
        return potential.get(currentWinnerIndex);
    }

    public static void main(String[] args) {
        ArrayList<Integer> potential = new ArrayList<>();
        potential.add(3);
        potential.add(2);
        potential.add(1);
        potential.add(4);
        int k = 2;
        System.out.println("The potential of the winning player is: " + getPotentialOfWinner(potential, k));
    }
}