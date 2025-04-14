class Profesor {
    private String nume;
    private String specializare;
    private final String codIdentificare;

    public Profesor(String nume, String specializare, String codIdentificare) {
        this.nume = nume;
        this.specializare = specializare;
        this.codIdentificare = codIdentificare;
    }
    public String getNume() {
        return nume;
    }
    public String getSpecializare() {
        return specializare;
    }
    public String getCodIdentificare() {
        return codIdentificare;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
}
class Curs {
    private Profesor profesor;
    private String[] studenti;

    public Curs(Profesor profesor, String[] studenti) {
        this.profesor = profesor;
        this.studenti = studenti;
    }
    public void afiseazaCurs() {
        System.out.println("Nume: " + profesor.getNume() + ", specializare: " + profesor.getSpecializare());
        System.out.println("Cod: " + profesor.getCodIdentificare());

        System.out.println("Studenti:");
        for (String student : studenti) {
            System.out.println(student);
        }
    }
    public void actualizeazaSpecializareProfesor(String nouaSpecializare) {
        profesor.setSpecializare(nouaSpecializare);
    }
}
public class ex6 {
    public static void main(String[] args) {
        String[] listaStudenti = {"Ana", "Ion", "Maria"};

        Profesor prof = new Profesor("Popescu", "Matematica", "123");

        Curs curs = new Curs(prof, listaStudenti);
        curs.afiseazaCurs();
        curs.actualizeazaSpecializareProfesor("Informatica");
        curs.afiseazaCurs();
    }
}
