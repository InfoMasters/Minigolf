import GLOOP.*;
public class Bahn5 extends Bahn
{
    private GLZylinder zylinder;
    public Bahn5(double pX, double pY, double pZ)
    {
        super(pX,pY,pZ);
        zylinder = new GLZylinder(pX,pY-350,pZ,400,140);
        zylinder.setzeFarbe(0.5,0.25,0.85);
        super.setzeText("5");
    }

}
