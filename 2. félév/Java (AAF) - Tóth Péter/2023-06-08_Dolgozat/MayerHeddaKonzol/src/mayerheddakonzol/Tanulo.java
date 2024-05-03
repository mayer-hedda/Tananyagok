package mayerheddakonzol;

public class Tanulo {

    private String vezeteknev;
    private String keresztnev;
    private String targy;
    private Integer jegy;
    private String tema;
    

    public Tanulo(String sor) {
        String[] splitted = sor.split(";");
        
        this.vezeteknev = splitted[0];
        this.keresztnev = splitted[1];
        this.targy = splitted[2];
        this.jegy = Integer.parseInt(splitted[3]);
        this.tema = splitted[4];
    }
    

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getTargy() {
        return targy;
    }

    public void setTargy(String targy) {
        this.targy = targy;
    }

    public Integer getJegy() {
        return jegy;
    }

    public void setJegy(Integer jegy) {
        this.jegy = jegy;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

}
