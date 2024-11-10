public class ParickiZadaca {

    // Define coin denominations
    public int minBrojParicki(int cena) {
        int p1, p2, p3, p4, p5;
        int min = Integer.MAX_VALUE;
        int pom, broj = -1; // Initialize 'broj' here to avoid any issues

        for (p1 = 0; p1 <= (cena / 50); p1++) {
            for (p2 = 0; p2 <= (cena / 20); p2++) {
                for (p3 = 0; p3 <= (cena / 10); p3++) {
                    for (p4 = 0; p4 <= (cena / 2); p4++) {
                        for (p5 = 0; p5 <= cena; p5++) {
                            pom = p1 * 50 + p2 * 20 + p3 * 10 + p4 * 2 + p5;
                            if (pom == cena) {
                                broj = p1 + p2 + p3 + p4 + p5;
                                min = Math.min(min, broj);
                            }
                        }
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min; // Return -1 if no solution is found
    }

    public static void main(String[] args) {
        ParickiZadaca parickiZadaca = new ParickiZadaca();
        System.out.println(parickiZadaca.minBrojParicki(1000));
    }
}
