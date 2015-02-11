import GLOOP.*;
public class Loch
{
    private GLZylinder loch;
    private GLZylinder stiel;
    private GLQuader   flagge;
    public Loch(double pX, double pY, double pZ)
    {
        loch = new GLZylinder(pX,pY,pZ,6,2);
        loch.setzeDrehung(90,0,0);
        loch.setzeFarbe(0,0,0);
        stiel = new GLZylinder(pX,pY+10,pZ,1,20);
        stiel.setzeDrehung(90,0,0);
        stiel.setzeFarbe(1,0.5,0);
        flagge = new GLQuader(pX,pY+15,pZ-8,2,10,16);
        flagge.setzeFarbe(1,0.5,0);
    }
    public double gibX() {
        return loch.gibX();
    }
    public double gibY() {
        return loch.gibY();
    }
    public double gibZ() {
        return loch.gibZ();
    }
}