package pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class Airline {
    private String id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;

}
