package zoo;

public class App {
    public static void main(String[] args) {
        try {
            Zoo zoo = new Zoo();
            zoo.setNbVisiteurMaxParSecteur(15);

            zoo.ajouterSecteur(TypeAnimal.CHIEN);
            zoo.ajouterSecteur(TypeAnimal.CHAT);

            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();

            Animal chien = new Chien("Rex", TypeAnimal.CHIEN);
            zoo.nouvelAnimal(chien);

            Animal chat = new Chat("Whiskers", TypeAnimal.CHAT);
            zoo.nouvelAnimal(chat);

            System.out.println("Nombre d'animaux dans le zoo : " + zoo.nombreAnimaux());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}