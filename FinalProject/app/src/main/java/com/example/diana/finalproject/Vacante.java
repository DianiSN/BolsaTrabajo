package com.example.diana.finalproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Vacante extends AppCompatActivity implements View.OnClickListener
{

    Button bAplicar;
    ImageButton bFavorites;
    TextView tvDescripcion;
    int image,position;
    String name,matricula;
    boolean favorite = false;

    String [] companies;
    int [] logos;

    SingletonFavorites fav;


    //    name of the companies
//    public static String [] company ={"Amazon","Apple","Cisco","Dell","Ebay","Facebook","GE","Google","HP",
//            "Intel","Logitech","Microsoft","Oracle","TI","Yelp"};

    public static String [] job ={"AWS Big Data Architect - Professional Services (San Francisco)","Apple","Cisco","Dell","Ebay","Data Engineer, Analytics, Intern/Co-op (Summer 2016) (Menlo Park, CA)","GE","Google","HP",
            "Intel","Logitech","Microsoft","Oracle","TI","Yelp"};

    public static String [] description ={"Are you a Big Data specialist? Do you have Data Warehousing and/or Hadoop experience? Do you like to solve the most complex and high scale (billion + records) data challenges in the world today? Do you want to have an impact in the development and use of new data analytics technologies? Would you like a career that gives you opportunities to help customers and partners use cloud computing web services to do big new things faster, at lower cost? Do you like to gain the deepest customer and partner insights using Cloud computing technologies?\n" +
            "At AWS, we’re hiring highly technical cloud computing architects to collaborate with our customers and partners on key engagements. Our consultants will develop and deliver proof-of-concept projects, technical workshops, and support implementation projects. These professional services engagements will focus on customer solutions such as HPC, batch data processing, Big Data and Business intelligence. This role will specifically focus on Data processing capabilities and helping our customers and partners to remove the constraints that prevent our customers from leveraging their data to develop business insights.\n" +
            "\n" +
            "Responsibilities include:\n" +
            "· Expertise - Collaborate with AWS field sales, pre-sales, training and support teams to help partners and customers learn and use AWS services such as Amazon Elastic Compute Cloud (EC2), Amazon Data Pipeline, S3, DynamoDB NoSQL, Relational Database Service (RDS), Elastic Map Reduce (EMR) and Amazon Redshift.\n" +
            "· Solutions - Deliver on-site technical engagements with partners and customers. This includes participating in pre-sales on-site visits, understanding customer requirements, creating consulting proposals and creating packaged Big Data service offerings.\n" +
            "· Delivery - Engagements include short on-site projects proving the use of AWS services to support new distributed computing solutions that often span private cloud and public cloud services. Engagements will include migration of existing applications and development of new applications using AWS cloud services.\n" +
            "\n" +
            "Amazon aims to be the most customer centric company on earth. Amazon Web Services (AWS) provides a highly reliable, scalable, low-cost infrastructure platform in the cloud that powers critical applications for hundreds of thousands of businesses in 190 countries around the world.\n" +
            "\n" +
            "\n" +
            "** For more information on Amazon Web Services, please visit http://aws.amazon.com","Apple","Cisco","Dell","Ebay","Facebook was built to help people connect and share, and over the last decade our tools have played a critical part in changing how people around the world communicate with one another. With over a billion people using the service and more than fifty offices around the globe, a career at Facebook offers countless ways to make an impact in a fast growing organization.\n" +
            "Would you like to work with big data? Do you want to use data to influence product decisions for products being used by over half a billion people every day? If yes, we want to talk to you. Our data warehouse team works very closely with Product Managers, Product Analysts and Internet Marketers to figure out ways to acquire new users, retain existing users and optimize user experience - all of this using massive amounts of data. In this role, you will see a direct link between your work, " +
            "company growth, and user satisfaction. You will work with some of the brightest minds in the industry, and you'll get an opportunity to solve some of the most challenging business problems on the web and mobile Internet, " +
            "at a scale that few companies can match. ","GE","Google","HP",
            "Intel","Logitech","Microsoft","Oracle","TI","Yelp"};

    //    name of the images linked to the names
//    public static int [] logo ={R.drawable.amazon,R.drawable.apple,R.drawable.cisco,R.drawable.dell
//            ,R.drawable.ebay,R.drawable.facebook,R.drawable.ge,R.drawable.google,R.drawable.hp,R.drawable.intel
//            ,R.drawable.logitech,R.drawable.microsoft,R.drawable.oracle,R.drawable.ti,R.drawable.yelp};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacante);

        Bundle b = getIntent().getExtras();
        image = b.getInt("image");
        name = b.getString("name");
        position = b.getInt("position");
        matricula = b.getString("matricula");
        bAplicar = (Button) findViewById(R.id.bAplicar);
        bAplicar.setOnClickListener(this);

        bFavorites = (ImageButton)findViewById(R.id.imageButton);
        bFavorites.setOnClickListener(this);

        if(fav.getInstance().findCompany(name) != 1){

            Log.d("CREATE","COMPANY FOUND vacanteFaves");


        }

        if(fav.getInstance().findCompany(name)!=-1){

            bFavorites.setImageResource(R.drawable.star2);

        }else if(fav.getInstance().findCompany(name)==-1){

            bFavorites.setImageResource(R.drawable.star1);
        }




        // dependiendo del click, carga la info correspondiente **

        ImageView im = (ImageView)findViewById(R.id.imageView1);
        im.setImageResource(image);

        TextView tv = (TextView)findViewById(R.id.tvDescripcion);
        tv.setText(description[position]);

        TextView tvName = (TextView)findViewById(R.id.companyName);
        tvName.setText(name+"\n\n"+job[position]);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) // menu dropdown
    {
        Log.i("CREATION", "Menu dropdown");
        int id = item.getItemId();
        if (id == R.id.action_logout)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed()
    {
        Log.d("CREATION", "go back pressed!");
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStackImmediate();
        }else
        {
            Intent intent = new Intent(this, ShowTabs.class);
            Bundle b = new Bundle();
            b.putString("image",null);
            b.putInt("current", 1);
            b.putString("matricula",matricula);
            intent.putExtras(b);
            startActivity(intent);
        }
    }



    public void onClick(View v) // botones
    {
        switch (v.getId())
        {
            case R.id.bAplicar: // se ha picado el boton para aplicar a la vacante
                Log.i("CREATION", "Aplicar");
                finish();
                Intent i = new Intent(this,Solicitud.class);
                Bundle b = new Bundle();
                b.putString("vacancy",job[position]);
                b.putString("name",name);
                b.putString("matricula",matricula);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.imageButton: // se ha picado el boton para ponerlo en favoritos
                Log.i("CREATION", "Favorites");
                if(fav.getInstance().findCompany(name)!=-1){

                    fav.getInstance().removeCompany(position);
                    bFavorites.setImageResource(R.drawable.star1);

                }else if(fav.getInstance().findCompany(name)==-1){
                    fav.getInstance().addCompany(name,image);
                    bFavorites.setImageResource(R.drawable.star2);
                }
                break;
        }
    }


}
