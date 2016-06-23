package nl.hr.tylerdegraaff.easyspot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    DBHandler db;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        imageView = (ImageView)findViewById(R.id.anim_logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_up);
        imageView.setAnimation(animation);

        db = new DBHandler(this);
        DBHandler db = new DBHandler(this);

        db.addCamping(new Camping(1, "Camping Blue Sea", "France, Montpellier", R.drawable.camping1,
                90325252, 120, "campingbluesea@info.fr", "Relaxing place with an amazing blue sea. " +
                "Come see the the beautiful fishes by yourself. Or are you afraid for the other creatures. The sharks won't eat you, we promise!",
                "Amazing blue sea, Restaurants, Shops"));
        db.addCamping(new Camping(2, "Camping Hollandia", "France, Nice", R.drawable.camping2,
                90852675, 95, "campingholland@info.fr", "For all the Dutch people, who needs a really nice holiday but also wants some Dutchies around them. " +
                "Come do lots of sport activity and join our own EK poule.", "Sport activity, Restaurants, Dutch events"));
        db.addCamping(new Camping(3, "Camping Karaoke", "France, Marseille", R.drawable.camping3,
                90295062, 80, "campingkaraoke@info.fr", "Screaming with your terrible voice, just come here en sing every song that you always wanted. " +
                "Done with singing? Lets hangout out with some nice drinks!", "Karaoke bar, Kids place, Supermarket"));
        db.addCamping(new Camping(4, "Camping Biervat", "Belgium, Bertrix", R.drawable.camping4,
                74328427, 40, "campingbiervat@info.fr", "Do you like beer just as much as we do? Then is this the perfect place for you." +
                "Done with drinking? We got more beer let's gooooo!", "Beer bar, Beer, Special beer supermarkt"));
        db.addCamping(new Camping(5, "Camping Fitness", "Spain, Madrid", R.drawable.camping5,
                85438543, 150, "campingfitness@info.fr", "You wanna go on a vacation but dont want to lose gains? This is the place." +
                "After your workout we got some nice protein shakes for you!", "Fitness bar, Fitness place, Super Protein Supermarkt"));
        db.addCamping(new Camping(6, "Camping Barber", "Netherlands, Maastricht", R.drawable.camping6,
                64326741, 10, "campingbarber@info.fr", "Cheap and for short stays! Get the feeling of the Netherlands with a lot of cheese!" +
                "And if cheese gets out of your nose we got peanutbutter.", "Cheese Bar, Peanutbutter Jelly Time, Peanutbutter"));


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity(new Intent(getApplicationContext(),LogInActivity.class));

                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
