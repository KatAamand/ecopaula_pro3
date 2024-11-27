package dto;

public class OriginDTO {
    private int id;
    private String name_of_farm;

    public OriginDTO() {}

    public OriginDTO(int id, String name_of_farm) {
        this.id = id;
        this.name_of_farm = name_of_farm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_of_farm() {
        return name_of_farm;
    }

    public void setName_of_farm(String name_of_farm) {
        this.name_of_farm = name_of_farm;
    }
}
