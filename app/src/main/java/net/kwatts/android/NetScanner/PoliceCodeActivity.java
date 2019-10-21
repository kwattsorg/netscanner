package net.kwatts.android.NetScanner;

import java.io.InputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class PoliceCodeActivity extends Activity {

	public static final String MSG_TAG = "NetScanner";

    WebView mWebView;
	    
	
	public void onCreate(Bundle savedInstanceState) {
		 try {	
			super.onCreate(savedInstanceState);
			Log.d(MSG_TAG, "in onCreate()");
			
	  


			// was #DAAA
			setContentView(R.layout.policecodeview);
			
			ImageView image = (ImageView) findViewById(R.id.netscanner_logo);		
			image.setImageResource(R.drawable.antenna_blue_128x128);
			
			mWebView = (WebView) findViewById(R.id.policecode_webview);	

            StringBuilder outXML = new StringBuilder();


            outXML.append("<html><head><style type=\"text/css\">");
            outXML.append("body { font-size: .75em; }</style></head><body>");	
            
            outXML.append("<strong> 10-0</strong> Caution<br>" + 

           "<strong> 10-1</strong> Reception poor<br>" + 

           "<strong> 10-2</strong> Reception good<br>" + 

           "<strong>10-3</strong> Stop transmitting<br>" + 

           "<strong>  10-4</strong> Message received, understood<br>" + 

           "<strong> 10-5</strong> Repay message<br>" + 

           "<strong> 10-6</strong> Change channel<br>" + 

           "<strong> 10-7</strong> Out of service<br>" + 

           "<strong> 10-7A</strong> Out of service, home<br>" + 

           "<strong> 10-7B</strong> Out of service, personal<br>" + 

           "<strong> 10-8</strong> In service<br>" + 

           "<strong> 10-9</strong> Repeat message<br>" + 

           "<strong> 10-10</strong> Off duty<br>" + 

           "<strong> 10-10A</strong> Off duty, home<br>" + 

           "<strong> 10-11</strong> Identify frequency<br>" + 

           "<strong> 10-12</strong> Visitor(s) present<br>" + 

           "<strong> 10-13</strong> Weather and road advice<br>" + 

           "<strong> 10-14</strong> Citizen w/suspect<br>" + 

           "<strong>  10-15</strong> Prisoner in custody<br>" + 

           "<strong> 10-16</strong> Pick up prisoner<br>" + 

           "<strong> 10-17</strong> Request for gasoline<br>" + 

           "<strong> 10-18</strong> Equipment exchange<br>" + 

           "<strong> 10-19</strong> Return(ing) to station<br>" + 

           "<strong> 10-20</strong> Location<br>" + 

           "<strong> 10-21</strong> Telephone<br>" + 

           "<strong> 10-21A</strong> Advise home I will return at:<br>" + 

           "<strong> 10-22</strong> Disregard last assignment<br>" + 

           "<strong> 10-23</strong> Stand by<br>" + 

           "<strong> 10-24</strong> Request car-to-car transmit<br>" + 

           "<strong> 10-25</strong> Do you have contact with:<br>" + 

           "<strong> 10-26</strong> Clear<br>" + 

           "<strong> 10-27</strong> D.D.L. report<br>" + 

           "<strong> 10-28</strong> Registration request<br>" + 

           "<strong> 10-29</strong> Check for wants<br>" + 

           "<strong> 10-29F</strong> Subject wanted, felony<br>" + 

           "<strong> 10-29H</strong> Hazard potential from subject<br>" + 

           "<strong> 10-29M</strong> Subject wanted, Misdemeanor<br>" + 

           "<strong> 10-29V</strong> Vehicle wanted<br>" + 

           "<strong> 10-30</strong> Doesn't conform to regulations<br>" + 

           "<strong> 10-32</strong> Drowning<br>" + 

           "<strong> 10-33</strong> Alarm sounding, audible <br>" + 

           "<strong> 10-34</strong> Assist at office<br>" + 

           "<strong> 10-35</strong> Time check<br>" + 

           "<strong> 10-36</strong> Confidential information<br>" + 

           "<strong> 10-37</strong> Identify operator<br>" + 

           "<strong> 10-39</strong> Can () come to the radio?<br>" + 

           "<strong> 10-40</strong> Is () available for phone call?<br>" + 

           "<strong> 10-42</strong> Check the welfare of/at:<br>" + 

           "<strong> 10-43</strong> Call a doctor<br>" + 

           "<strong> 10-45</strong> Condition of patient?<br>" + 

           "<strong> 10-45A</strong> Good<br>" + 

           "<strong> 10-45B</strong> Serious<br>" + 

           "<strong> 10-45C</strong> Critical<br>" + 

           "<strong> 10-45D</strong> Dead<br>" + 

           "<strong> 10-49</strong> Proceed to:<br>" + 

           "<strong> 10-50</strong> Under influence of drugs<br>" + 

           "<strong> 10-51</strong> Drunk<br>" + 

           "<strong> 10-52</strong> Resuscitator<br>" + 

           "<strong> 10-53</strong> Man down<br>" + 

           "<strong> 10-54</strong> Possible dead body<br>" + 

           "<strong> 10-55</strong> Coroner case<br>" + 

           "<strong> 10-56</strong> Suicide<br>" + 

           "<strong> 10-56A</strong> Suicide attempt<br>" + 

           "<strong> 10-57</strong> Missing person<br>" + 

           "<strong> 10-59</strong> Security check<br>" + 

           "<strong> 10-60</strong> Lock-out<br>" + 

           "<strong> 10-61</strong> Miscellaneous public service<br>" + 

           "<strong> 10-62</strong> Meet a citizen<br>" + 

           "<strong> 10-62A</strong> Take a report from a citizen<br>" + 

           "<strong> 10-62B</strong> Civilian standby<br>" + 

           "<strong> 10-63</strong> Prepare to copy<br>" + 

           "<strong> 10-64</strong> Found property<br>" + 

           "<strong> 10-66</strong> Suspicious person<br>" + 

           "<strong> 10-67</strong> Person calling for help<br>" + 

           "<strong> 10-68</strong> Telephone for police<br>" + 

           "<strong> 10-70</strong> Prowler<br>" + 

           "<strong> 10-71</strong> Shooting<br>" + 

           "<strong> 10-72</strong> Gun involved<br>" + 

           "<strong> 10-73</strong> How do you receive?<br>" + 

           "<strong> 10-79</strong> Bomb threat<br>" + 

           "<strong> 10-80</strong> Explosion<br>" + 

           "<strong> 10-86</strong> Any radio traffic?<br>" + 

           "<strong> 10-88</strong> Assume post<br>" + 

           "<strong> 10-91</strong> Animal<br>" + 

           "<strong> 10-91A</strong> Animal, stray<br>" + 

           "<strong> 10-91B</strong> Animal, noisy<br>" + 

           "<strong> 10-91C</strong> Animal, injured<br>" + 

           "<strong> 10-91D</strong> Animal, dead<br>" + 

           "<strong> 10-91E</strong> Animal, bite<br>" + 

           "<strong> 10-91G</strong> Animal, pickup<br>" + 

           "<strong> 10-91J</strong> Animal, pickup collect<br>" + 

           "<strong> 10-91L</strong> Animal, leash law violation<br>" + 

           "<strong> 10-91V</strong> Animal, vicious<br>" + 

           "<strong> 10-95</strong> Need ID tech unit<br>" + 

           "<strong> 10-97</strong> Arrived at scene<br>" + 

           "<strong>  10-98</strong> Available to assign <br>" + 



           "<hr><strong> Police Scanner 1-37 Codes...</strong><hr>" + 


           "<strong> Code 2</strong> Urgent - no light or siren<br>" + 

           "<strong> Code 3</strong> Use lights and siren<br>" + 

           "<strong> Code 4</strong> No further assistance needed<br>" + 

           "<strong> Code 5</strong> Stakeout<br>" + 

           "<strong> Code 6</strong> Stay out of area<br>" + 

           "<strong> Code 7</strong> Meal break<br>" + 

           "<strong> Code 8</strong> Restroom break<br>" + 

           "<strong> Code 9</strong> Summer uniform<br>" + 

           "<strong> Code 10</strong> SWAT pre-call up<br>" + 

           "<strong> Code 11</strong> SWAT Call up<br>" + 

           "<strong> Code 37</strong> Subject/Property wanted <br>" + 
           "<strong> 11-10</strong> Take report <br>" +  

         "<strong> 11-24</strong> Abandoned vehicle<br>" + 

         "<strong> 11-25</strong> Traffic hazard<br>" + 

         "<strong> 11-26</strong> Abandoned bicycle<br>" + 

         "<strong> 11-27 </strong>10-27 W/driver held<br>" + 

         "<strong> 11-28 </strong>10-28 W/driver held<br>" + 

         "<strong> 11-40</strong> Advise if ambulance needed<br>" + 

         "<strong> 11-41</strong> Ambulance needed<br>" + 

         "<strong> 11-42</strong> No ambulance needed<br>" + 

         "<strong> 11-44</strong> Deceased person (Coroner Req'd) <br>" + 

         "<strong> 11-48</strong> Furnish transportation<br>" + 

         "<strong> 11-51</strong> Escort<br>" + 

         "<strong> 11-52</strong> Funeral detail<br>" + 

         "<strong> 11-54</strong> Suspicious vehicle<br>" + 

         "<strong> 11-55</strong> Officer being followed by auto<br>" + 

         "<strong> 11-56</strong> 11-55 W/dangerous persons<br>" + 

         "<strong> 11-57</strong> Unidentified auto at assignments<br>" + 

         "<strong> 11-58</strong> Radio monitored, use phone<br>" + 

         "<strong> 11-59</strong> Intensive attention: high hazard, business areas<br>" + 

         "<strong> 11-60</strong> Attack in high hazard area<br>" + 

         "<strong> 11-65</strong> Signal light out<br>" + 

         "<strong> 11-66</strong> Defective signal light<br>" + 

         "<strong> 11-78</strong> Aircraft accident<br>" + 

         "<strong> 11-79</strong> Accident - Ambulance sent<br>" + 

         "<strong> 11-80</strong> Accident - Major injuries<br>" + 

         "<strong> 11-81</strong> Accident - Minor injuries<br>" + 

         "<strong> 11-82</strong> Accident - No injuries<br>" + 

         "<strong> 11-83</strong> Accident - No detail<br>" + 

         "<strong> 11-84</strong> Direct traffic<br>" + 

         "<strong> 11-85</strong> Tow truck required<br>" + 

         "<strong> 11-94</strong> Pedestrian stop<br>" + 

         "<strong> 11-95</strong> Routine traffic stop<br>" + 

         "<strong> 11-96</strong> Checking suspicious vehicle<br>" + 

         "<strong> 11-97</strong> Time/security check on patrol<br>" + 

         "<strong> 11-98</strong> Meet:<br>" + 

         "<strong> 11-99</strong> Officer needs help! <br>" + 

         "<hr><strong> Police Scanner Codes... </strong><hr>" + 


         "<strong> 187</strong> Homicide<br>" + 

         "<strong> 207</strong> Kidnapping<br>" + 

         "<strong> 207A</strong> Kidnapping attempt<br>" + 

         "<strong> 211</strong> Robbery<br>" + 

         "<strong> 211A</strong> Robbery alarm<br>" + 

         "<strong> 211S</strong> Robbery alarm, silent<br>" + 

         "<strong> 217</strong> Assault with intent to murder<br>" + 

         "<strong> 240</strong> Assault<br>" + 

         "<strong> 242</strong> Battery<br>" + 

         "<strong> 245</strong> Assault with a deadly weapon<br>" + 

         "<strong> 246</strong> Shooting at inhabited dwelling<br>" + 

         "<strong> 261</strong> Rape<br>" + 

         "<strong> 261A</strong> Attempted rape<br>" + 

         "<strong> 273A</strong> Child neglect<br>" + 

         "<strong> 273D</strong> Wife beating - Felony<br>" + 

         "<strong> 288</strong> Lewd conduct<br>" + 

         "<strong> 311</strong> Indecent exposure<br>" + 

         "<strong> 314</strong> Indecent exposure<br>" + 

         "<strong> 374B</strong> Illegal dumping<br>" + 

         "<strong> 390</strong> Drunk<br>" + 

         "<strong> 390D</strong> Drunk, unconscious<br>" + 

         "<strong> 415</strong> Disturbance<br>" + 

         "<strong> 417</strong> Person with a gun<br>" + 

         "<strong> 417A</strong> Person with a knife<br>" + 

         "<strong> 459</strong> Burglary<br>" + 

         "<strong> 459A</strong> Burglar alarm<br>" + 

         "<strong> 459S</strong> Burglar alarm, silent<br>" + 

         "<strong> 470</strong> Forgery<br>" + 

         "<strong> 480</strong> Hit and run - Felony<br>" + 

         "<strong> 481</strong> Hit and run - Misdemeanor<br>" + 

         "<strong> 484</strong> Petty theft<br>" + 

         "<strong> 487</strong> Grand theft<br>" + 

         "<strong> 488</strong> Petty theft<br>" + 

         "<strong> 502</strong> Drunk Driving<br>" + 

         "<strong> 503</strong> Auto theft<br>" + 

         "<strong> 504</strong> Tampering with a vehicle<br>" + 

         "<strong> 505</strong> Reckless driving<br>" + 

         "<strong> 507</strong> Public nuisance<br>" + 

         "<strong> 510</strong> Speeding or racing vehicles<br>" + 

         "<strong> 586</strong> Illegal parking<br>" + 

         "<strong> 594</strong> Malicious mischief<br>" + 

         "<strong> 595</strong> Runaway car<br>" + 

         "<strong> 604</strong> Throwing missiles<br>" + 

         "<strong> 647</strong> Lewd conduct<br>" + 

         "<strong> 653M</strong> Threatening phone calls <br>" + 

         "<hr><strong> Police Scanner Codes... </strong> <hr>" + 


         "<strong> Code Blue</strong> Bus/Cab in trouble<br>" + 

         "<strong> Code Red</strong> Varda Alarm activated<br>" + 

         "<strong> Code Purple</strong> Gang Activity <br>" + 

         "<hr><strong> Medical / Fire Status Codes...</strong><hr>" +  


         "<strong> Code 10</strong> Critical Trauma case<br>" + 

         "<strong> Code 20</strong> Acute Trauma case<br>" + 

         "<strong> Code 30</strong> Trauma case<br>" + 

         "<strong> Code 40</strong> Serious case (IV started)<br>" + 

         "<strong> Code 50</strong> Basic transport (not serious)<br>" + 

         "<strong> Code N</strong> Newsworthy event <br>" + 

         "<hr><strong> Police Scanner Codes...</strong><hr>" +

         "<strong> 5150</strong> Mental case<br>" + 

         "<strong> 10851</strong> Auto theft<br>" + 

         "<strong> 10852</strong> Tampering with vehicle<br>" + 

         "<strong> 20001</strong> Hit and run - Felony<br>" + 

         "<strong> 20002</strong> Hit and run - Misdemeanor<br>" + 

         "<strong> 20007</strong> Hit and run - Unattended<br>" + 

         "<strong> 21958</strong> Drunk pedestrian on roadway<br>" + 

         "<strong> 22350</strong> Speeding<br>" + 

         "<strong> 22500</strong> Illegal parking<br>" + 

         "<strong> 23101</strong> Drunk driving - injuries<br>" + 

         "<strong> 23102</strong> Drunk driving<br>" + 

         "<strong> 23103</strong> Reckless driver<br>" + 

         "<strong> 23104</strong> Reckless driver<br>" + 

         "<strong> 23105</strong> Driver under narcotics<br>" + 

         "<strong> 23109</strong> Racing<br>" + 

         "<strong> 23110</strong> Person throwing objects at vehicles<br>" + 
         "<strong> 23151</strong> Drunk driving - injuries<br>" + 
         "<strong> 23152</strong> Drunk driver <br>");

           


           
	    	mWebView.loadData(outXML.toString(), "text/html", "utf-8");

			
            
			
		 } catch (Exception e) { 
			 Log.d(MSG_TAG, "Error displaying caller information: ");
			 e.printStackTrace();  
		 } 
		
		}
	//Then add a list item click listener.
	//public void onListItemClick(ListView parent, View v, int position, long id) {
	    //Do something here.	
//	}
	
    
	
	protected void onResume() {
        super.onResume();
    }
    
    protected void onPause() {
        super.onPause();
    }
     
    protected void onStart() {
    	super.onStart();
    }
    protected void onDestroy() {
    	super.onDestroy();
    }
    
}
    
