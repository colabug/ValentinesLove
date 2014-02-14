package com.colabug.love;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoveFragment extends Fragment
{
    // Bundle arguments
    private static final String ARG_TITLE = "title";
    private static final String ARG_IMAGE_ID = "image_id";

    public LoveFragment ()
    {
    }

    /**
     * Returns a new instance of this fragment with bundled data.
     *
     * @param viewDataItem - contains title and image id to display
     */
    public static LoveFragment newInstance (ViewDataItem viewDataItem)
    {
        LoveFragment fragment = new LoveFragment();

        fragment.setArguments( getArgumentBundle( viewDataItem ) );

        return fragment;
    }

    /**
     * Returns a bundle with title and image data.
     *
     * @param viewDataItem - contains title and image id to display
     */
    private static Bundle getArgumentBundle (ViewDataItem viewDataItem)
    {
        Bundle args = new Bundle();

        args.putString( ARG_TITLE, viewDataItem.getTitle() );
        args.putInt( ARG_IMAGE_ID, viewDataItem.getImageId() );

        return args;
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState)
    {
        View layout = inflater.inflate( R.layout.fragment_love, container, false );

        // Configure image
        ImageView imageView = (ImageView) layout.findViewById( R.id.image );
        imageView.setImageResource( getArguments().getInt( ARG_IMAGE_ID ) );

        return layout;
    }

    /**
     * Changes the title when a new section is attached.
     *
     * @param activity - activity to which the fragment is attached
     */
    @Override
    public void onAttach (Activity activity)
    {
        super.onAttach( activity );
        ((LoveActivity) activity).onSectionAttached( getArguments().getString( ARG_TITLE ) );
    }
}