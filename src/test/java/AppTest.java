
import org.junit.Test;
import zoo.*;

import static org.junit.Assert.*;

public class AppTest {

    @Test(expected = LimitVisitorException.class)
    public void testDepassementLimiteVisiteurs() throws LimitVisitorException {
        // Création du zoo
        Zoo zoo = new Zoo();
        zoo.setNbVisiteurMaxParSecteur(15); // Limite de 15 visiteurs

        // Ajout de 16 visiteurs (1 de plus que la limite pour avoir le prblm de 1 vis plus)
        for (int i = 0; i < 16; i++) {
            zoo.nouveauVisiteur();
        }
    }
        @Test
        public void testAjoutChienDansSecteur() throws AnimalInWrongSectorException {
            // Création d'un secteur pour les chiens
            Secteur secteurChien = new Secteur(TypeAnimal.CHIEN);

            // Création d'un chien
            Animal chien = new Chien("Buddy", TypeAnimal.CHIEN);

            // Ajout du chien dans le secteur
            secteurChien.ajouterAnimal(chien);

            // Vérification que le chien a bien été ajouté au secteur des chiens
            assertEquals(1, secteurChien.getNombreAnimaux());
            assertEquals(TypeAnimal.CHIEN, secteurChien.obtenirType());
        }

}