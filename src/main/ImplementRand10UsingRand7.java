package main;

import java.util.Random;

public class ImplementRand10UsingRand7 {
    private Random r;

    public ImplementRand10UsingRand7() {
        r = new Random();
    }

    public ImplementRand10UsingRand7(int seed) {
        r = new Random(seed);
    }

    public int rand7() {
        return r.nextInt(7) + 1;
    }

    public int rand10() {
        int re = 0;

        while (true) {
            int a = rand7();
            int b = rand7();
            re = a + (b - 1) * 7;

            if (re <= 40) return (re - 1) % 10 + 1;

            re -= 40; // re = rand9()
            a = rand7();
            re = a + (re - 1) * 7;

            if (re <= 60) return (re - 1) % 10 + 1;

            re -= 60; // re = rand3()
            a = rand7();
            re = a + (re - 1) * 7;

            if (re <= 20) return (re - 1) % 10 + 1;
        }
    }
}
