package br.com.cod3r.composite.folders.model;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {

    private String name;
    private List<Component> children = new ArrayList<>();

    public Folder(String name, List<Component> children) {
        this.name = name;
        this.children.addAll(children);
    }

    @Override
    public void add(Component item) {
        if (item.equals(this)) {
            System.out.println("\nThis operation is not supported because a folder cannot add itself\n");
        } else {
            children.add(item);
        }
    }

    @Override
    public void delete(Component item) {
        if (item.equals(this)) {
            System.out.println("\nThis operation is not supported because a folder cannot remove itself\n");
        } else if (contains(item)) {
            children.remove(item);
        } else {
            children.stream()//
                    .filter(child -> child.contains(item)) //
                    .findFirst() //
                    .ifPresent(child -> child.delete(item));
        }
    }

    @Override
    public void print(String structure) {
        System.out.println(structure + name);
        for (Component child : children) {
            child.print(structure + "| ");
        }
    }

    @Override
    public boolean contains(Component component) {
        return children.contains(component);
    }
}
