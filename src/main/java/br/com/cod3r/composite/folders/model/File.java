package br.com.cod3r.composite.folders.model;

public class File implements Component {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        System.out.println("\nThis operation is not supported because a file cannot add itself or other file\n");
    }

    @Override
    public void delete(Component component) {
        System.out.println("\nThis operation is not supported because a file cannot remove itself or other file\n");
    }

    @Override
    public void print(String structure) {
        System.out.println(structure + name);
    }

    @Override
    public boolean contains(Component component) {
        return false;
    }
}
