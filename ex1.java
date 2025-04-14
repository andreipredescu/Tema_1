public class ex1 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Eroare: prea putine argumente.");
            return;
        }
        try {
            Integer int1 = Integer.valueOf(args[0]);
            Integer int2 = Integer.valueOf(args[1]);
            Double real = Double.valueOf(args[2]);

            int a = int1.intValue();
            int b = int2.intValue();
            double c = real.doubleValue();

            double suma = a + b + c;

            double media;
            int count = 3;
            if (count != 0) {
                media = suma / count;
            } else {
                media = 0;
                System.out.println("Impartirea la 0 este imposibila");
            }
            double produs = a * b * c;
            System.out.printf("Suma: %.2f, Media: %.2f, Produsul: %.2f%n", suma, media, produs);
            switch (count) {
                case 3:
                    System.out.println("Au fost introduse 3 valori");
                    break;
                default:
                    System.out.println("Nu au fost introduse 3 valori");
            }
        } catch (NumberFormatException e) {
            System.out.println("Eroare: Toate argumentele trebuie să fie numere valide" + e.getMessage());
        }    }
}
