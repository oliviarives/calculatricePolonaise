package Stack_Package;

import java.util.EmptyStackException;

public interface Stack {
    /**
     * Teste si cette pile est vide
     */
    public boolean isEmpty(); /**
     * Renvoie le nombre d'éléments dans cette pile.
     */
    public int getSize(); /**
     */
    public void push(double item); /**
     * Regarde l'objet en haut de cette pile sans le retirer de la pile.
     */
    public double peek() throws EmptyStackException; /**
     * Supprime l'objet en haut de cette pile et renvoie * cet objet comme valeur de cette fonction.
     * @throws EmptyStackException si cette pile est vide.
     */
    public double pop() throws EmptyStackException;
}
