public class CaseMur extends Case {


    public String getNom() {

    return  "murH";
    }

    public void effet(Bot r) {

        switch(r.getO()) {


        case haut:
            r.setY(r.getY() -1 );
            break;
        case bas:
            r.setY(r.getY() +1 );
            break;
        case droite:
            r.setX(r.getX() -1 );
            break;
        case gauche:
            r.setX(r.getX() + 1);
            break;}
        // deux robots ne peuvent pas etre sur la même case
        // si le robot sort de la matrice théorique, il meurt...
    }
}
