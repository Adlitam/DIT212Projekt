package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Johan on 2015-05-05.
 */
public class Player extends Sprite implements InputProcessor {
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }




    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
    }

    private Vector2 velocity = new Vector2();

    private float speed = 60;

    private TiledMapTileLayer collisionLayer;

    public Player(Sprite sprite, TiledMapTileLayer collisionLayer){
        super(sprite);
        this.collisionLayer = collisionLayer;
    }

    @Override
    public void draw(Batch spriteBatch){
        update(Gdx.graphics.getDeltaTime());
        super.draw(spriteBatch);

    }
    public void update(float delta){

        if(velocity.y > speed){
            velocity.y = speed;
        }else if(velocity.y < -speed){
            velocity.y = -speed;
        }

        float oldX = getX(), oldY = getY(), tileWidth=collisionLayer.getTileWidth(),tileHeight = collisionLayer.getTileHeight();
        boolean collisionX = false, collisionY = false;
        setX(getX() + velocity.x*delta);

        if(velocity.x<0){
            //topLeft
            collisionX = collisionLayer.getCell((int)(getX()/tileWidth),(int)((getY()+getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //middleLeft
            if(!collisionX) {
                collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
            //bottomLeft
            if(!collisionX) {
                collisionX = collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
        }else if(velocity.x>0){
            //topRight
            collisionX = collisionLayer.getCell((int)((getX()+getWidth())/tileWidth),(int)((getY()+getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //middleRight
            if(!collisionX) {
                collisionX = collisionLayer.getCell((int) ((int)((getX()+getWidth()/2) / tileWidth)), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
            //bottomRight
            if(!collisionX) {
                collisionX = collisionLayer.getCell((int) ((int)((getX()+getWidth())) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
        }

        if(collisionX){
            setX(oldX);
            velocity.x = 0;
        }

        setY(getY() + velocity.y*delta);
        if(velocity.y<0){
            //leftBottom
            collisionY = collisionLayer.getCell((int)(getX()/tileWidth),(int)(getY()/tileHeight)).getTile().getProperties().containsKey("blocked");
            //middleBottom
            if(!collisionY) {
                collisionY = collisionLayer.getCell((int) ((getX()+getWidth()/2) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
            //rightBottom
            if(!collisionY) {
                collisionY = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
            }

        }else if(velocity.y>0){
            //leftTop
            collisionY = collisionLayer.getCell((int)(getX()/tileWidth),(int)((getY()+getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //middleTop
            if(!collisionY) {
                collisionY = collisionLayer.getCell((int) ((getX()+getWidth()/2) / tileWidth), (int) ((getY()+getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
            //rightTop
            if(!collisionY) {
                collisionY = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
        }
        if(collisionY){
            setY(oldY);
            velocity.y=0;
        }

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Keys.UP:
                velocity.y = speed;
                break;
            case Keys.LEFT:
                velocity.x = -speed;
                break;
            case Keys.RIGHT:
                velocity.x = speed;
                break;
            case Keys.DOWN:
                velocity.y = -speed;
                break;

        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Keys.UP:
                velocity.y = 0;
                break;
            case Keys.LEFT:
                velocity.x=0;
                break;
            case Keys.RIGHT:
                velocity.x=0;
                break;
            case Keys.DOWN:
                velocity.y = 0;
                break;

        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
