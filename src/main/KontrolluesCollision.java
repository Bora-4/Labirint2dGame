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
}
