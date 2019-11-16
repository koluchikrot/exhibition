package pushkinMuseum.model;

public class AncientPiece extends Exhibit {
    private String period;
    private String location;

    public AncientPiece(String name, String exhibitionHall, String description, boolean originality, String imagePath, String period, String location) {
        super(name, exhibitionHall, description, originality, imagePath);
        this.period = period;
        this.location = location;
    }
}
