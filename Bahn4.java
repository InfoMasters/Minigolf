import GLOOP.*;
public class Bahn4 extends Bahn
{
    private GLQuader quader;
    private GLQuader quader2;
    private GLQuader quader3;
    public Bahn4(double pX, double pY, double pZ)
    {
        super(pX,pY,pZ);
        quader = new GLQuader(pX+60,pY+10,pZ-37.25,200,20,56);
        quader.setzeFarbe(0.5,0.25,0.85);
        quader2 = new GLQuader(pX+60,pY+10,pZ+37.25,200,20,56);
        quader2.setzeFarbe(0.5,0.25,0.85);
        quader3 = new GLQuader(pX-150,pY+10,pZ+8,20,50,20);
        quader3.setzeDrehung(90,45,0);
        quader3.setzeFarbe(0.5,0.25,0.85);
        super.setzeText("4");
    }

}
