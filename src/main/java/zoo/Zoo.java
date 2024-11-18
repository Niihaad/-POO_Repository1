package zoo;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private int visiteurs;
    private List<Secteur> secteursAnimaux;
    private int nbVisiteurMaxParSecteur;

    public Zoo() {
        this.visiteurs = 0;
        this.secteursAnimaux = new ArrayList<>();
    }

    public void ajouterSecteur(TypeAnimal typeAnimal) {
        secteursAnimaux.add(new Secteur(typeAnimal));
    }

    public void setNbVisiteurMaxParSecteur(int nbVisiteurMaxParSecteur) {
        this.nbVisiteurMaxParSecteur = nbVisiteurMaxParSecteur;
    }

    public void nouveauVisiteur() throws LimiteVisiteurException {
        if (visiteurs >= nbVisiteurMaxParSecteur * secteursAnimaux.size()) {
            throw new LimiteVisiteurException("Nombre maximum de visiteurs dépassé !");
        }
        visiteurs++;
    }

    public int getLimiteVisiteur() {
        return nbVisiteurMaxParSecteur * secteursAnimaux.size();
    }

    public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        for (Secteur secteur : secteursAnimaux) {
            if (secteur.obtenirType() == animal.getTypeAnimal()) {
                secteur.ajouterAnimal(animal);
                return;
            }
        }
        throw new AnimalDansMauvaisSecteurException("L'animal est dans le mauvais secteur !");
    }

    public int nombreAnimaux() {
        return secteursAnimaux.stream().mapToInt(Secteur::getNombreAnimaux).sum();
    }
}