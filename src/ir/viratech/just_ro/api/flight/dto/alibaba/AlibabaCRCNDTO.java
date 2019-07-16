package ir.viratech.just_ro.api.flight.dto.alibaba;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({"SpellCheckingInspection"})
public class AlibabaCRCNDTO {

    private String airlineCode;
    private Integer p1;
    private Integer p2;
    private Integer p3;
    private Integer p4;
    private Integer p5;
    private String ps1;
    private String ps2;
    private String ps3;
    private String ps4;
    private String ps5;

    @JsonProperty("AirlineCode")
    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @JsonProperty("P1")
    public Integer getP1() {
        return p1;
    }

    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    @JsonProperty("P2")
    public Integer getP2() {
        return p2;
    }

    public void setP2(Integer p2) {
        this.p2 = p2;
    }

    @JsonProperty("P3")
    public Integer getP3() {
        return p3;
    }

    public void setP3(Integer p3) {
        this.p3 = p3;
    }

    @JsonProperty("P4")
    public Integer getP4() {
        return p4;
    }

    public void setP4(Integer p4) {
        this.p4 = p4;
    }

    @JsonProperty("P5")
    public Integer getP5() {
        return p5;
    }

    public void setP5(Integer p5) {
        this.p5 = p5;
    }

    @JsonProperty("PS1")
    public String getPs1() {
        return ps1;
    }

    public void setPs1(String ps1) {
        this.ps1 = ps1;
    }

    @JsonProperty("PS2")
    public String getPs2() {
        return ps2;
    }

    public void setPs2(String ps2) {
        this.ps2 = ps2;
    }

    @JsonProperty("PS3")
    public String getPs3() {
        return ps3;
    }

    public void setPs3(String ps3) {
        this.ps3 = ps3;
    }

    @JsonProperty("PS4")
    public String getPs4() {
        return ps4;
    }

    public void setPs4(String ps4) {
        this.ps4 = ps4;
    }

    @JsonProperty("PS5")
    public String getPs5() {
        return ps5;
    }

    public void setPs5(String ps5) {
        this.ps5 = ps5;
    }
}
