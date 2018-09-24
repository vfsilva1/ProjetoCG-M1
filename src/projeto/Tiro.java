package projeto;

import java.awt.*;

public class Tiro  {
    private double xmin, xmax;  
    private double ymin, ymax;  
    private double x,y;      
    private double dx,dy;    
    private Color color;     
    private double radius;
    public boolean visivel;
   
   
    public Tiro(double left, double right, double top, double bottom, int jogadorX, int jogadorY, int mx, int my) {
        xmin = left;
        xmax = right;
        ymin = top;
        ymax = bottom;
        x = jogadorX + 50;
        y = jogadorY + 33;
        radius = 5;
        color = Color.YELLOW;
        double angle = Math.atan2((my - jogadorY), (mx - jogadorX)); 
        double speed = 8;         
        dx = Math.cos(angle) * speed;
        dy = Math.sin(angle) * speed;
        visivel = true;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval( (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius) );
    }

   public void travel() {
      travel(5.0);
   }

   public void travel(double time) {
      if (xmax - xmin < 2*radius || ymax - ymin < 2*radius)
         return;

      if (x-radius < xmin)
         x = xmin + radius;
      else if (x+radius > xmax)
         x = xmax - radius;
      if (y - radius < ymin)
         y = ymin + radius;
      else if (y + radius > ymax)
         y = ymax - radius;
           
      double newx = x + dx*time;
      double newy = y + dy*time;
      
      x = newx;
      y = newy;
      
   }

   public void setColor(Color c) {
      if (c != null)
         color = c;
   }

   public void setRadius(int r) {
      radius = r;
      if (radius < 0.5)
         radius = 0.5;
   }

   public void setLimits(double left, double right, double top, double bottom) {
      xmin = left;
      xmax = right;
      ymin = top;
      ymax = bottom;
   }

   public void setLocation(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public void setSpeed(double speed) {
      if (speed > 0) {
          double currentSpeed = Math.sqrt(dx*dx + dy*dy);
          dx = dx * speed / currentSpeed;
          dy = dy * speed / currentSpeed;
      }
   }

   public void headTowards(int a, int b) {
      double vx = a - x;
      double vy = b - y;
      double dist = Math.sqrt(vx*vx + vy*vy);
      if (dist > 0) {
         double speed = Math.sqrt(dx*dx + dy*dy);
         dx = vx / dist * speed;
         dy = vy / dist * speed;
      }
   }

   public void setVelocity(double dx, double dy) {
      if (dx != 0 || dy != 0) {
         this.dx = dx;
         this.dy = dy;
      }
   }
   
    public Rectangle getLimites(){
        return new Rectangle( (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius) );
    }
}  