package rohitsingla.rdrock.spinthepen;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewPen;
    private Random random;
    private int oldDirection;
    private boolean isPenSpinning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewPen = findViewById(R.id.imageViewPen);
        random = new Random();

    }


    public void spinThePen(View view) {
        if (!isPenSpinning) {
            int newDirection = random.nextInt(2600);
            float pivotX = imageViewPen.getPivotX();
            float pivotY = imageViewPen.getPivotY();
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
