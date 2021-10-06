package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.image.BufferedImage;

@AllArgsConstructor
public class BlogSchema {
    @Getter
    private String schema_name;
    @Getter
    private String category;
    @Getter
    private String color;
    @Getter
    private BufferedImage backgroundImage;

}
