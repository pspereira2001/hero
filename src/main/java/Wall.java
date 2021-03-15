
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;


public class Wall {
    private Position position;
    public Wall(int x, int y){
        position = new Position(x, y);
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#853333"));
        graphics.fillRectangle(new TerminalPosition(this.getY(), this.getX()), new TerminalSize(1, 1), ' ');
    }

    public int getX() {
        return position.getX();
    }
    public int getY() {
        return position.getY();
    }

}
