class Animal {
    public void sunet() {
        System.out.println("Animalul scoate un sunet");
    }
}

class Mamifer extends Animal {
}

class Caine extends Mamifer {
    @Override
    public void sunet() {
        System.out.println("Cainele latra");
    }

    public void latra() {
        System.out.println("HAM HAM!");
    }
}

class Pisica extends Mamifer {
    @Override
    public void sunet() {
        System.out.println("Pisica miaună.");
    }

    public void miauna() {
        System.out.println("Miau");
    }
}

public class ex7 {
    public static void main(String[] args) {
        Animal a1 = new Caine();
        Animal a2 = new Pisica();

        Animal[] animale = { a1, a2, new Caine(), new Pisica() };

        for (Animal animal : animale) {
            animal.sunet();

            if (animal instanceof Caine) {
                Caine c = (Caine) animal;
                c.latra();
            } else if (animal instanceof Pisica) {
                Pisica p = (Pisica) animal;
                p.miauna();
            }

            System.out.println();
        }
    }
}
