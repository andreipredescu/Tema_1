class Carte implements Cloneable {
    private String titlu;
    private String autor;
    private int anAparitie;

    public Carte(String titlu, String autor, int anAparitie) {
        this.titlu = titlu;
        this.autor = autor;
        this.anAparitie = anAparitie;
    }
    public Carte(Carte altaCarte) {
        this.titlu = altaCarte.titlu;
        this.autor = altaCarte.autor;
        this.anAparitie = altaCarte.anAparitie;
    }

    public void afiseazaDetalii() {
        System.out.println("Titlu: " + titlu + ", Autor: " + autor + ", An: " + anAparitie);
    }
    public void afiseazaDetalii(boolean doarTitluAutor) {
        if (doarTitluAutor) {
            System.out.println("Titlu: " + titlu + ", Autor: " + autor);
        } else {
            afiseazaDetalii();
        }
    }

    @Override
    public String toString() {
        return "Carte{titlu='" + titlu + "', autor='" + autor + "', anAparitie=" + anAparitie + "}";
    }

    public Carte copieSuperficiala() throws CloneNotSupportedException {
        return (Carte) this.clone();
    }

    public Carte copieProfunda() {
        return new Carte(new String(this.titlu), new String(this.autor), this.anAparitie);
    }
}

public class ex5 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Carte carte1 = new Carte("1984", "George", 1949);
        carte1.afiseazaDetalii();
        carte1.afiseazaDetalii(true);
        System.out.println(carte1);

        Carte copieShallow = carte1.copieSuperficiala();
        System.out.println("Shallow copy: " + copieShallow);

        Carte copieDeep = carte1.copieProfunda();
        System.out.println("Deep copy: " + copieDeep);

        // Verificăm dacă obiectele sunt diferite
        System.out.println(carte1 == copieShallow); // false
        System.out.println(carte1 == copieDeep);    // false

        // Deși sunt obiecte diferite referințele interne (titlu, autor) sunt la fel la shallow copy
        // Dar fiindcă String este imutabil, nu se pot modifica din alt obiect
        // Așadar, deep copy și shallow copy sunt la fel în acest caz
    }
}
