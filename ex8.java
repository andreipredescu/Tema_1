import java.util.Arrays;
import java.util.Objects;

class Student implements Comparable<Student> {
    private final String nume;
    private final int varsta;
    private final double medie;

    public Student(String nume, int varsta, double medie) {
        this.nume = nume;
        this.varsta = varsta;
        this.medie = medie;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public double getMedie() {
        return medie;
    }

    @Override
    public int compareTo(Student altStudent) {
        return Double.compare(altStudent.medie, this.medie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return varsta == student.varsta &&
                Double.compare(student.medie, medie) == 0 &&
                Objects.equals(nume, student.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, varsta, medie);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", medie=" + medie +
                '}';
    }
}
class Grup<T extends Student> {
    private T[] studenti;
    private int count;

    @SuppressWarnings("unchecked")
    public Grup(int dimensiuneMaxima) {
        studenti = (T[]) new Student[dimensiuneMaxima];
        count = 0;
    }

    public void adaugaStudent(T student) {
        if (count < studenti.length) {
            studenti[count++] = student;
        } else {
            System.out.println("Grupul este plin.");
        }
    }

    public T cautaDupaNume(String nume) {
        for (int i = 0; i < count; i++) {
            if (studenti[i].getNume().equalsIgnoreCase(nume)) {
                return studenti[i];
            }
        }
        return null;
    }

    public void sorteazaStudenti() {
        Arrays.sort(studenti, 0, count);
    }

    public T[] getStudenti() {
        return Arrays.copyOf(studenti, count);
    }
}
public class ex8 {
    public static void main(String[] args) {
        Grup<Student> grup = new Grup<>(10);
        grup.adaugaStudent(new Student("Ana", 20, 9.5));
        grup.adaugaStudent(new Student("Bogdan", 22, 8.7));
        grup.adaugaStudent(new Student("Vasile", 21, 9.9));

        Student st = grup.cautaDupaNume("Bogdan");
        System.out.println("Căutat: " + st);

        grup.sorteazaStudenti();
        System.out.println("\nStudenți sortați după medie:");

        for (Student s : grup.getStudenti()) {
            System.out.println(s);
        }

        StringBuilder raportBuilder = new StringBuilder();
        raportBuilder.append("\n--- Raport Studenți (StringBuilder) ---\n");
        for (Student s : grup.getStudenti()) {
            raportBuilder.append(s.toString()).append("\n");
        }
        System.out.println(raportBuilder);

        StringBuffer raportBuffer = new StringBuffer();
        raportBuffer.append("\n--- Raport Studenți (StringBuffer) ---\n");
        for (Student s : grup.getStudenti()) {
            raportBuffer.append(s.toString()).append("\n");
        }
        System.out.println(raportBuffer);

        String raportString = "\n--- Raport Studenți (String) ---\n";
        for (Student s : grup.getStudenti()) {
            raportString += s.toString() + "\n";
        }
        System.out.println(raportString);
    }
}
