import GLOOP.*;
public class Ball
{
    private GLKugel ball;
    private double x = 0, y = 0, z = 0;
    private double winkelX = 0, winkelY = 0, winkelZ = 0;
    private double ballGeschw = 0;
    private double t = 0;
    private double intervall = 0.005;

    public Ball(double pX, double pY, double pZ)
    {
        x = pX;
        y = pY;
        z = pZ;
        ball = new GLKugel(x,y,z,2);
    }
    
    public void update() {
        double verschiebungX = (Math.cos(Math.toRadians(winkelY))*ballGeschw*(t+intervall)) - (Math.cos(Math.toRadians(winkelY))*ballGeschw*t);
        double verschiebungZ = (Math.sin(Math.toRadians(winkelY))*ballGeschw*(t+intervall)) - (Math.sin(Math.toRadians(winkelY))*ballGeschw*t);
        ball.verschiebe(verschiebungX,0,verschiebungZ);
        ballGeschw -= 0.2;
        if (ballGeschw < 0) {
            ballGeschw = 0;
            t = 0;
        }
        this.verschiebe(-ballGeschw,0,0);
        t += intervall;
    }
    
    public void verschiebe(double pX, double pY, double pZ) {
        ball.verschiebe(pX, pY, pZ);
        x += pX;
        y += pY;
        z += pZ;
    }
    
    public void drehe(double wX, double wY, double wZ) {
        ball.drehe(wX,wY,wZ);
        winkelX += wX;
        winkelY += wY;
        winkelZ += wZ;
    }
    
    public void setzeBallGeschwindigkeit(double geschw) {
        ballGeschw = geschw;
    }
    
    public double gibX() {
        return x;
    }
    public double gibY() {
        return y;
    }
    public double gibZ() {
        return z;
    }
    public double gibDrehungX() {
        return winkelX;
    }
    public double gibDrehungY() {
        return winkelY;
    }
    public double gibDrehungZ() {
        return winkelZ;
    }
}
