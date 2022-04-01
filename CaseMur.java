public class CaseMur extends Case {


    public String getNom() {

    return  "murH";
    }

    public void effet(Bot r) {

        switch(r.getO()) {


        case haut:
            r.setX(r.getX() +1 );
            break;
        case bas:
            r.setX(r.getX() -1 );
            break;
        case droite:
            r.setY(r.getY() -1 );
            break;
        case gauche:
            r.setY(r.getY() + 1);
            break;}
        // deux robots ne peuvent pas etre sur la même case
        // si le robot sort de la matrice théorique, il meurt...
    }
}
