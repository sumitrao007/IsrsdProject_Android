package isrsd.sumit.com.isrsd.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import isrsd.sumit.com.isrsd.R;
import isrsd.sumit.com.isrsd.activity.HomeActivity;
import isrsd.sumit.com.isrsd.activity.Modular_Details;


/**
 * Created by veetron2 on 09/12/2017.
 */
public class GridViewAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    String[] result;
    Activity activity;
    int[] imageId;
    int[] background;
    Intent intent;
    Bundle extras;

    public GridViewAdapter(String[] result, Activity activity, int[] imageId, int[] background) {
        this.result = result;
        this.activity = activity;
        this.imageId = imageId;
        this.background = background;

        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.modular_gridlayout, null);
        holder.tv = (TextView) rowView.findViewById(R.id.txt_textview1);
        holder.cardview_learndev = (CardView) rowView.findViewById(R.id.cardview_learndev);
        //   holder.img=(ImageView) rowView.findViewById(R.id.img_imageView1);
        //  holder.rel_meaning=(RelativeLayout)rowView.findViewById(R.id.rel_meaning);


        //   holder.rel_meaning.setBackground(activity.getResources().getDrawable(background[position]));

        //    holder.tv.setBackground(activity.getResources().getDrawable(background[position]));
        holder.cardview_learndev.setBackground(activity.getResources().getDrawable(background[position]));

        holder.tv.setText(result[position]);
        Log.e("INAdapter", "Position is " + position);
        //   holder.img.setImageResource(imageId[position]);

        holder.tv.setCompoundDrawablesWithIntrinsicBounds(imageId[position], 0, 0, 0);


        Animation anim = AnimationUtils.loadAnimation(activity, R.anim.grid_animation);

        // By default all grid items will animate together and will look like the gridview is
        // animating as a whole. So, experiment with incremental delays as below to get a
        // wave effect.
        anim.setStartOffset(position * 100);

        rowView.setAnimation(anim);
        anim.start();


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:
                        //  toast("Update Soon "+position);
                        intent = new Intent(activity, Modular_Details.class);
                        extras = new Bundle();
                        extras.putString("mod_course", "clang");
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                        activity.finish();
                        break;
                    case 1:
                        // toast("Update Soon "+position);
                        intent = new Intent(activity, Modular_Details.class);
                        extras = new Bundle();
                        extras.putString("mod_course", "cpluslang");
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                        activity.finish();
                        break;
                    case 2:
                        //  toast("Update Soon "+position);
                        intent = new Intent(activity, Modular_Details.class);
                        extras = new Bundle();
                        extras.putString("mod_course", "corejava");
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                        activity.finish();
                        break;
                    case 3:
                        //  toast("Update Soon "+position);

                        intent = new Intent(activity, Modular_Details.class);
                        extras = new Bundle();
                        extras.putString("mod_course", "advjava");
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                        activity.finish();
                        break;
                    case 4:
                        // toast("Update Soon "+position);

                        intent = new Intent(activity, Modular_Details.class);
                        extras = new Bundle();
                        extras.putString("mod_course", "android");
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                        activity.finish();
                        break;
                    case 5:
                        // toast("Update Soon "+position);

                        intent = new Intent(activity, Modular_Details.class);
                        extras = new Bundle();
                        extras.putString("mod_course", "dotnet");
                        intent.putExtras(extras);
                        activity.startActivity(intent);
                        activity.overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
                        activity.finish();
                        break;
                }
            }
        });


/*

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

//Instead of if esle use Switch case also

                if(position==0)
                {
                    Intent intent =new Intent(activity,MeaningOfAssignment.class);
                    Bundle extras = new Bundle();
                    extras.putString("screen_Name","MeaningOfAssignment");
                    intent.putExtras(extras);
                    activity.startActivity(intent);
                    activity.finish();
                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==1)
                {
                    Intent intent =new Intent(activity,Antonyms.class);
                    Bundle extras = new Bundle();
                    extras.putString("screen_Name","Synonyms");
                    intent.putExtras(extras);
                    activity.startActivity(intent);
                    activity.finish();

                }else if(position==2)
                {
                    Intent intent =new Intent(activity,Antonyms.class);
                    Bundle extras = new Bundle();
                    extras.putString("screen_Name","Antonyms");
                    intent.putExtras(extras);
                    activity.startActivity(intent);
                    activity.finish();

                }else if(position==3)
                {
                    activity.startActivity(new Intent(activity, WriteAReason.class));
                    activity.finish();

                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==4)
                {
                    activity.startActivity(new Intent(activity, FillInTheBlank.class));
                    activity.finish();
                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==5)
                {
                    Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==6)
                {
                    activity.startActivity(new Intent(activity, MultipleChoiceQuestion.class));
                    activity.finish();

                   // Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==7)
                {
                    activity.startActivity(new Intent(activity, TrueFalse.class));
                    activity.finish();
                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==8)
                {
                    activity.startActivity(new Intent(activity, AnswerInOneLine.class));
                    activity.finish();

                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==9)
                {
                    activity.startActivity(new Intent(activity, DescribeBriefly.class));
                    activity.finish();

                   // Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==10)
                {
                    activity.startActivity(new Intent(activity, DifferentiateBetween.class));
                    activity.finish();
                   // Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==11)
                {
                    activity.startActivity(new Intent(activity, Exercise.class));
                    activity.finish();
                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==12)
                {
                    activity.startActivity(new Intent(activity, ShortNote.class));
                    activity.finish();
                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==13)
                {
                    Intent intent =new Intent(activity,MeaningOfAssignment.class);
                    Bundle extras = new Bundle();
                    extras.putString("screen_Name","ConceptOfTopic");
                    intent.putExtras(extras);
                    activity.startActivity(intent);
                    activity.finish();

                  //  Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }else if(position==14)
                {
                    activity.startActivity(new Intent(activity, VideoView_Activity.class));
                    activity.finish();
                 //   Toast.makeText(activity, "You Clicked "+result[position]+" position is "+position, Toast.LENGTH_SHORT).show();

                }




            }
        });
*/


        return rowView;
    }

    public void toast(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    public class Holder {
        TextView tv;
        ImageView img;
        RelativeLayout rel_meaning;
        CardView cardview_learndev;
    }

}
