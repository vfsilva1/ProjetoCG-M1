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
        color = Color.GRAY;
        double angle = Math.atan2((my - jogadorY), (mx - jogadorX));  // Random direction.
        double speed = 8;          // Random speed.
        dx = Math.cos(angle) * speed;
        dy = Math.sin(angle) * speed;
        visivel = true;
    }
   

   /**
    * Draw the ball in the graphics context g.  Note: The drawing color
    * in g is changed to the color of the ball.
    * 
    */
   
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval( (int)(x-radius), (int)(y-radius), (int)(2*radius), (int)(2*radius) );
    }

   /**
    * Move the ball by one time unit.  The ball moves in its current
    * direction for a number of pixels equal to its current speed.
    * That is, speed is given in terms of pixels per time unit.
    * Note:  The ball won't move at all if the width or height
    * of the rectangle is smaller than the ball's diameter.
    */
   public void travel() {
      travel(5.0);
   }
   
   
   /**
    * Move the ball for the specified number of time units.
    * The ball is restricted to the specified rectangle.
    * Note:  The ball won't move at all if the width or height
    * of the rectangle is smaller than the ball's diameter.
    */
   public void travel(double time) {
          
      /* Don't do anything if the rectangle is too small. */
          
      if (xmax - xmin < 2*radius || ymax - ymin < 2*radius)
         return;

      /* First, if the ball has gotten outside its rectangle, move it
         back.  (This will only happen if the rectangle was changed
         by calling the setLimits() method or if the position of 
         the ball was changed by calling the setLocation() method.)
      */
      
      if (x-radius < xmin)
         x = xmin + radius;
      else if (x+radius > xmax)
         x = xmax - radius;
      if (y - radius < ymin)
         y = ymin + radius;
      else if (y + radius > ymax)
         y = ymax - radius;
         
      /* Compute the new position, possibly outside the rectangle. */
         
      double newx = x + dx*time;
      double newy = y + dy*time;
      
      /* If the new position lies beyond one of the sides of the rectangle,
         "reflect" the new point through the side of the rectangle, so it
         lies within the rectangle. */
      
            
      /* We have the new values for x and y. */
      
      x = newx;
      y = newy;
      
   } // end travel()
   
   
   /**
    * Set the color of the ball.
    * @param c the color; if c is null, nothing is done.
    */
   public void setColor(Color c) {
      if (c != null)
         color = c;
   }
   

   /**
    * Set the radius of the ball.  Adjust the radius, if necessary,
    * so the diameter of the ball is at least one pixel.
    */
   public void setRadius(int r) {
      radius = r;
      if (radius < 0.5)
         radius = 0.5;
   }
   

   /**
    * Set the horizontal and vertical limits on the motion of the ball.
    */
   public void setLimits(double left, double right, double top, double bottom) {
      xmin = left;
      xmax = right;
      ymin = top;
      ymax = bottom;
   }
   

   /**
    * Set the position of the ball.
    */
   public void setLocation(double x, double y) {
      this.x = x;
      this.y = y;
   }
   

   /**
    * Set the speed of the ball, if speed > 0.  The speed is
    * restricted to being strictly positive.  (If you want the
    * ball to stay still, don't call the travel() method!)
    */
   public void setSpeed(double speed) {
      if (speed > 0) {
          double currentSpeed = Math.sqrt(dx*dx + dy*dy);
          dx = dx * speed / currentSpeed;
          dy = dy * speed / currentSpeed;
      }
   }
   

   /**
    * Adjust the direction of motion of the ball so that it is
    * headed towards the point (a,b).  If the ball happens to
    * lie exactly at the point (a,b) already, this operation is
    * undefined, so nothing is done.
    */
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
   

   /**
    * Set the velocity of the ball.  At least one of dx and
    * dy must be non-zero, so that the speed will be positive.
    */
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