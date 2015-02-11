import GLOOP.*;
public class Bahn2 extends Bahn
{
    private GLQuader quader;
    public Bahn2(double pX, double pY, double pZ)
    {
        super(pX,pY,pZ);
        quader = new GLQuader(pX,pY+10,pZ,20,20,50);
        quader.setzeFarbe(0.5,0.25,0.85);
        super.setzeText("2");
    }

}
