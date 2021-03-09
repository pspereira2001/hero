
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

 public class Hero {
    private Position position;
    public Hero(int x, int y){
        position = new Position(x, y);
    }
    public void draw(Screen screen){
        screen.setCharacter(getX(), getY(), TextCharacter.fromCharacter('X')[0]);
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
