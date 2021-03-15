import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game{
    private Screen screen;
    private Arena arena;
    public Game() throws IOException{
        try{
            arena = new Arena(20,40);
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();   // resize screen if necessary
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException{
        try{
            screen.clear();
            arena.draw(screen);
            screen.refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException{
        while (arena.bigq) {
            try {
                this.draw();
                KeyStroke key = screen.readInput();
                processKey(key);
                if(key.getKeyType() == KeyType.EOF){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void processKey(KeyStroke key) throws IOException{
        arena.processKey(key);
    }
}