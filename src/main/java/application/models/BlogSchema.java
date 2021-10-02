package application.models;

import java.awt.image.BufferedImage;

public class BlogSchema {
    private String schema_name;
    private String category;
    private String color;
    private BufferedImage backgroundImage;

    public BlogSchema(String schema_name, String category, String color, BufferedImage backgroundImage) {
        this.schema_name = schema_name;
        this.category = category;
        this.color = color;
        this.backgroundImage = backgroundImage;
    }

    public String getSchema_name() {
        return schema_name;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }
}
