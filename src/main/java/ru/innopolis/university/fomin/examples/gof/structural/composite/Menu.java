package ru.innopolis.university.fomin.examples.gof.structural.composite;

public class Menu extends MenuComponent {
    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public MenuComponent add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
        return menuComponent;
    }

    public MenuComponent remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
        return menuComponent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(print(this));
        for (MenuComponent menuComponent : menuComponents) {
            builder.append("(")
                    .append(this.name)
                    .append(") ")
                    .append(menuComponent.toString());
        }
        return builder.toString();
    }
}
