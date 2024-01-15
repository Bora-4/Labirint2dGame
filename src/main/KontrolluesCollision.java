package main;

import entity.Entity;

public class KontrolluesCollision {
    KontrolleriLojes gp;
    public KontrolluesCollision(KontrolleriLojes gp){
        this.gp = gp;
    }
    public void kontrolloKuti(Entity entity){
        int entityMajtasX = entity.x + entity.solidArea.x;
        int entityDjathtasX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entitySiperY = entity.y + entity.solidArea.y;
        int entityPoshteY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityKolMajtas = entityMajtasX/gp.tileSize;
        int entityKolDjathtas = entityDjathtasX/gp.tileSize;
        int entityRreshtiSiper = entitySiperY/gp.tileSize;
        int entityRreshtiPoshte = entityPoshteY/gp.tileSize;

        int kutiNr1, kutiNr2;

        switch(entity.drejtimi){
            case "lart":
                entityRreshtiSiper = (entitySiperY - entity.shpejtesia)/gp.tileSize;
                kutiNr1 = gp.kutiM.nrKutiveHarta[entityKolMajtas][entityRreshtiSiper];
                kutiNr2 =gp.kutiM.nrKutiveHarta[entityKolDjathtas][entityRreshtiSiper];
                if(gp.kutiM.kuti[kutiNr1].collision == true || gp.kutiM.kuti[kutiNr2].collision == true){
                    entity.collisionOn = true;

                }

                break;
            case "poshte":
                entityRreshtiPoshte = (entityPoshteY - entity.shpejtesia)/gp.tileSize;
                kutiNr1 = gp.kutiM.nrKutiveHarta[entityKolMajtas][entityRreshtiPoshte];
                kutiNr2 =gp.kutiM.nrKutiveHarta[entityKolDjathtas][entityRreshtiPoshte];
                if(gp.kutiM.kuti[kutiNr1].collision == true || gp.kutiM.kuti[kutiNr2].collision == true) {
                    entity.collisionOn = true;
                }

                break;
            case "majtas":
                entityKolMajtas = (entityMajtasX - entity.shpejtesia)/gp.tileSize;
                kutiNr1 = gp.kutiM.nrKutiveHarta[entityKolMajtas][entityRreshtiSiper];
                kutiNr2 =gp.kutiM.nrKutiveHarta[entityKolMajtas][entityRreshtiPoshte];
                if(gp.kutiM.kuti[kutiNr1].collision == true || gp.kutiM.kuti[kutiNr2].collision == true){
                    entity.collisionOn = true;
                }

                break;
            case "djathtas":
                entityKolDjathtas = (entityDjathtasX + entity.shpejtesia)/gp.tileSize;
                kutiNr1 = gp.kutiM.nrKutiveHarta[entityKolDjathtas][entityRreshtiSiper];
                kutiNr2 =gp.kutiM.nrKutiveHarta[entityKolDjathtas][entityRreshtiPoshte];
                if(gp.kutiM.kuti[kutiNr1].collision == true || gp.kutiM.kuti[kutiNr2].collision == true){
                    entity.collisionOn = true;
                }

                break;
        }

    }
    public int kontrolloThesarin(Entity entity, boolean lojtari) {
        int index = 299;
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {

                //get entity's solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                //get the object's solid area position
                gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;

                switch (entity.drejtimi) {
                    case "lart":
                        entity.solidArea.y -= entity.shpejtesia;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (lojtari == true) {
                                index = i;
                            }

                        }
                        break;

                    case "poshte":
                        entity.solidArea.y += entity.shpejtesia;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (lojtari == true) {
                                index = i;
                            }
                        }
                        break;

                    case "majtas":
                        entity.solidArea.x -= entity.shpejtesia;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (lojtari == true) {
                                index = i;
                            }
                        }
                        break;

                    case "djathtas":
                        entity.solidArea.x += entity.shpejtesia;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (lojtari == true) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].SolidAreaDefaultY;

            }

        }

        return index;
    }
}