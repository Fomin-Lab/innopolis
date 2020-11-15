package ru.innopolis.university.fomin.examples.gof.structural.proxy.example1;

public class ProxyImage implements Image {

    private RealImage image = null;
    private String filename = null;

    /**
     * Constructor
     *
     * @param filename Image filename
     */
    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    /**
     * Displays the image
     */
    @Override
    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }
}
