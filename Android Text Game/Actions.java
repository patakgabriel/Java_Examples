package com.example.gabriel.makedecision;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;



public class Actions extends AppCompatActivity {

    //Objects
    public static Random random = new Random();

    //Game variables
    public static String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
    public static String enemy = enemies[random.nextInt(enemies.length)];
    public static int maxEnemyHealth = 75;
    public static int enemyHealth = random.nextInt(maxEnemyHealth);
    public static int enemyAttackDamage = 25;
    public static int score = 0;

    //Player variables
    public static int health = 100;
    public static int attackDamage = 50;
    public static int numHealthPotions = 3;
    public static int healthPotionHealAmount = 30;
    public static int healthPotionDropChance = 50; //Percentage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        //Objects
        final Button buttonA = findViewById(R.id.buttonA);
        final Button buttonB = findViewById(R.id.buttonB);
        final Button next = findViewById(R.id.next);
        final Button playAgain = findViewById(R.id.playAgain);

        TextView actionText = (TextView) findViewById(R.id.actionText);
        TextView hpPlayer = (TextView) findViewById(R.id.hpPlayer);
        TextView hpEnemy = (TextView) findViewById(R.id.hpEnemy);
        TextView hpPotions = (TextView) findViewById(R.id.hpPotions);
        TextView scoreText = (TextView) findViewById(R.id.score);

        actionText.setText("\t" + enemy + " has appeared! \nWhat would you like to do?");
        hpPlayer.setText("\tYour HP: " + health);
        hpEnemy.setText("\t" + enemy + "'s HP: " + enemyHealth);
        ;
        hpPotions.setText("\tPotions: " + numHealthPotions);
        scoreText.setText("Score: " + score);

        buttonA.setOnClickListener(new View.OnClickListener() {
            TextView actionText = (TextView) findViewById(R.id.actionText);
            TextView hpPlayer = (TextView) findViewById(R.id.hpPlayer);
            TextView hpEnemy = (TextView) findViewById(R.id.hpEnemy);
            TextView hpPotions = (TextView) findViewById(R.id.hpPotions);
            TextView scoreText = (TextView) findViewById(R.id.score);

            public void onClick(View v) {

                int damageDealt = random.nextInt(attackDamage);
                int damageTaken = random.nextInt(enemyAttackDamage);

                enemyHealth -= damageDealt;
                health -= damageTaken;
                actionText.setText("\tYou strike the " + enemy + " for " + damageDealt + " damage." +
                        "\n\tYou received " + damageTaken + " in retaliation");

                if (enemyHealth <= 0 && health > 0) {
                    next.setVisibility(View.VISIBLE);
                    buttonA.setVisibility(View.GONE);
                    buttonB.setVisibility(View.GONE);
                    hpEnemy.setVisibility(View.GONE);
                    score++;
                    scoreText.setText("Score: " + score);
                    if (random.nextInt(100) < healthPotionDropChance) {
                        numHealthPotions++;
                        actionText.setText("\tThe " + enemy + " dropped a health potion.\n" +
                                "\tYou now have " + numHealthPotions + " health potion(s).");
                        hpPotions.setText("\tPotions: " + numHealthPotions);
                    }

                } else if (health < 1) {
                    actionText.setText("\tYou lost!");
                    buttonA.setVisibility(View.GONE);
                    buttonB.setVisibility(View.GONE);
                    playAgain.setVisibility(View.VISIBLE);
                }
                hpEnemy.setText("\t" + enemy + "'s HP: " + enemyHealth);
                hpPlayer.setText("\tYour HP: " + health);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            TextView actionText = (TextView) findViewById(R.id.actionText);
            TextView hpPlayer = (TextView) findViewById(R.id.hpPlayer);
            TextView hpPotions = (TextView) findViewById(R.id.hpPotions);

            public void onClick(View v) {
                if (numHealthPotions > 0) {
                    health += healthPotionHealAmount;
                    numHealthPotions--;
                    actionText.setText("\tYou drank a health potion, healed for: " + healthPotionHealAmount + ".");
                    hpPlayer.setText("\tYour HP: " + health);
                    hpPotions.setText("\tPotions: " + numHealthPotions);
                } else {
                    actionText.setText("\tDefeat enemies for a chance to get one");
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            TextView actionText = (TextView) findViewById(R.id.actionText);
            TextView hpEnemy = (TextView) findViewById(R.id.hpEnemy);

            public void onClick(View v) {
                enemyHealth = random.nextInt(maxEnemyHealth);
                enemy = enemies[random.nextInt(enemies.length)];
                actionText.setText("\t" + enemy + " has appeared! \nWhat would you like to do?");
                next.setVisibility(View.GONE);
                buttonA.setVisibility(View.VISIBLE);
                buttonB.setVisibility(View.VISIBLE);
                hpEnemy.setVisibility(View.VISIBLE);
                hpEnemy.setText("\t" + enemy + "'s HP: " + enemyHealth);
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                health = 100;
                score = 0;
                numHealthPotions = 3;
                enemyHealth = random.nextInt(maxEnemyHealth);
                enemy = enemies[random.nextInt(enemies.length)];
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }


}
