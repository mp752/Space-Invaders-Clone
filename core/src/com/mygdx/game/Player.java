package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Vector2 position_bullet;
    public Sprite sprite;
    public Sprite sprite_bullet;
    public float speed = 300;
    public float speed_bullet = 1000;
    public Player(Texture img, Texture img_bullet, Color color){
        sprite = new Sprite(img);
        sprite_bullet = new Sprite(img_bullet);
        sprite_bullet.setScale(4);
        sprite_bullet.setColor(color);
        sprite.setColor(color);
        position = new Vector2(Gdx.graphics.getWidth()/2,sprite.getScaleY()*sprite.getHeight()/2);
        sprite.setScale(4);
        position_bullet = new Vector2(0,10000);

    }

    public void Update(float deltaTime){
        if(Gdx.input.isButtonJustPressed(0) && position_bullet.y>=Gdx.graphics.getHeight()){
            position_bullet.x = position.x+3;
            position_bullet.y = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) position.x-=deltaTime*speed;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) position.x+=deltaTime*speed;

        if(position.x-(sprite.getWidth()*sprite.getScaleX()/2)<0) position.x = (sprite.getWidth()*sprite.getScaleX()/2);
        if(position.x+(sprite.getWidth()*sprite.getScaleX()/2)>=Gdx.graphics.getWidth()) position.x = Gdx.graphics.getWidth()-(sprite.getWidth()*sprite.getScaleX()/2);

        position_bullet.y+=deltaTime*speed_bullet;


    }
    public void Draw(SpriteBatch batch){
        Update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
        sprite_bullet.setPosition(position_bullet.x, position_bullet.y);
        sprite_bullet.draw(batch);

    }
}
