
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

 public class Hero {
    private Position position;
    public Hero(int x, int y){
        position = new Position(x, y);
    }
    public void draw(Screen screen){
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
    }

     public void draw(TextGraphics graphics) {
         graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
         graphics.enableModifiers(SGR.BOLD);
         graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
     }

    public Position moveUp(){
        return new Position(position.getX(), position.getY() - 1);
    }
     public Position moveDown(){
         return new Position(position.getX(), position.getY() + 1);
     }
     public Position moveLeft(){
         return new Position(position.getX() - 1, position.getY());
     }
     public Position moveRight(){
         return new Position(position.getX() + 1, position.getY());
     }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public void setPosition(Position position){
        this.position.setY(position.getY());
        this.position.setX(position.getX());
    }
}
