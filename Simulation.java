import GLOOP.*;
public class Simulation {
    private GLKamera cam;
    private GLLicht licht;
    private GLTastatur tast;
    private GLBoden boden;
    
    private Schlaeger schlaeger;
    private Ball ball;
    
    private Bahn[] bahn;
   
    private boolean camEins = false;
    private boolean camZwei = false;
    private double camX, camY, camZ;
    private double blickX, blickY, blickZ;
    private boolean ccX = false, ccY = false, ccZ = false, bbX = false, bbY = false, bbZ = false;
    public Simulation() {
        licht = new GLLicht();
        tast = new GLTastatur();
        boden = new GLBoden("boden.jpg");
        bahn = new Bahn[5];
        bahn[0] = new Bahn(0,0,0);
        bahn[1] = new Bahn2(0,0,-350);
        bahn[2] = new Bahn3(0,0,-700);
        bahn[3] = new Bahn4(0,0,-1050);
        bahn[4] = new Bahn5(0,0,-1400);
        ball = new Ball(bahn[0].gibStartX(),bahn[0].gibStartY()+1.85,bahn[0].gibStartZ());
        schlaeger = new Schlaeger(ball.gibX(),ball.gibY(),ball.gibZ());
        cam = new GLKamera();
        cam.setzePosition(bahn[0].gibX(),bahn[0].gibY()+250,bahn[0].gibZ()+400);
        cam.setzeBlickpunkt(bahn[0].gibX(),bahn[0].gibY(),bahn[0].gibZ());
        
        while(!tast.esc()) {
            schlaeger.ballUpdate(ball.gibX(), ball.gibY(), ball.gibZ());
            
            if (!schlaeger.wurdeGeschlagen()) {
                if(tast.istGedrueckt(' ')) {
                    schlaeger.schlagen();
                }
                if(tast.links()) {
                    schlaeger.dreheLinks();
                }
                if(tast.rechts()) {
                    schlaeger.dreheRechts();
                }
//             if(tast.istGedrueckt('a')) {
//                 schlaeger.bewegeLinks();
//             }
//             if(tast.istGedrueckt('d')) {
//                 schlaeger.bewegeRechts();
//             }
            } 
            if (schlaeger.schlaegt()) {
                if (schlaeger.winkelX() >= -1.5 && schlaeger.winkelX() <= 1.5 && schlaeger.winkelZ() >= -1.5 && schlaeger.winkelZ() <= 1.5) {
                    schlaeger.hatGeschlagen();
                    ball.drehe(0,schlaeger.winkelY()-ball.gibDrehungY(),0);
                    ball.setzeBallGeschwindigkeit(schlaeger.gibSchlagKraft()/7);
                }
            }
            if(tast.istGedrueckt('1')) {
                //Schlagen
                cam.setzePosition(schlaeger.gibX()+300,schlaeger.gibY()+250,schlaeger.gibZ()+150);
                cam.setzeBlickpunkt(bahn[0].gibLochX(),bahn[0].gibLochY(),bahn[0].gibLochZ());
                camX=cam.gibX();
                camY=cam.gibY();
                camZ=cam.gibZ();
                blickX = cam.gibBlickpunktX();
                blickY = cam.gibBlickpunktY();
                blickZ = cam.gibBlickpunktZ();
                camEins = true;
            }
            if(tast.istGedrueckt('2') && camEins) {
                double cX=0, cY=0, cZ=0;
                double bX=0, bY=0, bZ=0;
                while(!ccX || !ccY || !ccZ || !bbX || !bbY || !bbZ) {
                	boolean fertig=false;
                	System.out.println("cX: "+cX);
                	System.out.println("cY: "+cY);
                	System.out.println("cZ: "+cZ);
                	System.out.println("bX: "+bX);
                	System.out.println("bY: "+bY);
                	System.out.println("bZ: "+bZ);
                        if(!ccX) {
                            if(cam.gibX() > bahn[0].gibX()) {
                                cX -=1;
                            }
                            if(cam.gibX() < bahn[0].gibX()) {
                                cX +=1; 
                            }
                            if(cam.gibX() == bahn[0].gibX()) {
                                ccX = true;
                                System.out.println("ccX");
                                
                            }
                        }
                        if(!ccY) {
                        	fertig=false;
                            if(cam.gibY() > bahn[0].gibY()+250&&!fertig) {
                                cY -=1;
                                fertig=true;
                            }
                            if(cam.gibY() < bahn[0].gibY()+250&&!fertig) {
                                cY +=1;
                                fertig=true;
                            }
                            if(cam.gibY() == bahn[0].gibY()+250&&!fertig) {
                                ccY = true;
                                System.out.println("ccY");
                                fertig=true;
                               
                            }
                           
                        }
                        if(!ccZ) {
                            if(cam.gibZ() > bahn[0].gibZ()+400) {
                                cY -=1;
                            }
                            if(cam.gibZ() < bahn[0].gibZ()+400) {
                                cY +=1;
                            }
                            if(cam.gibZ() == bahn[0].gibZ()+400) {
                                ccZ = true;
                                System.out.println("ccZ");
                                
                            }
                        }
                        if(!bbX) {
                            if(cam.gibBlickpunktX() < bahn[0].gibX()) {
                                bX +=1;
                            }
                            if(cam.gibBlickpunktX() > bahn[0].gibX()) {
                                bX -=1;
                            }
                            if(cam.gibBlickpunktX() == bahn[0].gibX()) {
                                bbX = true;
                                System.out.println("bbX");
                                
                            }
                        }
                        if(!bbY) {
                            if(cam.gibBlickpunktY() < bahn[0].gibY()) {
                                bY +=1;
                            }
                            if(cam.gibBlickpunktY() > bahn[0].gibY()) {
                                bY -=1;
                            }
                            if(cam.gibBlickpunktY() == bahn[0].gibY()) {
                                bbY = true;
                                System.out.println("bbY");
                               
                            }
                        }
                        if(!bbZ) {
                            if(cam.gibBlickpunktZ() < bahn[0].gibZ()) {
                                bZ +=1;
                            }
                            if(cam.gibBlickpunktZ() > bahn[0].gibZ()) {
                                bZ -=1;
                            }
                            if(cam.gibBlickpunktZ() == bahn[0].gibZ()) {
                                bbZ = true;
                                System.out.println("bbZ");
                               
                            }
                        }
                        cam.setzePosition(camX+cX,camY+cY,camZ+cZ);
                        cam.setzeBlickpunkt(blickX+bX,blickY+bY,blickZ+bZ);
                        Sys.warte(1);
                    }
                    //cam.setzePosition(bahn[0].gibX(),bahn[0].gibY()+250,bahn[0].gibZ()+400);
                    //cam.setzeBlickpunkt(bahn[0].gibX(),bahn[0].gibY(),bahn[0].gibZ());
                }
//             if(tast.istGedrueckt('2')) {
//                 //Bahn
//                 cam.setzePosition(bahn[0].gibX(),bahn[0].gibY()+250,bahn[0].gibZ()+400);
//                 cam.setzeBlickpunkt(bahn[0].gibX(),bahn[0].gibY(),bahn[0].gibZ());
//             }
            ball.update();
            schlaeger.update();
            Sys.warte();
            //cam.gibX() != bahn[0].gibX() && cam.gibY() != bahn[0].gibY()+250 && cam.gibZ() != bahn[0].gibZ()+400 && cam.gibBlickpunktX() != bahn[0].gibX() && cam.gibBlickpunktY() != bahn[0].gibY() && cam.gibBlickpunktZ() != bahn[0].gibZ()
        }
    }
}
