package robotharc;

import java.util.Random;

public class Robot {
    
    // ----- TUAJDONSÁGOK -----
    private String nev;
    private String szin;
    private Integer maxEletero;
    private Integer eletero;
    private Boolean harcosE;
    private Integer sebzes;
    
    
    // ----- KONSTRUKTOR -----
    public Robot(String nev, String szin, Integer maxEletero, Boolean harcosE, Integer sebzes) {
        this.nev = nev;
        this.szin = szin;
        this.maxEletero = maxEletero;
        this.eletero = maxEletero;
        this.harcosE = harcosE;
        this.sebzes = sebzes;
    }
    
    
    // ----- GETTEREK -----
    public String getNev() {
        return nev;
    }
    
    public String getSzin() {
        return szin;
    }

    public Integer getEletero() {
        return eletero;
    }

    public Boolean getHarcosE() {
        return harcosE;
    }

    public Integer getSebzes() {
        return sebzes;
    }
    
    
    // ----- SETTEREK -----
    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public void setEletero(Integer eletero) {
        if(eletero > 0) {
            this.eletero = eletero;
        }
    }
    
    
    // ----- METÓDUSOK -----
    public static Robot harc(Robot egyik, Robot masik) {
        if(Robot.harcosok(egyik, masik)) {
            Robot kezdo = Robot.kezdorobot(egyik, masik);
            Robot masodik;
            if(kezdo != egyik) {
                masodik = egyik;
            } else {
                masodik = masik;
            }
            
            int korokSzama = 1;
            while (egyik.eletero > 0 || masik.eletero > 0) {
                Robot tamado;
                Robot szenvedo;
                if(korokSzama % 2 != 0) {
                    tamado = Robot.kezdorobot(egyik, masik);
                    szenvedo = masodik;
                } else {
                    tamado = masodik;
                    szenvedo = kezdo;
                }
                
                
                Integer sebzes = tamado.sebzes();
                tamado.tamadas(szenvedo, sebzes);
                
                if(szenvedo.eletero <= 0) {
                    System.out.println("\nGyőztes robot adatai: \n\tneve: " + tamado.nev + "\n\tszine: " + tamado.szin + "\n\téletereje: " + tamado.eletero + "\n\tharcos-e: " + tamado.harcosE + "\n\tsebzés: " + tamado.sebzes + "\n");
                    return tamado;
                }
                
                korokSzama++;
            }
        }
        
        return null;
    }
    
    public static Boolean harcosok(Robot egyik, Robot masik) {
        if(egyik.harcosE && masik.harcosE) {
            return true;
        }
        return false;
    }
    
    public static Robot kezdorobot(Robot egyik, Robot masik) {
        if(egyik.eletero != masik.eletero) {
            if(egyik.eletero < masik.eletero) {
                return egyik;
            } else {
                return masik;
            }
        } else {
            if(egyik.sebzes != masik.sebzes) {
                if(egyik.sebzes > masik.sebzes) {
                    return egyik;
                } else {
                    return masik;
                }
            } else {
                Random rand = new Random();
                Integer jatekos = rand.nextInt(2);
                
                if(jatekos == 0) {
                    return egyik;
                } else {
                    return masik;
                }
            }
        }
    }
    
    public Integer sebzes() {
        Random rand = new Random();
        return rand.nextInt(0, this.sebzes + 1);
    }
    
    public void tamadas(Robot szenvedo, Integer sebzes) {
        szenvedo.eletero = szenvedo.eletero - sebzes;
        System.out.println(this.nev + " megtámadta " + szenvedo.nev + "-t, " + sebzes + " sebzést okozott, ezzel " + szenvedo.nev + " életereje " + szenvedo.eletero + " lett.");
        if(sebzes == this.sebzes) {
            this.gyogyulas();
            System.out.println("Mivel " + this.nev + " a maximális sebzését okozta, " + this.nev + " élete " + this.eletero + " pontra nőtt.");
        }
    }
    
    public void gyogyulas() {
        if(this.eletero <= this.maxEletero - 2) {
            this.eletero = this.eletero + 2;
        } else {
            this.eletero = this.maxEletero;
        }
    }
    
    public static void robotbajnoksag(Robot r1, Robot r2, Robot r3, Robot r4, Robot r5, Robot r6, Robot r7, Robot r8) {
        Robot elso = Robot.harc(r1, r2);
        Robot masodik = Robot.harc(r3, r4);
        Robot harmadik = Robot.harc(r5, r6);
        Robot negyedik = Robot.harc(r7, r8);
        
        elso.eletero = elso.eletero + 5;
        masodik.eletero = masodik.eletero + 5;
        harmadik.eletero = harmadik.eletero + 5;
        negyedik.eletero = negyedik.eletero + 5;
        
        
        Robot otodik = Robot.harc(elso, masodik);
        Robot hatodik = Robot.harc(harmadik, negyedik);
        
        otodik.eletero = otodik.eletero + 5;
        hatodik.eletero = hatodik.eletero + 5;
        
        
        Robot gyoztes = Robot.harc(otodik, hatodik);
        
        System.out.println("A robotbajnokság győztese:\n\tneve: " + gyoztes.nev + "\n\tszine: " + gyoztes.szin + "\n\téletereje: " + gyoztes.eletero + "\n\tharcos-e: " + gyoztes.harcosE + "\n\tsebzés: " + gyoztes.sebzes);
    }
    
}
