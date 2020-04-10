package rohitsingla.rdrock.spinthepen;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewPen;
    Random random = new Random();
    int newDirection, oldDirection;
    float pivotX, pivotY;
    private boolean isPenSpinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewPen = findViewById(R.id.imageViewPen);

    }

    public void spinThePen(View view) {
        if (!isPenSpinning) {
            newDirection = random.nextInt(2600);
            pivotX = imageViewPen.getPivotX();
            pivotY = imageViewPen.getPivotY();
            Animation rotatePen = new RotateAnimation(oldDirection, newDirection, pivotX, pivotY);
            rotatePen.setDuration(1100);
            rotatePen.setFillAfter(true);

            rotatePen.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    isPenSpinning = true;

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    isPenSpinning = false;

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            oldDirection = newDirection;
            imageViewPen.startAnimation(rotatePen);


        }
    }

}
