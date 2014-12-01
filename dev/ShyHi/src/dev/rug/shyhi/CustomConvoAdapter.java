package dev.rug.shyhi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomConvoAdapter extends BaseAdapter implements OnClickListener{
	
	
	private Activity activity;
	private ArrayList convos; 
	private static LayoutInflater inflater = null; 
	public Resources res;
	Convo tempValues = null;
	int i = 0;									//Declared necessary variables
	
	//Custom Adapter Constructor
	public void CustomAdapter(Activity a, ArrayList d, Resources resLocal)
	{
		activity = a;
		convos = d;
		res = resLocal;							//Reassign past values
		
		//Layout inflater to call xml
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		
	}
	
	//Get number of items to display
	public int getCount() {
          
        if(convos.size()<=0)
            return 1;
        return convos.size();
    }
	
	public Object getItem(int position) {
        return position;
    }
  
    public long getItemId(int position) {
        return position;
    }
      
    //Create a holder Class to contain inflated xml file elements 
    public static class ViewHolder{
         
    	public TextView anonNumber;
    	public ImageView onlineStatus;
    	public TextView convoText;
    	public TextView textDate;
    	 
    }
    
    
    //Create each listRowItem 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View vi = convertView;
		ViewHolder holder;
		
		if(convertView == null)
		{
			//Inflate listview with each row
			vi = inflater.inflate(R.layout.activity_conversations, null);
			
			//View Holder to contain elements
			holder = new ViewHolder();
			holder.anonNumber = (TextView)vi.findViewById(R.id.textView1);
			holder.onlineStatus = (ImageView)vi.findViewById(R.id.imageView1);
			holder.convoText = (TextView)vi.findViewById(R.id.textView2);
			holder.textDate = (TextView)vi.findViewById(R.id.textView3);
			
			//Set holder with inflater
            vi.setTag( holder );
			
		}
		else 
            holder=(ViewHolder)vi.getTag();
         
        if(convos.size()<=0)
        {
            holder.anonNumber.setText("No Data");				//In case no conversations
             
        }
        else
        {
            //Get each model object 
            tempValues=null;
            tempValues = (Convo)convos.get( position );
             
            
            //Sets model values
            holder.anonNumber.setText(tempValues.getUser2());	//Is this the anon#? 
            holder.convoText.setText(tempValues.getMostRecentMessage());
            holder.textDate.setText(tempValues.getId());				//What valuue in Convo class represents the text date?
            holder.onlineStatus.setImageResource(
            		res.getIdentifier(
            				"dev.rug.shyhi:drawable/online"
            				,null,null));
        }
        return vi;
    }
     
    @Override
    public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked=====");
    }
     
   
}

        
