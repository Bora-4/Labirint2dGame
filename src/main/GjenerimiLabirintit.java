//package main;
//import drejtimi.Drejtimi;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class GjenerimiLabirintit {
//    private final int kolona, rreshta;
//    private boolean[][] veri;
//    private boolean[][] lindje;
//    private boolean[][] jug;
//    private boolean[][] perendim;
//
//    public GjenerimiLabirintit(int kolona, int rreshta) {
//        this.kolona = kolona;
//        this.rreshta = rreshta;
//        init();
//    }
//
//    private void init() {
//        veri = new boolean[kolona + 2][rreshta + 2];
//        lindje = new boolean[kolona + 2][rreshta + 2];
//        jug = new boolean[kolona + 2][rreshta + 2];
//        perendim = new boolean[kolona + 2][rreshta + 2];
//
//        for (int col = 0; col < kolona + 2; col++) {
//            for (int row = 0; row < rreshta + 2; row++) {
//                veri[col][row] = true;
//                lindje[col][row] = true;
//                jug[col][row] = true;
//                perendim[col][row] = true;
//            }
//        }
//    }
//
//    public void gjeneroLabirint() {
//
//        gjenero(1, 1);
//    }
//
//    private void gjenero(int kolona, int rreshta) {
//        List<Drejtimi> drejtimet = Arrays.asList(Drejtimi.NORTH, Drejtimi.EAST, Drejtimi.SOUTH, Drejtimi.WEST);
//        Collections.shuffle(drejtimet);
//
//        for (Drejtimi drejtim : drejtimet) {
//            int pasKol = kolona + drejtim.getKolOffset();
//            int pasRresht = rreshta + drejtim.getRreshtOffset();
//
//            if (pasKol > 0 && pasKol <= kolona && pasRresht > 0 && pasRresht <= rreshta) {
//                if (!(veri[pasKol][pasRresht] || lindje[pasKol][pasRresht] || jug[pasKol][pasRresht] || perendim[pasKol][pasRresht])) {
//                    // Nëse fqinji nuk është vizituar
//                    switch (drejtim) {
//                        case NORTH:
//                            veri[kolona][rreshta] = false;
//                            jug[pasKol][pasRresht] = false;
//                            break;
//                        case EAST:
//                            lindje[kolona][rreshta] = false;
//                            perendim[pasKol][pasRresht] = false;
//                            break;
//                        case SOUTH:
//                            jug[kolona][rreshta] = false;
//                            veri[pasKol][pasRresht] = false;
//                            break;
//                        case WEST:
//                            perendim[kolona][rreshta] = false;
//                            lindje[pasKol][pasRresht] = false;
//                            break;
//                    }
//
//                    gjenero(pasKol, pasRresht);
//                }
//            }
//        }
//    }
//
//    public boolean isMur(int kolona, int rreshta) {
//        return veri[kolona][rreshta] || lindje[kolona][rreshta] || jug[kolona][rreshta] || perendim[kolona][rreshta];
//    }
//
//    public int getKolona() {
//        return kolona;
//    }
//
//    public int getRreshta() {
//        return rreshta;
//    }
//}