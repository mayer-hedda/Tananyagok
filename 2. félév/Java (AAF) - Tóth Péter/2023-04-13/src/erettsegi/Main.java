package erettsegi;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Versenyzo> versenyzok = Main.beolvas();
//        System.out.println(versenyzok);
        
        
        // 4. feladat
        Integer countV = versenyzok.size();
        double arany = 1- ((double) countV / 691);
        System.out.println("4. feladat: A versenytávot nem teljesítők: " + (arany * 100) + "%");
        
        
        // 5. feladat
        Main.feladat5(versenyzok);
        
        
        // 6. feladat
        Main.feladat6(versenyzok);
        
        
        // 7. feladat
        Main.feladat7(versenyzok);
        
        
        // 8. feladat
        Main.feladat8(versenyzok);
        
    }
    
    public static void feladat8(ArrayList<Versenyzo> versenyzok) {
        HashMap<String, Integer> stat = new HashMap();
        
        for(Versenyzo v : versenyzok) {
            if(v.getKategoria().endsWith("f")) {
                if(stat.containsKey(v.getKategoria())) {
                    int katCount = stat.get(v.getKategoria());
                    stat.replace(v.getKategoria(), katCount + 1);
                } else {
                    stat.put(v.getKategoria(), 1);
                }
            }
        }
        
        System.out.println("8. feladat: Statisztika");
        stat.forEach((key, value) -> {
            System.out.println("\t" + key + " - " + value + "fő");
        });
    }
    
    public static void feladat7(ArrayList<Versenyzo> versenyzok) {
        // 1. kategória: ff
        // 2. rajtszám[0]: R
        // 3. <ido
        
        Versenyzo gyoztes = null;
        
        for(Versenyzo v : versenyzok) {
            char tav = v.getRajtszam().charAt(0);
            if(v.getKategoria().equals("ff") && tav == 'R') {
                if(gyoztes == null) {
                    gyoztes = v;
                } else {
                    if(gyoztes.getTimeSec() > v.getTimeSec()) {
                        gyoztes = v;
                    }
                }
            }
        }
        
        System.out.println("7. feladat: A felnőtt férfi (ff) kategória győztese rövid távon");
        System.out.println("\tRajtszám: " + gyoztes.getRajtszam());
        System.out.println("\tNév: " + gyoztes.getNev());
        if(gyoztes.getEgyesulet().length() > 0) {
            System.out.println("\tEgyesület: " + gyoztes.getEgyesulet());
        }
        System.out.println("\tIdő: " + gyoztes.getIdo());
    }
    
    public static void feladat6(ArrayList<Versenyzo> versenyzok) {
        boolean flag = false;
        
        for(Versenyzo v : versenyzok) {
            // 5:59:59  -  6:00:00
            int h = Integer.parseInt(v.getIdo().split(":")[0]);
            if(h >= 6) {
                flag = true;
                System.out.println("6. feladat: Volt ilyen versenyző!");
                break;
            }
        }
        
        if(!flag) {
            System.out.println("6. feladat: Nem volt ilyen versenyző!");
        }
    }
    
    public static void feladat5(ArrayList<Versenyzo> versenyzok) {
        int szamlalo = 0;
        for(Versenyzo v : versenyzok) {
            Versenytav vt = new Versenytav(v.getRajtszam());
            
            int katLen = v.getKategoria().length();
            char last = v.getKategoria().charAt(katLen - 1);
            
            if(vt.getTav().equals("Rövid") && last == 'n') {
                szamlalo++;
            }
        }
        
        System.out.println("5. feladat: Női versenyzők száma a rövid távú versenyen: " + szamlalo + "fő");
    }
    
    public static ArrayList<Versenyzo> beolvas() {
        ArrayList<Versenyzo> versenyzok = new ArrayList();
        
        File fajl = new File("bukkm2019.txt");
        try {
            Scanner sc = new Scanner(fajl);
            sc.nextLine();
            
            while(sc.hasNextLine()) {
                String row = sc.nextLine();
                
                Versenyzo versenyzo = new Versenyzo(row);
                versenyzok.add(versenyzo);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        return versenyzok;
    }
    
}
