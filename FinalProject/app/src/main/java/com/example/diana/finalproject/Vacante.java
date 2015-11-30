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

    public static String [] job ={"AWS Big Data Architect - Professional Services (San Francisco)","Engineering Project Management Intern","Software Engineering Intern: Core OS","Software Dev Advisor","Software Engineer Intern - Undergrad","Data Engineer, Analytics, Intern/Co-op (Summer 2016) (Menlo Park, CA)","Staff Software Engineer","Analytical Lead, Big Box Retail Vertical","Web Development Engineer",
            "Embedded Firmware Developer","Mobile Developer","Development (engineering)","Database Administrator","Analog Design Engineer","Data Scientist - New Grad"};

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
            "** For more information on Amazon Web Services, please visit http://aws.amazon.com",
            "The Engineering Project Manager intern (EPM-intern) will work at the system level, shipping Mac products in engineering/quality improvements/new suppliers qualifications areas. This particular role will focus on driving supply driven qualifications. The EPM-intern will coordinate with system EPMs to lead cross-functional team and china OEM (Original Equipment Manufacturer) teams to ensure supply changes are properly validated within engineering. This role includes identifying, evaluating, and driving the various activities while clearly communicating the risks, priorities and schedules to the cross-functional team. ",

            "Must be currently enrolled in a BS/MS/PhD program in Computer Science, Electrical Engineering, Design, or related fields. Must also return to school after the internship to continue education or an internship must be required for graduation from your school.\nKey Qualifications\n" +
                    "\n" +
                    "Proficiency with C/C++\n" +
                    "Experience with scripting languages such as Python, Perl, or Ruby\n" +
                    "Experience with UNIX and/or the OS X command line\n" +
                    "Have taken an Operating Systems or Systems Development course in college\n" +
                    "Experience with compiler development is a plus\n" +
                    "Experience with Embedded Systems\n" +
                    "Strong analytical and problem solving skills\n" +
                    "Excellent written and verbal communication skills",

            "Software Dev Advisor position in the Application Development and Maintenance (ADM) Services group in Dell India, primarily focusing on working with Dell’s global clients. Looking for senior candidates with extensive experience in C#, ASP MVC .Net Framework including object-oriented programming, HTML/CSS/JavaScript. Candidates should be excellent team players, yet capable of working independently. Candidates will work with very little direction, will be comfortable leading conference calls and flexible to working collaboratively with a globally dispersed Dell Services team.",

            "Primary Job Responsibilities: We’re working on cool stuff here!\n" +
                    "\n" +
                    "eBay is changing the way people connect and shop around the world. When you work for eBay, you become a part of a global company. Our interns and new hires are revolutionizing commerce by building apps, creating new platforms, and solving complex problems at a massive scale. What you work on here impacts the lives of millions every day.\n" +
                    "\n" +
                    "Software engineers at eBay develop innovative solutions and high quality products that touch millions of people every day around the globe. Our engineers solve some of the most complex technical problems in the world of connected commerce across all business units. We’re looking for the highest levels of technical talent and programming skills, as well as a keen desire to deeply understand our products and services to push our technology forward with respect to functionality, performance, reliability, and scalability.\n" +
                    "\n" +
                    "You’ll work alongside the best and the brightest engineering talent in the industry. We have opportunities in a wide range of areas including development, design, search, platform, test, quality, big data, front end, and back end. As a core participant of your team, you’ll estimate engineering efforts, prioritize projects, plan implementations, and triage production issues. You need to be dynamic, collaborative, and curious as we build new experiences, improve existing products, and develop distributed systems powering the world’s largest e-commerce websites at a scale few companies can match.",

            "Facebook was built to help people connect and share, and over the last decade our tools have played a critical part in changing how people around the world communicate with one another. With over a billion people using the service and more than fifty offices around the globe, a career at Facebook offers countless ways to make an impact in a fast growing organization.\n" +
            "Would you like to work with big data? Do you want to use data to influence product decisions for products being used by over half a billion people every day? If yes, we want to talk to you. Our data warehouse team works very closely with Product Managers, Product Analysts and Internet Marketers to figure out ways to acquire new users, retain existing users and optimize user experience - all of this using massive amounts of data. In this role, you will see a direct link between your work, " +
            "company growth, and user satisfaction. You will work with some of the brightest minds in the industry, and you'll get an opportunity to solve some of the most challenging business problems on the web and mobile Internet, " +
            "at a scale that few companies can match. ",

            "We are looking for a Staff Software Engineer to work in a team made up of developers, Quality Engineers, User Interaction Design Engineers, Architects, and the Product Owner team to lead the design, development, and delivery of high quality software in a fast paced, challenging, and creative environment.\n" +
                    "\n" +
                    "In this role, you will: \n" +
                    "Capture system level requirements by brainstorming with Sr. Architects, Data Scientists, Businesses & Product Managers \n" +
                    "Execute in a fast pace delivery mode and focus in delivering tasks to meet the product release goal\n" +
                    "Be responsible for the design, develop and test multiple software modules \n" +
                    "Ensure implementation meets design objectives \n" +
                    "Investigate and evaluate new technologies\n" +
                    "Establish yourself as a thought leader across the software organization related to edge-device and real-time software design and coding principals interfacing to cloud computing architectures \n" +
                    "Collaborate with other software developers in the team to implement software that align and extend platforms and systems for industrial internet\n" +
                    "Join a high-performing Agile team adept in the ways of scrum and test driven development",

            "As a Google Analytical Lead, you will work with the largest advertising agencies and clients. You will work as a team member on Google's industry-focused Sales teams, exchanging knowledge regarding client and agency needs within specific industry sectors. You will work with Account Planning and Marketing to present integrated, data-driven business opportunities based on internal and external tools analysis, and will also work with Account Management and Account Executives to identify business opportunities (i.e. keyword expansion, improved account structures and ad text).\n" +
                    "\n" +
                    "Responsibilities\n" +
                    "Provide customized insights to customers that inform business and media decisions. Partner with Account Executives and Managers to incorporate insights into presentation narratives.\n" +
                    "Analyze data to identify new opportunities. Quantify business impact and investment required.\n" +
                    "Advise clients and agencies on best practices for marketing analytics, measurement and attribution. Help customers navigate industry best practices and alternatives.\n" +
                    "Build deep client relationships using insights and quantified impact to improve their business.\n" +
                    "Partner with Google product, research and measurement teams to bring Google’s full analytical capabilities to customers.",

            "This is an exciting opportunity to develop and grow the web presence and rich processing required to massively scale this business for HP. We are looking for a few highly motivated and talented web developers (about to graduate, or recently graduated) to join the team and help grow our solution. This is an exciting time to join and learn agile, test-driven, pair programming, based around Ruby-on-Rails in a real and profitable business environment. Join the fast-paced organization that is reinventing printing for both the consumer and the commercial segment.",
            "We are developing high volume leading edge mixed signal RF products for the consumer market. We are looking for experienced embedded firmware engineers to work with the team to develop the embedded systems that control these complex products. \n" +
                    "\n" +
                    "You will work with cross functional teams that include digital hardware, analog and RF design, lab validation, and factory test. You will also complete firmware design and verification tasks at the block, subsystem, and top levels based on definitions provided.",
            "Design and implement new customer-facing features for the Logitech Arx Control\n" +
                    "\n" +
                    "Work with the UX team to create fun, easy-to-use client applications (applets)\n" +
                    "\n" +
                    "Optimize applications to support Logitech | G device specific features\n" +
                    "\n" +
                    "Contribute to the overall design architecture\n" +
                    "\n" +
                    "Create something unique that you will use yourself      ",
            "Software engineers at Microsoft are passionate about building technologies that make the world a better place. At Microsoft, you will collaborate with a team of programming experts to solve problems and build some of the world’s most advanced services and devices. Your efforts on the design, development, and testing of next-generation applications will have an impact on millions of people.\n" +
                    "\n" +
                    "You are the link between abstract concepts and delivered solutions – the one who understands the consumer, solving problems, and building applications that will impact millions of people.\n" +
                    "\n" +
                    "Applications to this opportunity are considered for all available Development (engineering) roles.",
            "The Oracle Health Sciences Applications suite leads the market for pharmaceutical, biotechnology, and medical device research applications in the rapidly expanding life sciences industry. These products provide integrated services to control and automate the drug and medical device development process. They consistently improve data quality and cut months off the clinical trials phase of research, benefiting thousands of lives by bringing better, safer drugs and medical devices to market sooner.\n" +
                    "Our team is a group of highly motivated and dedicated people hand-picked from the best universities and the clinical trials industry. We value intangibles like initiative, creativity, and innovation. Developers work with cutting edge technologies and interact seamlessly with our industry-expert product management, quality assurance, documentation, and customer support teams. \n" +
                    "Our team is primarily responsible to install, configure and integrate Oracle Health Sciences Global Business Unit (HSGBU) products tech stack. This position requires a strong experience with breadth and depth in Linux, Windows systems, and Oracle products like database & FMW. The individual will have to undertake deep dive sessions to understand the installation, configuration and integration of various HSGBU products and work on product deployment automation.",
            "• Good analog fundamentals \n" +
                    "• Block-level analog design. Example blocks: opamps, comparators, current generators, etc. \n" +
                    "• Verification of blocks across PVT, statistical mismatch \n" +
                    "• Should be able to run mixed-signal simulations using tools such as Cadence AMS. \n" +
                    "• Mixed-mode top-level verification \n" +
                    "• Behavioural modelling of analog blocks in Verilog AMS \n" +
                    "• Good documentation\n" +
                    "Job Opening Type\tExperienced Professional\n" +
                    "Minimum Education Level\tBachelor's Level Degree",
            "At Yelp, we see our 71 million reviews not only as a great source of information about the best salted caramel ice cream in San Francisco, but also as a vast storehouse of data. You will help us use that data to connect our users with great local businesses. You will work tightly with the Product and Engineering teams to answer questions ranging from who is more likely to like a flavor of ice cream to which experimental features move the needle. In this role you’ll be tackling a variety of projects ranging from design and analysis of A/B tests to data-driven blog posts. As your role grows you’ll identify new analyses, scope new data-driven products and help us define new metrics.\n" +
                    "\n" +
                    "If you’re passionate about asking and answering questions in large datasets and you are able to communicate that passion to product and engineering teams, we want to hear from you!"};

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
