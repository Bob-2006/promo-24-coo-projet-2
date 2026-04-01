package duckcorp.stock;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Stock générique de canards.
 *
 * @param <T> type de canard stocké (doit étendre Duck)
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class Stock<T extends Duck> {

    private final List<T> items = new ArrayList<>();

    // --- Méthodes fournies ---

    /** Ajoute un canard au stock. */
    public void add(T duck) {
        items.add(duck);
    }

    /** Retourne une vue non modifiable de tous les canards en stock. */
    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }

    /** Retourne le nombre total de canards en stock. */
    public int total() {
        return items.size();
    }

    // --- TODO ---

    /**
     * Retire exactement {@code count} canards du type {@code type} du stock
     * et les retourne dans une liste.
     *
     * @param type  le type de canard à retirer
     * @param count le nombre à retirer
     * @return la liste des canards retirés
     * @throws IllegalStateException si le stock ne contient pas assez de canards du type demandé
     *
     * Conseil : parcourez items en une seule passe.
     * Attention à la signature de retour : elle doit conserver le type générique T.
     */
    public List<T> remove(DuckType type, int count) {
        if (count < 0) throw new IllegalArgumentException("Le nombre à retirer ne peut pas être négatif.");
        if (count == 0) return new ArrayList<>();

        List<T> removedDucks = new ArrayList<>();
        Iterator<T> iterator = items.iterator();

        while (iterator.hasNext() && removedDucks.size() < count) {
            T duck = iterator.next();
            if (duck.getType() == type) {
                removedDucks.add(duck);
                iterator.remove();
            }
        }

        // Si on n'a pas trouvé assez de canards, on annule (rollback) et on lève l'exception
        if (removedDucks.size() < count) {
            items.addAll(removedDucks);
            throw new IllegalStateException(
                String.format("Stock insuffisant. Demandé: %d, Disponible: %d pour le type %s", count, removedDucks.size(), type)
            );
        }

        return removedDucks;
    }

    /**
     * Retourne le nombre de canards du type {@code type} présents dans le stock.
     *
     * @param type le type à compter
     */
    public int count(DuckType type) {
        int count = 0;
        for (T duck : items) {
            if (duck.getType() == type) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne le nombre de canards défectueux dans le stock.
     * Un canard est défectueux si isDefective() retourne true.
     *
     * Conseil : appelez isDefective() plutôt que de comparer le score manuellement.
     */
    public int countDefective() {
        int count = 0;
        for (T duck : items) {
            if (duck.isDefective()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retourne une Map associant chaque DuckType au nombre de canards
     * de ce type présents dans le stock.
     *
     * Conseil : construisez la map en une seule passe sur items.
     * Tous les types doivent apparaître dans la map (avec 0 si absent).
     */
    public Map<DuckType, Integer> countByType() {
        Map<DuckType, Integer> map = new EnumMap<>(DuckType.class);
        
        // Initialisation de tous les types à 0
        for (DuckType type : DuckType.values()) {
            map.put(type, 0);
        }

        // Une seule passe pour compter
        for (T duck : items) {
            map.put(duck.getType(), map.get(duck.getType()) + 1);
        }

        return map;
    }
}