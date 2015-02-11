import GLOOP.*;
public class Bahn3 extends Bahn
{
    private GLQuader quader;
    private GLQuader quader2;
    public Bahn3(double pX, double pY, double pZ)
    {
        super(pX,pY,pZ);
        quader = new GLQuader(pX+100,pY+10,pZ-40.25,20,20,50);
        quader.setzeFarbe(0.5,0.25,0.85);
        quader2 = new GLQuader(pX-100,pY+10,pZ+40.25,20,20,50);
        quader2.setzeFarbe(0.5,0.25,0.85);
        super.setzeText("3");
    }

}