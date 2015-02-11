import GLOOP.*;
public class Bahn1 extends Bahn
{
    private GLQuader quader;
    public Bahn1(double pX, double pY, double pZ)
    {
        super(pX,pY,pZ);
        quader = new GLQuader(0,10,0,20,50,20);
        quader.setzeDrehung(90,0,0);
        quader.setzeFarbe(0.5,0.25,0.85);
        super.setzeText("1");
    }

}
