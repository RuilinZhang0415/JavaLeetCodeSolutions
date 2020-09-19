package main;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int count[] = new int[10], len = secret.length(), bull = 0, cow = 0;

        for(int i = 0; i < len; i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bull++;
            } else {
                if (count[s] < 0) cow++;
                if (count[g] > 0) cow++;
                count[s]++;
                count[g]--;
            }
        }

        return bull + "A" + cow + "B";
    }
}
