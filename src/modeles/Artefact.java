package modeles;


import constantes.Type;

public class Artefact {
    private Type element;

    public Artefact(Type element){
        this.element = element;
    }

    public Type getElement() { return this.element; }
}