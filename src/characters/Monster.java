package characters;

import tiles.PositionedImage;
import tiles.Tile;

import java.awt.*;

public class Monster extends Character {
    private int x;
    private int y;
    private static final String URL = "resources/skeleton.png";

    public Monster(int x, int y){
        this.setStrikePower(1);
        this.setHP(5);
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics graphics) {
        if (this.getHP() > 0) {
            PositionedImage image = new PositionedImage(URL,x * Tile.SIZE,y * Tile.SIZE);
            image.draw(graphics);
        }
    }

    @Override
    public boolean isAlive() {
        return this.getHP() > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void gotDamage(Hero hero) {
        this.setHP(this.getHP() - hero.getStrikePower());
    }

    public boolean attack(Hero hero){
        if (this.getX() == hero.getX() && this.getY() == hero.getY()){
            hero.gotDamage(this);
            return true;
        }
        return false;
    }

}
