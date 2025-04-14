import java.util.*;

abstract class Vehicul {
    protected String marca;
    protected String model;
    protected int anFabricatie;

    public Vehicul(String marca, String model, int anFabricatie) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
    }

    public abstract String descriere();
}

class Masina extends Vehicul {
    private String transmisie;

    public Masina(String marca, String model, int anFabricatie, String transmisie) {
        super(marca, model, anFabricatie);
        this.transmisie = transmisie;
    }

    @Override
    public String descriere() {
        return "Masina: " + marca + " " + model + ", an: " + anFabricatie + ", transmisie: " + transmisie;
    }
}
class Motocicleta extends Vehicul {
    private String clasaPutere;

    public Motocicleta(String marca, String model, int anFabricatie, String clasaPutere) {
        super(marca, model, anFabricatie);
        this.clasaPutere = clasaPutere;
    }

    @Override
    public String descriere() {
        return "Motocicleta: " + marca + " " + model + ", an: " + anFabricatie + ", clasa putere: " + clasaPutere;
    }
}

public class ex3 {
    public static void main(String[] args) {
        List<Vehicul> vehicule = new ArrayList<>();

        vehicule.add(new Masina("BMW", "Serie 3", 2020, "Automata"));
        vehicule.add(new Motocicleta("Yamaha", "R6", 2018, "Sport"));
        vehicule.add(new Masina("Dacia", "Logan", 2022, "Manuala"));

        for (Vehicul v : vehicule) {
            System.out.println(v.descriere());
        }
    }
}
