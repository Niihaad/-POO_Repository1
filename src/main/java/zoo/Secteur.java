package zoo;
import java.util.ArrayList;
import java.util.List;

public class Secteur {
    private TypeAnimal typeAnimauxDansSecteur;
    private List<Animal> animauxDansSecteur;

    public Secteur(TypeAnimal typeAnimal) {
        this.typeAnimauxDansSecteur = typeAnimal;
        this.animauxDansSecteur = new ArrayList<>();
    }

    public void ajouterAnimal(Animal animal) throws AnimalInWrongSectorException {
        if (animal.getTypeAnimal() != typeAnimauxDansSecteur) {
            throw new AnimalInWrongSectorException("Animal dans le mauvais secteur !");
        }
        animauxDansSecteur.add(animal);
    }

    public int getNombreAnimaux() {
        return animauxDansSecteur.size();
    }

    public TypeAnimal obtenirType() {
        return typeAnimauxDansSecteur;
    }
}