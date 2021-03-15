import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private List<Wall> walls;
    public int height;
    public int width;
    public boolean bigq = true;
    private Hero hero;
    public Arena(int height, int width){
        this.walls = createWalls();
        hero = new Hero(10, 10);
        this.height = height;
        this.width = width;
    }
    public void draw(Screen screen){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
    }

    public void processKey(KeyStroke key){
        if (key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.moveUp());
        }
        else if (key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.moveDown());
        }
        else if (key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
        }
        else if (key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.moveRight());
        }
        else if(key.getCharacter() == 'q') {
            bigq = false;
        }
    }

    private void moveHero(Position position) {
        if(canHeroMove(position)){
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position){
        if (Math.abs(position.getY()) < height && Math.abs(position.getX()) < width && position.getY() >= 0 && position.getX() >= 0){
            return true;
        }
        else{
            return false;
        }
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

}
