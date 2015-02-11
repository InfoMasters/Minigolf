import GLOOP.*;
public class Startpunkt
{
    private GLTorus startpunkt;
    public Startpunkt(double pX, double pY, double pZ)
    {
        startpunkt = new GLTorus(pX,pY,pZ,4,1.15);
        startpunkt.setzeDrehung(90,0,0);
        startpunkt.setzeFarbe(1,0,0);
    }
}
