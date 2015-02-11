
import GLOOP.*;
import static java.lang.Math.*;
public class Schlaeger
{
    private final double geschwindigkeitBewegen=0.1;   
    private final double geschwindigkeitDrehung=0.1;
 
    GLZylinder stiel;
    GLQuader eisen;
    GLTafel pfeil;
     
    double x,y,z;
    private double  ballX;
    private double  ballY;
    private double  ballZ;
    private double  schlagKraft=0;
    private boolean schlagGestartet=false;
    private boolean werteBerechnen;
    private double  schlagSpeed=0.2;
    private double  schlagWeite;
    private double  winkelX = 0;
    private double  winkelY = 0;
    private double  winkelZ = 0;
    private boolean wurdeGeschlagen = false;
    private boolean schlaegt = false;
    public Schlaeger(double tX, double tY, double tZ)
    {
       x=tX;
       y=tY;
       z=tZ;
       stiel=new GLZylinder(x+3,y+31,z+3,1.25,50);
       stiel.setzeDrehung(90,0,0);
       eisen=new GLQuader(x+3,y+3,z+1,3,6,10);
       pfeil=new GLTafel(x+5,y,z-40,60,20,"pfeil_schlaeger.png");
       pfeil.drehe(90,90,0);
       pfeil.drehe(0,90,0,eisen.gibX(),eisen.gibY(),eisen.gibZ());
        
    }
    
    public void ballUpdate(double pX, double pY, double pZ) {
        ballX = pX;
        ballY = pY;
        ballZ = pZ;
    }
    public void dreheLinks(){
         
        stiel.drehe(0,geschwindigkeitDrehung,0,ballX,ballY,ballZ);
        eisen.drehe(0,geschwindigkeitDrehung,0,ballX,ballY,ballZ);
        pfeil.drehe(0,geschwindigkeitDrehung,0,ballX,ballY,ballZ);
        winkelY+=geschwindigkeitDrehung;
         
    }
    public void dreheRechts(){
         
        stiel.drehe(0,-geschwindigkeitDrehung,0,ballX,ballY,ballZ);
        eisen.drehe(0,-geschwindigkeitDrehung,0,ballX,ballY,ballZ);
        pfeil.drehe(0,-geschwindigkeitDrehung,0,ballX,ballY,ballZ);
        winkelY-=geschwindigkeitDrehung;
         
    }
    public void bewegeLinks(){
        z+=geschwindigkeitBewegen;
        ballX-=geschwindigkeitBewegen;
        stiel.verschiebe(geschwindigkeitBewegen,0,0);
        eisen.verschiebe(geschwindigkeitBewegen,0,0);
        pfeil.verschiebe(geschwindigkeitBewegen,0,0);
     
    }
    public void bewegeRechts(){
        z-=geschwindigkeitBewegen;
        ballX+=geschwindigkeitBewegen;
        pfeil.verschiebe(-geschwindigkeitBewegen,0,0);
        stiel.verschiebe(-geschwindigkeitBewegen,0,0);
        eisen.verschiebe(-geschwindigkeitBewegen,0,0);
         
    }
    public void schlagen(){
         
        schlagKraft+=0.5;
        double drehungX = 0.2*sin(Math.toRadians(winkelY));
        double drehungZ = 0.2*cos(Math.toRadians(winkelY));
        stiel.drehe(drehungX,0,drehungZ);
        eisen.drehe(drehungX,0,drehungZ,stiel.gibX(),stiel.gibY(),stiel.gibZ());
        winkelX += drehungX;
        winkelZ += drehungZ;
        schlagWeite-=0.2;
        werteBerechnen=true;
        schlagGestartet=true;
   
    }
    public void update(){
        if(schlagGestartet){
            if(!werteBerechnen){
                schlaegt = true;
                double drehungX = -(schlagSpeed*sin(Math.toRadians(winkelY)));
                double drehungZ = -(schlagSpeed*cos(Math.toRadians(winkelY)));
                stiel.drehe(drehungX,0,drehungZ);
                eisen.drehe(drehungX,0,drehungZ,stiel.gibX(),stiel.gibY(),stiel.gibZ());
                winkelX += drehungX;
                winkelZ += drehungZ;
                if(schlagWeite<0){
                    schlagSpeed+=0.035;
                    schlagWeite+=schlagSpeed;
                } else{
                    if(schlagSpeed>0){
                        schlagSpeed*=0.94;
                    }
                    if(schlagSpeed<0.0000000000005){
                        wurdeGeschlagen = true;
                        schlagGestartet=false;
                    }
                }
            }
        }
        werteBerechnen = false;
    }
    
    public boolean wurdeGeschlagen() {
        return wurdeGeschlagen;
    }
    public boolean schlaegt() {
        return schlaegt;
    }
    public boolean schlagGestartet() {
        return schlagGestartet;
    }
//    public void reset(){
//      
//      if(!isResettet){
//          schlag_gestartet=false;
//          schlag_kraft=0;
//          schlag_weite=0;
//          schlag_speed=0.2;
//          stiel.setzeDrehung(85,0,0);
//          eisen.setzeDrehung(0, 90, 5);
//          eisen.drehe(0,0,-15,x,y,z);
//          isResettet=true;
//      }
//    }
    public double gibSchlagKraft() {
        return schlagKraft;
    }
    public double gibX() {
        return eisen.gibX();
    }
    public double gibY() {
        return eisen.gibY();
    }
    public double gibZ() {
        return eisen.gibZ();
    }
     
    public double winkelX() {
        return winkelX;
    }
    
    public double winkelY() {
        return winkelY;
    }
    
    public double winkelZ() {
        return winkelZ;
    }
     
    public void hatGeschlagen() {
        schlaegt = false;
    }
     
}