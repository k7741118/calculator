package wei.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	TextView tv1;
	Boolean bBegin=true;
	double Data=0;
	String Operator="=";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        
    }
    
    void findviews(){
    	
       tv1=(TextView)findViewById(R.id.textView1);  
       b0=(Button)findViewById(R.id.bt0);
       b0.setOnClickListener(btlistener);
       b1=(Button)findViewById(R.id.bt1);
       b1.setOnClickListener(btlistener);
       b2=(Button)findViewById(R.id.bt2);
       b2.setOnClickListener(btlistener);
       b3=(Button)findViewById(R.id.bt3);
       b3.setOnClickListener(btlistener);
       b4=(Button)findViewById(R.id.bt4);
       b4.setOnClickListener(btlistener);
       b5=(Button)findViewById(R.id.bt5);
       b5.setOnClickListener(btlistener);
       b6=(Button)findViewById(R.id.bt6);
       b6.setOnClickListener(btlistener);
       b7=(Button)findViewById(R.id.bt7);
       b7.setOnClickListener(btlistener);
       b8=(Button)findViewById(R.id.bt8);
       b8.setOnClickListener(btlistener);
       b9=(Button)findViewById(R.id.bt9);
       b9.setOnClickListener(btlistener);
       b10=(Button)findViewById(R.id.bt_plus);
       b10.setOnClickListener(btlistener);
       b11=(Button)findViewById(R.id.bt_sub);
       b11.setOnClickListener(btlistener);
       b12=(Button)findViewById(R.id.bt_mul);
       b12.setOnClickListener(btlistener);
       b13=(Button)findViewById(R.id.bt_div);
       b13.setOnClickListener(btlistener);
       b14=(Button)findViewById(R.id.bt_equal);
       b14.setOnClickListener(btlistener);
       b15=(Button)findViewById(R.id.bt_dot);
       b15.setOnClickListener(btlistener);
       b16=(Button)findViewById(R.id.bt_cl);
       b16.setOnClickListener(btlistener);
    	
    	
    	
    }
    
    OnClickListener btlistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			switch(v.getId()){
			
			case R.id.bt_cl:
			
				tv1.setText("0");
				Data=0;
				bBegin=true;
				break;
			case R.id.bt_plus:
			case R.id.bt_sub:
			case R.id.bt_mul:
			case R.id.bt_div:
			case R.id.bt_equal:
				
				inputOperater(((Button)v).getText().toString());
				break;
				
			default:
				inputNumber(((Button)v).getText().toString());
				break;
			
			}
			
			
			Log.d("what",((Button)v).getText().toString());
			
			
			
		}
	};
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    private void inputNumber(String str){
    	
    	if(bBegin)
    		
    		tv1.setText(str);
    	else
    		
    		tv1.append(str);
    		
    	bBegin=false;	
    	
    	
    }
    
    
    private void inputOperater(String opt){
    	
    	
    	try{
    		
    		double temp=Double.parseDouble(tv1.getText().toString());
    		if(bBegin){			
    			Operator=opt;
    		}else{
    			
    			if(Operator.equals("=")){
    				
    				Data=temp;
    		
    				
    			}else if(Operator.equals("+")){
    				
    				Data+=temp;
    				
    				
    			}else if (Operator.equals("-")){
    				
    				Data-=temp;		
    				
    			}else if(Operator.equals("*")){
    				
    				
    				Data*=temp;
    				
    				
    			}else if(Operator.equals("/")){
    				
    				if(temp!=0){
    					
    					Data/=temp;
    					
    				}else{
    					
    			        throw new ArithmeticException();	
 			    			
    				}
    						  				
    			}
    			
    			tv1.setText(String.valueOf(Data));
    			Operator=opt;
    		   			   			   		    		   		   			
    			
    		}
    			
    	}catch(NumberFormatException e){
    		
    		tv1.setText(" Number Format Error!");
    		
    		
    		
    		
    	}catch(ArithmeticException e){
    		
    		tv1.setText("Div Number CAN NOT BE  ZERO!");
    		
    		Operator="=";
    		
    		
    	}finally{
    		
    		bBegin=true;
    			  		
    	}
    	   	        	
    	
    	
    }
    
    
    
    
    
}
