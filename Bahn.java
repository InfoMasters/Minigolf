import GLOOP.*;
public class Bahn
{
    private GLObjekt[] bahn;
    private Loch       loch;
    private GLTorus startpunkt;
    private GLLicht licht1;
    private GLLicht licht2;
    private GLLicht licht3;
    private GLLicht licht4;
    private GLLicht licht5;
    private GLLicht licht6;
    private GLLicht licht7;
    private GLLicht licht8;
    private GLLicht licht9;
    
    //Tafel
    private GLQuader           quader;
    private GLZylinder         zylinder;
    private GLTafel            tafel;
    
    public Bahn(double pX, double pY, double pZ)
    {
        bahn = new GLObjekt[17];
        loch = new Loch(pX-250,pY+1.15,pZ);
        startpunkt = new GLTorus(pX+265,pY+1.5,pZ,2.5,1.15);
        startpunkt.setzeDrehung(90,0,0);
        startpunkt.setzeFarbe(1,0,0);
     
        bahn[0]= new GLQuader(pX,pY+1,pZ+0,600,2,140); //Bahn
        //Rand
        bahn[1]= new GLZylinder(pX,pY+10,pZ-70,3,600);
        bahn[1].setzeDrehung(0,90,0);
        bahn[2]= new GLZylinder(pX,pY+10,pZ+70,3,600);
        bahn[2].setzeDrehung(0,90,0);
        bahn[3]= new GLZylinder(pX+300,pY+10,pZ,3,140);
        bahn[3].setzeDrehung(0,0,90);
        bahn[4]= new GLZylinder(pX-300,pY+10,pZ,3,140);
        bahn[4].setzeDrehung(0,0,90);
        bahn[5]= new GLKugel(pX-300,pY+10,pZ-70,3);
        bahn[6]= new GLKugel(pX+300,pY+10,pZ-70,3);
        bahn[7]= new GLKugel(pX-300,pY+10,pZ+70,3);
        bahn[8]= new GLKugel(pX+300,pY+10,pZ+70,3);
        bahn[9]= new GLZylinder(pX-300,pY+5,pZ-70,1.5,10);
        bahn[9].setzeDrehung(90,0,0);
        bahn[10]= new GLZylinder(pX+300,pY+5,pZ-70,1.5,10);
        bahn[10].setzeDrehung(90,0,0);
        bahn[11]= new GLZylinder(pX-300,pY+5,pZ+70,1.5,10);
        bahn[11].setzeDrehung(90,0,0);
        bahn[12]= new GLZylinder(pX+300,pY+5,pZ+70,1.5,10);
        bahn[12].setzeDrehung(90,0,0);
        bahn[13]= new GLZylinder(pX+100,pY+5,pZ-70,1.5,10);
        bahn[13].setzeDrehung(90,0,0);
        bahn[14]= new GLZylinder(pX-100,pY+5,pZ+70,1.5,10);
        bahn[14].setzeDrehung(90,0,0);
        bahn[15]= new GLZylinder(pX+100,pY+5,pZ+70,1.5,10);
        bahn[15].setzeDrehung(90,0,0);
        bahn[16]= new GLZylinder(pX-100,pY+5,pZ-70,1.5,10);
        bahn[16].setzeDrehung(90,0,0);
     
        bahn[0].setzeTextur("bahn.jpg");
        for (int i=1; i<=16; i++) {
            bahn[i].setzeTextur("eisen.jpg");
        }
        //Tafel  
        //Schild
        zylinder = new GLZylinder(pX+80,pY+15,pZ+130,3,30);
        quader  = new GLQuader(pX+80,pY+47.5,pZ+130,50,35,10);
        zylinder.setzeDrehung(90,0,0);
        zylinder.setzeTextur("tafel.jpg");
        quader.setzeTextur("tafel.jpg");

        //Beschriftung
        tafel = new GLTafel(pX+80,pY+50.25,pZ+135,45,15);
        tafel.setzeText("1",15);
        tafel.setzeTextur("schild.png");
        
        //Licht
        licht1 = new GLLicht(0,400,0);
        licht2 = new GLLicht(-150,400,0);
        licht3 = new GLLicht(150,400,0);
        licht4 = new GLLicht(0,50,-200);
        licht5 = new GLLicht(0,50,200);
        licht6 = new GLLicht(350,50,0);
        licht7 = new GLLicht(-350,50,0);
        licht8 = new GLLicht(150,20,0);
        licht9 = new GLLicht(-150,20,0);
        licht1.setzeAbschwaechung(0.01);
        licht2.setzeAbschwaechung(0.01);
        licht3.setzeAbschwaechung(0.01);
        licht4.setzeAbschwaechung(0.01);
        licht5.setzeAbschwaechung(0.01);
        licht6.setzeAbschwaechung(0.01);
        licht7.setzeAbschwaechung(0.01);
        licht8.setzeAbschwaechung(0.01);
        licht9.setzeAbschwaechung(0.01);
    }
    
    public void setzeText(String f) {
        tafel.setzeText(f,15);
    }
    
    public double gibStartX() {
        return startpunkt.gibX();
    }
    
    public double gibStartY() {
        return startpunkt.gibY();
    }
    
    public double gibStartZ() {
        return startpunkt.gibZ();
    }
    public double gibLochX() {
        return loch.gibX();
    }
    public double gibLochY() {
        return loch.gibY();
    }
    public double gibLochZ() {
        return loch.gibZ();
    }
    public double gibX() {
        return bahn[0].gibX();
    }
    public double gibY() {
        return bahn[0].gibY();
    }
    public double gibZ() {
        return bahn[0].gibZ();
    }
}
