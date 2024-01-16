//package drejtimi;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public enum Drejtimi {
//    NORTH(0, -1),
//    EAST(1, 0),
//    SOUTH(0, 1),
//    WEST(-1, 0);
//
//    private final int kolOffset;
//    private final int rreshtOffset;
//
//    Drejtimi(int kolOffset, int rreshtOffset) {
//        this.kolOffset = kolOffset;
//        this.rreshtOffset = rreshtOffset;
//    }
//
//    public int getKolOffset() {
//        return kolOffset;
//    }
//
//    public int getRreshtOffset() {
//        return rreshtOffset;
//    }
//
//    public static Drejtimi getRandomDirection() {
//        List<Drejtimi> drejtimet = Arrays.asList(Drejtimi.values());
//        Collections.shuffle(drejtimet);
//        return drejtimet.get(0);
//    }
//}