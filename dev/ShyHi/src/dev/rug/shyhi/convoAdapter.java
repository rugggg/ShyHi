package dev.rug.shyhi;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class convoAdapter extends ArrayAdapter<Message>{

	private final Context context;
    //arraylist of films
    private ArrayList<Message> itemsArrayList;
    public convoAdapter(Context context, ArrayList<Message> itemsArrayList) {
        super(context, R.layout.list_item, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }	    
    
	//get custom list view item, inflate, and set proper data
	public View getView(int position, View convertView, ViewGroup parent) {
		//Create inflater 
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//init row view
		View rowView = inflater.inflate(R.layout.list_item, parent, false);
		//get and set layout elements
		TextView msgText = (TextView) rowView.findViewById(R.id.recentMsg);
		
		//set the textviews by accessing convo object
		msgText.setText((itemsArrayList.get(position).getMessage()));
			return rowView;
	}
}
